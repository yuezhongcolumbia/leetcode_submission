class Solution {
    public String countAndSay(int n) {
    //    we need a RLE function
    //    main fucntion returns RLE(c(n - 1))

    //    RLE function:
    //     counter and identify the element, idx, sb
    //     return string
    //     1211
        if (n == 1){
            return "1";
        }
        return rleEncoder(countAndSay(n - 1));


    }
   
    public String rleEncoder(String s){
        int idx = 0;
        StringBuilder sb = new StringBuilder();
        while(idx < s.length()){
            int count = 0;
            char c = s.charAt(idx);
            while(idx < s.length() -1 && c == s.charAt(idx + 1)){
                count++;
                idx++;
            }
            count++;
            idx++;
            sb.append((char)(count + '0'));
            sb.append(c);
        }
        return sb.toString();
    }
}