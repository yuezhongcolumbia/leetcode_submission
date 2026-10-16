class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
    //    mobile","moneypot","monitor mouse mousepad
    //    sort it 
    //    scan prefix, get rid of words that doesn share, get first three
    //    scan prefix, repeat
       Arrays.sort(products);
       int n = products.length;
       int l = 0;
       int r = n - 1;
       String prefix = "";
       List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < searchWord.length(); i++){
            prefix += searchWord.charAt(i);
            while (l <= r && !products[l].startsWith(prefix)){
                l++;
            }
            while(l < r && !products[r].startsWith(prefix)){
                r--;
            }
            List<String> tmp = new ArrayList<>();
            for(int start = l; start <= r; start++){
                tmp.add(products[start]);
                if (tmp.size() == 3) break;
            }
            res.add(tmp);

       }
       return res;
       
    }
}