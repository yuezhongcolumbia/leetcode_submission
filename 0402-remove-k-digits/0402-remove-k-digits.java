class Solution {
    public String removeKdigits(String num, int k) {
        
        
        //  1 4 3 2 2 1 9

        //  1 0 2 0 0

        //  remove a digit means flip it to 0, after which we clear the leading 0.
        //  looking at the 1 <= k <= num.length <= 105, the number can be fucking huge, which means we have to 
        //  decide at each point whether to remove or not. sounds like a greedy approach.

        //  mathmatically, we want to remove digits such that, leading digits of remaining number is minimized,
        //  and leading digit can be 0.

        //  ideally we remove topk.

        //  there is an issue, at what position, when we remove digits, we are actually removing ending digits instead of leading digits? i think this is wrong question to ask

        //  try greedy:
        //   1 4 3 2 2 1 9, at 1, if we delete, leader will be 4, not great, 
        //   on 4, if we remove, leading with 3, it is a better choice than leading with 4
        //   at 3, so on....,

        //   question. why I have to flip as soon as possible? can I wait a few digit and then remove?
        //   13171911 
        //   11719
        //   13119

        //   edge case: 
        //   1.leading zero
        //   2. all ascending case.
         int removed = k;
          Stack<Character> stack = new Stack<>();
          for(char c: num.toCharArray()){
            while(!stack.isEmpty() && removed > 0 && stack.peek() > c){
                stack.pop();
                removed--;
            }
            //skip leading zero
            if (stack.isEmpty() && c == '0') continue;
            stack.push(c);
          }
          //handling unused k operation
          while(!stack.isEmpty() && removed > 0){
            stack.pop();
            removed --;
          }
          
        StringBuilder sb = new StringBuilder();

        for (char c : stack) {
            sb.append(c);
        }

        return sb.length() == 0 ? "0" : sb.toString();

    }
}