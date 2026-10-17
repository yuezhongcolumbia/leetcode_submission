class Solution {
    public int singleNonDuplicate(int[] nums) {
        // 0 1 2 3 4 5 6 7 8 
        // 1,1,2,3,3,4,4,8,8

        // before: first digit starts at even 
        //     else
        // after: first digit starts at odd
        //     if (even && m > 0 &&  same as previous one)
        //     if (odd && m < n - 1 && same as next one)
        //     r = m - 1
        //     res = m
        // found: first true - 1, if it sits in the end, then we can set res = n - 1.
        int l = 0;
        int n = nums.length;
        int r = n - 1;
        int res = -1;
        while(l <= r){
            int m = (l + r) >> 1;
            if (m % 2 == 0  && m > 0 && nums[m] == nums[m - 1]){
                r = m - 1;
                res = m;
            } else if (m % 2 == 1 && m < n - 1 && nums[m] == nums[m + 1]){
                r = m - 1;
                res = m;
            } else {
                l = m + 1;
            }
        }
        return res == -1 ? nums[n - 1] : nums[res - 1];


        

    }
}