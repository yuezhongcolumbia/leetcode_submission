class Solution {
    public int maxSubarray(int[] nums) {
        int n = nums.length;
        int ans = 0;
        int l = 0;
        int[] count = new int[501];
        for(int i = 0; i < n; i++){
            while(isInvalid(count, nums[i])){
                count[nums[l]]--;
                l++;
                
            }
            count[nums[i]]++;
            ans = Math.max(i - l + 1, ans);
        }
        return ans;
    }
    public boolean isInvalid(int[] count, int x){
        for(int d = 1; d <= 500; d++){
           if (count[d] == 0) continue;
           // a + d = x
            int otherA = x - d;
            if (otherA > 0 && otherA <= 500 ){
                if (d == otherA && count[d] >= 2) {
                   return true; 
                }else if (d != otherA && count[otherA] > 0) {
                    return true;
                }

                
            }

            // a - d = x 
            int otherB = d + x;
            if (otherB > 0 && otherB <= 500){
                if (count[otherB] > 0) return true;
            }
        }
        return false;
        
    }
}