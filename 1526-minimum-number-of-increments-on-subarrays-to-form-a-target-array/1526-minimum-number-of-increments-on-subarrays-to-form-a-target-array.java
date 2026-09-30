class Solution {
    public int minNumberOperations(int[] target) {
        int res = 0;
        for(int i = 0; i < target.length - 1; i++){
            res += Math.max(0, target[i] - target[i + 1]);
        }
        res += target[target.length - 1];
        return res;

    }
}