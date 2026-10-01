class Solution {
    public long minCost(int[] nums, int[] cost) {
        // 1, 1,1,1,3   2,3

        // so the numbers can "meet" in the middle
        // 1. deciding the target:
        //     range of the target?[min, max];
        //     use binary search to search for a optimal target.
         int left = nums[0];
        int right = nums[0];

        for (int num : nums) {
            left = Math.min(left, num);
            right = Math.max(right, num);
        }
        int target = 0;
        while(left <= right){
            int mid = (left + right) >> 1;
            long midCost = totalCost(nums, cost, mid);
            long nextCost = totalCost(nums, cost, mid + 1);
            if (midCost < nextCost){
                target = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return totalCost(nums, cost, target);
                


     }
     private long totalCost(int[] nums, int[] cost, int target) {
        long total = 0;

        for (int i = 0; i < nums.length; i++) {
            total += (long) Math.abs(nums[i] - target) * cost[i];
        }

        return total;
    }
}