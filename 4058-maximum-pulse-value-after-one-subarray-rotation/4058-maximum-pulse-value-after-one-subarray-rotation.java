class Solution {
    public long maxValue(int[] nums) {
        // 1,5,2

        //   1， 5， 2
            // The goal is to minimize sum[l....r], so that we flip it the contribution would be maximized
        // 1. current prefix sum
        // 2. case 1: length between cur and l is even
        //         a. l requires different parity
        //         b. everything changes, we calulate the sum and flip it update answer
        //         c. prefix[l] is required to be one prefix sum before some prefix[l]; l - 1 is same parity
        // 3. case 2: length between cur and l is odd
        //         a. l requires same parity
        //         b. the first digit of that subarray, doesnt change, everything else flip
        //         c. the prefix[l] is required to be some prefix[l], l is same parity
        // 4. update:
        //         a. update prefixBeforeL first
        //         b. update prefix
        //         c. update prefixAtL
        int n = nums.length;
        long base = 0L;
        Long[] prefixSumBeforeL = {Long.MIN_VALUE, Long.MIN_VALUE};
        Long[] prefixSumAtL = {Long.MIN_VALUE, Long.MIN_VALUE};
        Long prefix = 0L;
        Long bestDelta = 0L;
        for(int r = 0;  r < n; r++ ){
            int sign = (r % 2 == 0) ? 1 : -1;
            base += (sign *nums[r]);
            
            if (prefixSumBeforeL[r % 2] != Long.MIN_VALUE){
                 long subArrSum = base - prefixSumBeforeL[r % 2];
                bestDelta = Math.max(bestDelta, -2 * subArrSum);
            }
           
            if (prefixSumBeforeL[r % 2] != Long.MIN_VALUE){
               long subArrSum = base - prefixSumAtL[r % 2];
                bestDelta = Math.max(bestDelta, -2 * subArrSum);
            }
            

            int opposParity = 1 - r % 2;
            prefixSumBeforeL[opposParity] = Math.max( prefixSumBeforeL[opposParity] , prefix);
            prefix += (sign *nums[r]);
            prefixSumAtL[r % 2] = Math.max(  prefixSumAtL[r % 2] , prefix);
        }   
        return base + bestDelta;



            
    }
}