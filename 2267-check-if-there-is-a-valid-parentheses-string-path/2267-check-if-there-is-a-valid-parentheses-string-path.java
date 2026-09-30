class Solution {
    char[][] grid;
    int rows;
    int cols;
    Boolean[][][] memo;
    public boolean hasValidPath(char[][] grid) {
        
        this.grid = grid;
        rows = grid.length;
        cols = grid[0].length;
        if (grid[0][0] == ')' ) return false;
        memo = new Boolean[rows][cols][rows + cols + 1];
        return dfs(0,0,0);
    }
    public boolean dfs(int r, int c, int balance){
        
        if (r == rows - 1 && c == cols - 1){
            if (balance == 1 && grid[r][c] == ')') {
                return true;
            } else {
                return false;
            }
        }
        
        
        if (grid[r][c] == '('){
            balance++;
        } else {
            balance--;
        }
        if (balance < 0 ) return false;
        if (memo[r][c][balance] != null) return memo[r][c][balance];
        boolean result = false;
        if (r + 1 < rows && dfs(r + 1, c, balance)){
            result = true;
        } else if (c + 1 < cols && dfs(r, c + 1, balance)) {
            result = true;
        }
        return memo[r][c][balance] = result;
    }
}