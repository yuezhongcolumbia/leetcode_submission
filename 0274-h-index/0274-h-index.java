class Solution {
    public int hIndex(int[] citations) {
        
        // 0 1 2 3 4
        // 3 0 6 1 5
       
        // 0 1 2 3 4 5
        // 1 1    1  2
        int n = citations.length;
        int[] count = new int[n + 1];
        for(int num: citations){
            count[Math.min(n, num)]++;
        }
        int papers = 0;
        for(int i = n; i >= 0; i--){
            papers += count[i];
            if (papers >= i) return i;
        }
        return 0;

        



        
    }
}