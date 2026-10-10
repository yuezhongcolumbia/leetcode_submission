class Solution {
    public int myAtoi(String s) {
        // 1337c0d3:
        // 1. white space: skip
        // 2. sign: preserve
        // 3. leading zero: skip
        // 4. non digit char: stop
        // 5. first non zero: preserve
        // 6. use ans = ans * 10 + digit to record
        // 7. check bound

        int n = s.length();
        int sign = 1;
        int index = 0;
        while(index < n && s.charAt(index) == ' '){
            index++;
        }
        if(index < n && (s.charAt(index) == '+' || s.charAt(index) == '-')){
            sign = s.charAt(index) == '-' ? -1 : 1;
            index++;
        }
        while(index < n && s.charAt(index) == '0'){
            index++;
        }
        long res = 0;
        for(int i = index; i < n; i++){
            if (Character.isDigit(s.charAt(i))){
                //bound check
                if (res > Integer.MAX_VALUE){
                    return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                int digit = s.charAt(i) - '0';
                res = res * 10 + digit;
            } else {
                break;
            }
        }
        if (res > Integer.MAX_VALUE){
                    return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        return (int)(sign * res);


        

        
    }
}