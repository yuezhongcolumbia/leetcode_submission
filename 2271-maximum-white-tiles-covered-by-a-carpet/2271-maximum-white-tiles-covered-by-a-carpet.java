class Solution {
    public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
           Arrays.sort(tiles, (a, b) -> (a[0] - b[0]));
           int n = tiles.length;
           int curSum = 0;
           int res = 0;
           int j = 0;
           for(int i = 0; i < n; i++){
             int end = tiles[i][0] + carpetLen - 1;
             while (j < n && tiles[j][1] <= end){
                curSum += tiles[j][1] - tiles[j][0] + 1;
                j++;
             }
             int part = 0;
             if (j < n && tiles[j][0] <= end && tiles[j][1] >= end){
                part = end - tiles[j][0] + 1;
                curSum += part;
             }
             res = Math.max(res, curSum);
             curSum -= (tiles[i][1] - tiles[i][0] + 1); 
             curSum -= part;

             
           }
           return res;
    }
}