class Solution {
    StringBuilder path;
    int n;
    List<String> res;
    public List<String> generateParenthesis(int n) {
        // backtrack:
        // choice:
        //     ( if inserted < n;
        //     ) if  non empty && open > 0;
        // stop:
        //     inserted == n
        path = new StringBuilder();
        this.n = n;
        res = new ArrayList<>();
        backtrack(0, 0);
        return res;

      
    }
      public void backtrack(int inserted, int open){
            if (inserted == n && open == 0){
                res.add(new String(path));
                return;
            }
            if (inserted < n){
                path.append("(");
                backtrack(inserted + 1, open + 1);
                path.deleteCharAt(path.length() - 1);
            }
            if (open > 0){
                path.append(")");
                backtrack(inserted, open - 1);
                path.deleteCharAt(path.length() - 1);
            }
        }
}