class Solution {
    int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
    int rows;
    int cols;
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        // two problems:
        // 1. a Path!
        // 2. at anytime of the path, the min distance to all thief grid


        // 0 0 1    2 1 0
        // 0 0 0    3 2 1
        // 0 0 0    4 3 2

        // 1. preprocess it
        //     multi source bfs
        // 2. use dfs to seek an optimal path
        //     loop 4 directions:
        //         use visit and non zero grid only, boundary check
        //         look for the max number grid
        //         update result
        //     if no valid grid found return false

        //     ok I think using dfs I might find a valid path but not necessarily the most optimal path, because at a certain point, both points are equally large for safe factor, but lead to different path.

        //     bfs again I guess
        //     at each point I not only record row/col but also the min safe factor so far
        //     if q is empty and we are not at destination, return false

        //     ok dijkstra, so what is the relaxation criteria,it should be max safe factor so far. which means if a path can arrive a point with more safe factor, we literally dont care about other. 
        //         we first figure out the max so far, if it is smaller than what is stored in the relaxation array, we discard

        // dont give me hint, 告诉我方向对不对
        rows = grid.size();
        cols = grid.get(0).size();
        int[][] myGrid = new int[rows][cols];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                myGrid[i][j] = grid.get(i).get(j);
            }
        }
        bfs(myGrid);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(b[0], a[0]));
        pq.offer(new int[]{myGrid[0][0], 0, 0});
        int[][] safe = new int[rows][cols];
        for(int i = 0; i < rows; i++){
            Arrays.fill(safe[i], Integer.MIN_VALUE);
        }
        safe[0][0] = myGrid[0][0];
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int r = cur[1];
            int c = cur[2];
            int curSafe = cur[0];
            if (r == rows - 1 && c == cols - 1) {
                return curSafe;
            }
            //discard stale
            if (curSafe < safe[r][c]) continue;
            for(int[] dir: directions){
                int nr = r + dir[0];
                int nc = c + dir[1];
                if(nr >= 0 && nr < rows && nc >= 0 && nc < cols){
                    int nextSafe = Math.min(curSafe, myGrid[nr][nc]);
                    if (nextSafe > safe[nr][nc]){
                        pq.offer(new int[]{nextSafe,nr, nc });
                        safe[nr][nc] = nextSafe;
                    }
                }
            }
        }
        
       return safe[rows - 1][cols - 1];
        
    }
    public void bfs(int[][] grid){
        Queue<int[]> q = new LinkedList<>();
        for(int r = 0; r < rows; r++){
            for(int c = 0;  c < cols; c++){
                if (grid[r][c] == 1){
                    grid[r][c] = 0;
                    q.offer(new int[]{r, c});
                } else {
                    grid[r][c] = Integer.MAX_VALUE;
                }
            }
        }
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] cur = q.poll();
                int r = cur[0];
                int c = cur[1];
                for(int[] dir: directions){
                    int nr = r + dir[0];
                    int nc = c + dir[1];
                    if(nr >= 0 && nr < rows && nc >= 0 && nc < cols){
                        int newSafe = grid[r][c] + 1;
                        if (grid[nr][nc] > newSafe){
                            grid[nr][nc] = newSafe;
                            q.offer(new int[]{nr,nc});
                        }
                        
                    }

                }
            }
        }
    }
}