class Solution {
    public int calculate(String s) {
        // prioritize * and /:

        
        
        // when to execute operation? both operand ready
        // only when * or /, we should operate immediately, to sort of decrease one level of depth

        // simpler case:
        // 1 + 1  * 1

        
        // yes we need execute * and / immediately and push them back to the stack

        // what about + and -?
        // 1 + 1 * 1 /2 + 1 becomes 1 + 0 + 1 if we dont do anythinbg about them 
        // we can iterate them, when its a number add to result.
        // what about + and -?
        // use int sign = -1/+1

        // 1 + 34 * 24 * 3
        // [1, 34, *]
        // how to deal with sth other than single digit?
        // use tmp to save partial digit, tmp = 3, when it comes to 4, tmp*10 + cur
        // to "*", we cannot wait for next 24 to form up, so we push "*"?
        // but when is this * going to be executed? 

        // 1 + 3 * 2  - 1   
        char operator = ' ';
        int sign = 1;
        int tmp = 0;
        Stack<Integer> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if (c == ' ') continue;
            if (Character.isDigit(c)){
                tmp = tmp * 10 + (c - '0');
            } else {
                if (operator != ' '){
                    int left = stack.pop();
                    int tmpRes = calculate(left, tmp, operator);
                    stack.push(tmpRes);
                } else {
                    stack.push(sign * tmp);
                }
                if (c == '+'){
                    sign = 1;
                    operator = ' ';
                } else if (c == '-'){
                    sign = -1;
                    operator = ' ';
                } else if (c == '*'){
                    sign = 1;
                    operator = '*';
                } else if (c == '/'){
                    sign = 1;
                    operator = '/';
                }
                tmp = 0;
            }
        }  
        System.out.println(tmp);
         if (operator != ' '){
                    int left = stack.pop();
                    int tmpRes = calculate(left, tmp, operator);
                    stack.push(tmpRes);
          } else {
                    stack.push(sign * tmp);
          }

        int res = 0;
        for(int num: stack){
            res += num;
        }  
        return res;
    }
    public int calculate(int left, int right, char operator){
         int res = 0;
         if (operator == '*'){
                res = left * right;
            } else {    
                res = left / right;
            }   
            return res;
    }
}