class Solution {
    public String intToRoman(int num) {
        // which decimal point?
        // digit convert to roman?
        // 0: skip
        // hashmap?
        //     0: [I, ]
     
        int[] values = {
            1000, 900, 500, 400,
            100, 90, 50, 40,
            10, 9, 5, 4, 1
        };
        String[] symbols = {
            "M", "CM", "D", "CD",
            "C", "XC", "L", "XL",
            "X", "IX", "V", "IV", "I"
        };
        String res = "";
        for(int i = 0; i < values.length; i++){
            while(num > 0 && num >= values[i]){
                res += symbols[i];
                num -= values[i];
            }
        }
        return res;
    }
}