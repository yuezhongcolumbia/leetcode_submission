class Solution {
    public long maxAlternatingSum(int[] nums) {
        // at even, big number (abs)
        // at odds, small number
        
        // 3 1 3 1 2 2 = 9-1+9-1
        // you only have to return the number, 

        // sort the number based on their abs value and use two pointers

        //square them
        //sort them
        long sum = 0L;
        for(int i = 0; i < nums.length; i++){
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        int l = 0;
        int r = nums.length - 1;
        while(l <= r){
            if (l == r){
                sum += nums[r];
                break;
            }
            //edge case where l == r
            sum = sum + nums[r] - nums[l];
            l++;
            r--;
        }
        return sum;

    }
}