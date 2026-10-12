class Solution {
    public int longestSubarray(int[] nums, int k) {
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            Set<Integer> seen = new HashSet<>();
            long curSum = 0;
            for(int j = i; j < nums.length; j++){
                curSum += nums[j];
                seen.add((int)(Math.floorMod(2 * nums[j], k)));
                int sumMod = (int)Math.floorMod(curSum, k);
                if (sumMod == 0 || seen.contains(sumMod)){
                    res = Math.max(res, j - i + 1);
                }
            }
        }
        return res;


      
    }
}