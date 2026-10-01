class Solution {
    public int reverse(int x) {
        // 123;

        // stringbuilder?
        // digit = digit % dividend
        // divident *= 10
        // append the digit

        // we need a loop, the stop condition is digit / divident = 0;

        // 1. corner cases:
        //    a. negative sign, preserve the sign;
        //    b. leading zero. if stringbuilder is empty and digit is zero skip it
        //    c. out of bound: turn the final string to long, check bound
        long ans = 0;
        while( x != 0){
            int digit = x % 10;
            x /= 10;

            
            ans = ans * 10 + digit; 
            if (ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE) return 0;
        }
        return (int)ans;
        

        
    }
}