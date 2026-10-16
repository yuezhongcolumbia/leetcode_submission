class Solution {
    public int longestOnes(int[] nums, int k) {
        int flip = 0;
        int l = 0;
        int res = 0;
        for(int r = 0;  r < nums.length; r++){
            if (nums[r] == 0){
                flip ++;
            }
            while (l < r && flip > k){
                if (nums[l] == 0){
                    flip--;
                } 
                l++;
            }
            if (!(l == r && nums[r] == 0 && k == 0)){
                res = Math.max(res, r - l + 1);
            }
            
        }
        return res;
    }
}