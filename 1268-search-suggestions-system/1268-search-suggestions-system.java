class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        // mobile","moneypot","monitor mouse mousepad
        Arrays.sort(products);
        int n = products.length;
        int start = 0;
        String prefix = "";
        List<List<String>> res = new ArrayList<>();
        for(int i = 0; i < searchWord.length(); i++){
            prefix += searchWord.charAt(i);
            int l = start;
            int r = n - 1;
            int select = -1;
            while (l <= r){
                int m = (l + r) >> 1;
                if (products[m].compareTo(prefix) >= 0){
                    r = m - 1;
                    select = m;
                } else {
                    l = m + 1;
                }
                
                
            }
            start = select != -1 ? select : n;
                List<String> tmp = new ArrayList<>();
                for(int j = start; j < n; j++){
                    if (!products[j].startsWith(prefix)) break;
                    tmp.add(products[j]);
                    if (tmp.size() == 3) break;
                }
             res.add(tmp);   
           
        }
         return res;
    }
}