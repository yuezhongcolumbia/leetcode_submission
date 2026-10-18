class Solution {
    public int maxProduct(int[] nums) {
    //     subarray, negative number
    //     negative number make me want to know if there is negative sign in the future
    //     that would flip the sign and maximize result


    //     2,3,-2,4, 
    //     if  there is negative sign in the future
    //  1, 2, 6, -12, -48, 
     
     
    //  -48,-24, -8,   4, 

    //  nums = [-2, 3, -4, 0]
    //  maxEnd: 1   3   1  1
    //  minEnd: -2  -6 -24 0

    //  maxEnd: 1   3   1  1
    //  minEnd: -2 -12 -4  0

     
        
    //     what if maxEnd is [1, some n], if we have negatvie in the past, we start over
    //             minEnd is [-some n, 0]

    //    we scan two times, from begin to end, end to begin, figure ont maxEnd minEnd
    //    we scan again, compare max * max[i + 1], and min * min[i + 1]


        
        
        
    //     if there is zero in between
        int minEnd = nums[0];
        int maxEnd = nums[0];
        int res = nums[0];

        for(int i = 1; i < nums.length; i++){
            int num = nums[i];
            int newMinEnd = Math.min(num, Math.min(num * minEnd, num * maxEnd));
            int newMaxEnd = Math.max(num, Math.max(num * minEnd, num * maxEnd));
            minEnd = newMinEnd;
            maxEnd = newMaxEnd;

            res = Math.max(res, maxEnd);
        }
        return res;



    }
}