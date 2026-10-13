class Solution {
    public long minimumSteps(String s) {
        // 0101

        // 1000

        // 1100

        // 10100011
        int n = s.length();
        int restorePos = n - 1;
        long res = 0L;
        for(int i = n - 1; i >= 0; i--){
            char cur = s.charAt(i);
            if (cur == '0') continue;
            res += (long)(restorePos - i);
            restorePos--;
        }
        return res;
        

    }
}