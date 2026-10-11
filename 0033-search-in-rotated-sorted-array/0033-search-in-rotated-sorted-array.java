class Solution {
    public int search(int[] nums, int target) {
        
        // rotated part mid < right boundary:
        //     found
        //     target between mid and right boundary
        //         left = mid + 1
        //     else

        // sorted part :
        //     found
        //     target between left boundary and mid:
        //         right = mid - 1;
        //     else

        int n = nums.length;
        int l = 0;
        int r = nums.length - 1;
        int rightBound = nums[n - 1];
        int leftBound = nums[0];
        while (l <= r){
            int m = (l + r) >> 1;
            if (nums[m] <= rightBound){
                if (nums[m] == target){
                    return m;
                } else if (nums[m] < target && target <= rightBound){
                    l = m  +1;
                } else {
                    r = m - 1;
                }
            } else {
                if (nums[m] == target){
                    return m;
                } else if (nums[m] > target && target >= leftBound){
                    r = m - 1;
                } else {
                    l = m + 1;
                }

            }
        }
        return -1;
    }
}