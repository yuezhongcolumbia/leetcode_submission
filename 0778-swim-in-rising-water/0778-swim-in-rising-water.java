class Solution {
    public int swimInWater(int[][] grid) {
        // high level: 
        // 1. current grid water lvl, it changes with time
        // 2. do you wanna go back?
        // 3. to arrive at destination, the time depends on the highest elevation in the path
        // 4. we have to find such path, that the H_max is minimized

        // 1 0 2 1
        // 0 1 1 0   time 0

        // 1 1 2 1
        // 1 1 1 1   time 1

        // 1. what do we need:?  
        //     h_max so far needs to be recorded
        //     if I arrive at a point with h_max so far less than recorded best I can evict

        //     diksjtra:
        // 1. visited？
        //     no because going back doesnt reduce maxHeight so far, so we natuarlly dont relax backward
        

        
        int rows = grid.length;
        int cols = grid[0].length;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a[0],b[0]));
        int[][] height = new int[rows][cols];
        for(int i = 0; i < rows; i++){
            Arrays.fill(height[i], Integer.MAX_VALUE);
        }
        height[0][0] = grid[0][0];
        minHeap.offer(new int[]{grid[0][0], 0, 0});
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        while(!minHeap.isEmpty()){
            int[] cur = minHeap.poll();
            int r = cur[1];
            int c = cur[2];
            int curHeight = cur[0];
            //destination
            if (r == rows - 1 && c == cols - 1){
                return curHeight;
            }
            //evict stale nodes
            if (curHeight > height[r][c]){
                continue;
            }
            for(int[] dir: directions){
                int nr = dir[0] + r;
                int nc = dir[1] + c;
                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols){
                    int newHeight = Math.max(grid[nr][nc], curHeight);
                    if (newHeight < height[nr][nc]){
                        height[nr][nc] = newHeight;
                        minHeap.offer(new int[]{newHeight, nr, nc});
                    }
                }

                //relaxation
            }
           
        }
    return -1;



        
    }
}