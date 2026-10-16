class Solution {
    public int minOperations(int[] nums, int x) {
    //    max length subarray such that Sum - SumSubarray = x

    //    11 - 5 = 6

    //    30- 10 = 20
        int sum = 0;
        int n = nums.length;
        for(int num: nums){
            sum += num;
        }
        int maxSubArrSum = sum - x;
        if (maxSubArrSum < 0) return -1;
        if (maxSubArrSum == 0) return nums.length;

        int curSum = 0;
        int l = 0;
        int res = Integer.MIN_VALUE;
        for(int r = 0; r < n; r++){
            curSum += nums[r];
            while (l < r && curSum > maxSubArrSum){
                curSum-= nums[l];
                l++;
            }
            if (maxSubArrSum == curSum){
               res = Math.max(res, r - l + 1); 
            }
            

        }
        return res != Integer.MIN_VALUE ? (nums.length - res) : -1;

    }
}