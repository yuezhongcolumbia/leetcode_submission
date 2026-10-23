class Solution {
    public int trapRainWater(int[][] heightMap) {
        // 1,4,3,1,3,2
        // 3,2,1,1,2,4
        // 2,3,3,2,3,1

        // 1,4,3,1,3,2
        // 3,1,2,1,2,4
        // 2,3,3,2,3,1



        // what do we need to know:
        // we need to find the "low point"
        // how much water it can preserve is determined by grid height that are "far away", in 4 directions
        // actually not only 4 directions, 
        // at each point if we want know if water is trapped, we have to unable to find an "exit"
        // so maybe we can start with these "exits", so we start at the border.
        // 1. blocked
        // 2. 
        // at 0,1, this point is definetaly influencing other lower grid, such as 1,1, but I cannot paint 1,1 as 4,
        // wait our objective here is to follow through the exits, the low point, so we should traverse when there is a higher/equal point. 

        // 4 4 4 4
        // 4 1 1 4
        // 4 3 4 4

        int m = heightMap.length;
        int n = heightMap[0].length;

        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean[][] visited = new boolean[m][n];

        // {waterLevel, row, col}
        PriorityQueue<int[]> minHeap =
            new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        int res = 0;
        // 1. Initialize all border cells
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (r == 0 || r == m - 1 || c == 0 || c == n - 1) {
                    minHeap.offer(new int[]{heightMap[r][c], r, c});
                    visited[r][c] = true;
                }
            }
        }
        while(!minHeap.isEmpty()){
            // not visit, in bound, 
            int[] cur = minHeap.poll();
            int curLvl = cur[0];
            int r = cur[1];
            int c = cur[2];
            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr < 0 || nr >= m || nc < 0 || nc >= n
                    || visited[nr][nc]) {
                    continue;
                }
                visited[nr][nc] = true;
                res += Math.max(0, curLvl - heightMap[nr][nc]  );

                minHeap.offer(new int[]{Math.max(heightMap[nr][nc], curLvl), nr, nc});

            }
        }
        return res;
        
    }
}