class Solution {
    public static class DSU{
        int[] parent;
        int[] size;
        public DSU (int n){
            parent = new int[n];
            size = new int[n];
            Arrays.fill(size, 1);
            for(int i = 0;  i< n; i++){
                parent[i] = i;
            }
        }
        
        public int find(int x){
            if (parent[x] == x) return x;
            parent[x] = find(parent[x]);
            return parent[x];
        }
        public boolean union(int x, int y){
            int rx = find(x);
            int ry = find(y);

            if (rx == ry) return false;
            if (size[rx] >= size[ry]){
                size[rx] += size[ry];
                parent[ry] = rx;
            } else {
                size[ry] += size[rx];
                parent[rx] = ry;
            }
            return true;
        }
    }
   
    
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int res = rows * cols;
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        DSU dsu = new DSU(rows * cols);
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if (grid[i][j] == '0'){
                    res--;
                    continue;
                }
                //dsu union op, if union, res--
                for(int[] dir: directions){
                    int nr = i + dir[0];
                    int nc = j + dir[1];
                    if (nr >= 0 && nr < rows && nc >= 0 && nc < cols
                        && grid[nr][nc] == '1'
                        && dsu.union(i * cols + j, nr * cols + nc)){
                            res--;
                        }
                }

            }
        }
        return res;
    }
}