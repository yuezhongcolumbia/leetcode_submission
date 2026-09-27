class Solution {
    public int maximumGap(int[] nums) {
        
        // 3, 6, 9, 1, 4
        int n = nums.length;
        if (n < 2) return 0;
        int exp = 1;
        int max = Integer.MIN_VALUE;
        for(int num: nums){
            max = Math.max(max, num);
        }
      

        while((max / exp) > 0){
            int[] tmp = new int[n];
            int[] count = new int[10];
            for(int i = 0; i < n; i++){
                count[(nums[i] / exp) % 10]++;
            }
            //prefix                                                                                                   
            for(int i = 1; i <= 9; i++){
                count[i] = count[i] + count[i - 1];             
            }                                                    
            //shift
            for(int i = 9; i >= 1; i--){
                count[i] = count[i - 1];
            }
            count[0] = 0;
            //put things in place
            for(int i = 0; i < n; i++){
                tmp[count[(nums[i] / exp) % 10]] = nums[i];
                count[(nums[i] / exp) % 10]++;
            }
            for(int i = 0; i < n; i++){
                nums[i] = tmp[i];
            }
            exp *= 10;
        }
        int res = 0;
        for(int i = 1; i < n; i++){
            res = Math.max(res, nums[i] - nums[i - 1]);
        }
        return res;
        
    }
}