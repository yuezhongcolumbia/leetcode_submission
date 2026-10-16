class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int n = seq.length();
        int depth = 0;
        int[] res = new int[n];
        for(int i = 0; i < n; i++){
            if (seq.charAt(i) == '('){
                depth++;
                res[i] = depth % 2; 
            } else {
                res[i] = depth % 2; 
                depth--;
            }
        }
        return res;
       
    }
}