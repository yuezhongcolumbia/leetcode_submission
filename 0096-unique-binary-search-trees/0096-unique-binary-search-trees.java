class Solution {
    int[] memo;
    int n;
    public int numTrees(int n) {
        this. n = n;
        memo = new int[n + 1];
        memo[0] = 1;
        return count(n);
    }
    public int count(int nodes){
        if (memo[nodes]!= 0) return memo[nodes];
        
        
        int res = 0;
        for(int root = 1; root <= nodes; root++){
            int leftNodes = root - 1;
            int rightNodes = nodes - root;
            int leftCount = count(leftNodes);
            int rightCount = count(rightNodes);
            res += leftCount*rightCount;
        }
        return memo[nodes] = res;
    }
}