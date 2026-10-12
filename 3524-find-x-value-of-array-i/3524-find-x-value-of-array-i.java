class Solution {
    int[] nums;
    int k;
    long[][] memo;
    public long[] resultArray(int[] nums, int k) {
        this.nums = nums;
        this.k = k;
        int n = nums.length;
        memo = new long[n][];
        
        long[] res = new long[k];
        for(int i = 0; i < n; i++){
            dfs(i);
            for(int j = 0; j < k; j++){
                res[j] += memo[i][j];
            }
        }
        return res;
    }
    public long[] dfs(int i){
        // if (i == 0){
        //     long[] tmp = new long[k];
        //     tmp[nums[0] % k] ++;
        //     return memo[0] = tmp;
            
        // }
        if (memo[i] != null) return memo[i];
        long[] layerState= new long[k];
        layerState[nums[i] % k] ++;

        if (i > 0){
            long[] prev = dfs(i - 1);
        for(int j = 0; j < prev.length; j++){
            int newMod = (j * (nums[i] % k) )% k;
            layerState[newMod] += prev[j];
        }
        }
        
        return memo[i] = layerState; 
    }
}