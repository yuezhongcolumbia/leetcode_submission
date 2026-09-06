class Solution {
    int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
    public int minCost(int[][] grid, int k) {
        
        
        int m = grid.length;
        int n = grid[0].length;
        if (m == 1 && n == 1) return grid[0][0];
        int[][][][] distance = new int[m][n][k + 1][5];
       
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                for(int s = 0;  s < k + 1; s++){
                    Arrays.fill(distance[i][j][s], Integer.MAX_VALUE);
                }
            }
        }
         distance[0][0][k][4] = grid[0][0];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));
        //cost dir kLeft x y
        pq.offer(new int[]{grid[0][0], 4, k, 0, 0});
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int cost = cur[0];
            int incmingDir = cur[1];
            int kLeft = cur[2];
            int r = cur[3];
            int c = cur[4];
            if (r == m - 1 && c == n - 1){
                return cost;
            }
            //stale
            if (distance[r][c][kLeft][incmingDir] < cost) continue;
            for(int i = 0; i < 4; i++){
                int[] newDir = directions[i];
                int nr = r + newDir[0];
                int nc = c + newDir[1];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n){
                        boolean isTurn = incmingDir != 4 && incmingDir != i;
                        // take a turn
                        if (isTurn && kLeft == 0) continue;
                        if (isTurn){
                            if (distance[nr][nc][kLeft - 1][i] > cost + grid[nr][nc]){
                                distance[nr][nc][kLeft - 1][i] = cost + grid[nr][nc];
                                pq.offer(new int[]{cost + grid[nr][nc], i, kLeft - 1, nr, nc});
                            }
                            
                        } else {
                            if (distance[nr][nc][kLeft][i] > cost + grid[nr][nc]){
                                distance[nr][nc][kLeft][i] = cost + grid[nr][nc];
                             pq.offer(new int[]{cost + grid[nr][nc], i, kLeft, nr, nc});
                            }
                            
                        }
                        // if (incmingDir != 4 && incmingDir != i && kLeft > 0){
                        //     distance[nr][nc][kLeft - 1][i] = cost + grid[nr][nc];
                        //     pq.offer(new int[]{cost + grid[nr][nc], i, kLeft - 1, nr, nc});
                        // } else {
                        //     distance[nr][nc][kLeft][i] = cost + grid[nr][nc];
                        //     pq.offer(new int[]{cost + grid[nr][nc], i, kLeft, nr, nc});
                        // }
                        
                    }
            }
        }
        return -1;

    }
  
}