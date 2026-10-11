class Solution {
    public void nextPermutation(int[] nums) {
        // 1,2,4,3 -> 1,3,2,4
        // 1,3,4,2

        // find the pivot -> the point when it stops to be decending order
        // swap that with number is incremently larger that appeared after the pivot
        // we want to sort the subarray after the point in ascending order

        // 1,2,3
        int n = nums.length;
        int idx = n - 1;
        while(idx > 0 && nums[idx] <= nums[idx - 1]){
            idx --;
        }
        if (idx == 0){
            Arrays.sort(nums);
            return;
        }
        int pivot = nums[idx -1];
        for(int i = n - 1; i >= idx; i--){
            if (nums[i] > pivot){
                int tmp = pivot;
                nums[idx - 1] = nums[i];
                nums[i] = pivot;
                break;
            }
        }
        int l = idx;
        int r = n - 1;
        while(l < r){
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
            l++;
            r--;
        }

    }
}