class Solution {
    public int shipWithinDays(int[] weights, int days) {
    //  FFFTTT  
        int maxWeight = 0;
        int sum = 0;
        for (int weight: weights){
            maxWeight = Math.max(maxWeight, weight);
            sum += weight;
        }
        int l = maxWeight;
        int r = sum;
        int res = 0;
        while (l <= r){
            int m = (l + r) >> 1;
            if (feasible(weights, days, m)){
                res = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        } 
        return res;

    }
   
    public boolean feasible(int[] weights, int days, int capacity){
        int count = 1;
        int curSum = 0;
        for(int weight:weights){
            curSum += weight;
            if (curSum > capacity){
                curSum = weight;
                count++;
            }
            if (count > days) return false;
        }
        return true;
    }

}