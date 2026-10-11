class Solution {
    public int divide(int dividend, int divisor) {
        // 5 1 * 2 * 2：
        // 1
       //sign and convert to negatives
       if (dividend == Integer.MIN_VALUE && divisor == -1){
        return  Integer.MAX_VALUE;
       }
       int sign = 1;
       int negatives = 2;
       if (dividend > 0){
        dividend = -dividend;
        negatives--;
       }
       if (divisor > 0){
        divisor = -divisor;
        negatives--;
       }
       sign = negatives == 1 ? -1 : 1;

        int res = 0;
        while(divisor >= dividend){
            int powersOfTwo = 1;
            int value = divisor;
            // halves do not go overboard
            // halves *2 is less than original number
            while(value >= Integer.MIN_VALUE >> 1 && value + value > dividend){
                // *2 count update
                powersOfTwo = powersOfTwo + powersOfTwo;
                // halves update
                value = value + value;
            }
            // update dividentLeft
            dividend -= value;
            // update count
            res += powersOfTwo;

        }
        return sign == 1 ? res : -res;
        
    }
}