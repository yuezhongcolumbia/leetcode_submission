class Solution {
    public String convert(String s, int numRows) {
    //     n -> n-2(zag) -> n
    //     what do we want? row by row String
    //     PAYPALISHIRING
    //    0,0 1,0 2,0 1,1  0,2  1,2  2,2 

    //     n times increment row
    //     n-2 times decrement row, + 1 column

    //     actually I dont think we need an actual matrix for this
    //     we just need to read
    //     p(0) A(4) H(8) N()
    //     I think we need a map, key is row, value is list
    //     column doesnt matter, the insertion sequence in list is enough
    //     p:1 a:2 y:3 | p: 2  n-2 | a:1 l:2 i:3 | s:2

    //     I need row number, I need idx to traverse through string

        Map<Integer, List<Character> > map = new HashMap<>();
        for(int i = 0; i < numRows; i++){
            map.put(i, new ArrayList<>());
        }
        int idx = 0;
        while(idx < s.length()){
            for(int i = 0; i < numRows; i++){
                //update idx, check bound
                if (idx < s.length()){
                    map.get(i).add(s.charAt(idx));
                    idx++;
                } else {
                    break;
                }
            }
            for(int i = numRows -2; i >= 1; i--){
                //update idx, check bound
                if (idx < s.length()){
                    map.get(i).add(s.charAt(idx));
                    idx++;
                } else {
                    break;
                }
            }
            
        }
        //traverse map
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i< numRows; i++){
            List<Character> chars = map.get(i);
            for(char c: chars){
                sb.append(c);
            }
        }
        return sb.toString();

        
    }
}