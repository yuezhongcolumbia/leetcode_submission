class Solution {
    public int minCost(int[][] grid, int k) {
        // 2, 7 ,3
        // 1, 4, 5

        // multistate dijkstra:[r][c][turn used]
        // stale node: curDistance > Distance[][][]
        // encode turn: begining 
        // relaxation: 
        int rows = grid.length;
        int cols = grid[0].length;
        int[][][][] distance = new int[rows][cols][k + 1][5];
         for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                for(int s = 0;  s < k + 1; s++){
                    Arrays.fill(distance[i][j][s], Integer.MAX_VALUE);
                }
            }
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[2], b[2]));
        pq.offer(new int[]{0, 0, grid[0][0], k, 4});
        distance[0][0][k][4] = grid[0][0];
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int r = cur[0];
            int c = cur[1];
            int cost = cur[2];
            int kLeft = cur[3];
            int curDir = cur[4];
            if (r == rows - 1 && c == cols - 1){
                return cost;
            }
            //stale
            if (cost > distance[r][c][kLeft][curDir]) continue;
            for(int i = 0; i < 4; i++){
                int[] dir = directions[i];
                int nr = r + dir[0];
                int nc = c + dir[1];
                if (nr >= 0 && nr < rows && nc >=0 && nc < cols){
                    boolean isTurn = (curDir != 4) && (curDir != i);
                    
                    if (isTurn){
                        //turn
                        if (kLeft > 0 && distance[nr][nc][kLeft - 1][i] > cost + grid[nr][nc]){
                            distance[nr][nc][kLeft - 1][i] = cost + grid[nr][nc];
                            pq.offer(new int[]{nr, nc, cost + grid[nr][nc], kLeft - 1, i });
                        }
                    } else {
                         //noTurn
                          if (distance[nr][nc][kLeft][i] > cost + grid[nr][nc]){
                            distance[nr][nc][kLeft][i] = cost + grid[nr][nc];
                            pq.offer(new int[]{nr, nc, cost + grid[nr][nc], kLeft, i });
                        }
                    }
                   

                }
            }

        }
        return -1;
            
    }
}