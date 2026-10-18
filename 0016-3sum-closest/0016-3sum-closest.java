class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // i just need sum, dont need idx
        // I can sort this
        // -4, -1, 3, 4  target = 1

        // binary search find the nearest one and expand

        // pick -1 or 3
        // which 3sum to compare

        // left -4: sumLeft = target - left = 5
        // -1, 3, 4
        // pick -1,4  gap = 2
        // left pointer ->
        // gap = -2
        // right pointer 
        Arrays.sort(nums);
        int res = Integer.MAX_VALUE/2;
        for(int i = 0; i < nums.length - 2; i++){
            int gap = target - nums[i];
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r){
                int twoSum = nums[l] + nums[r];
                int threeSum = nums[i] + twoSum;
                if (Math.abs(target - threeSum) < Math.abs(target - res)){
                    res = threeSum;
                }
                if (gap - twoSum > 0){
                    l++;
                } else if (gap - twoSum < 0){
                    r--;
                } else {
                    return threeSum;
                }
            }
        }
        return res;



    }
}