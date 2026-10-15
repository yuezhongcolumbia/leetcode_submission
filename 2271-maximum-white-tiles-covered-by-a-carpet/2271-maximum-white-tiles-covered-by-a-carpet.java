class Solution {
    public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        Arrays.sort(tiles, (a , b) -> Integer.compare(a[0], b[0]));
        int n = tiles.length;
        int res = 0;
        int[] prefixSum = new int[n + 1];
        for(int i = 1; i < n + 1; i++){
            prefixSum[i] = prefixSum[i - 1] + tiles[i - 1][1] - tiles[i - 1][0] + 1;
        }
        for(int i = 0; i < n; i++){
           int end = tiles[i][0] + carpetLen - 1;
           int curSum = 0;
            
           int l = i;
           int r = n - 1;
           int j = -1;
           
           while (l <= r){
                int m = (l + r) >> 1;
                if (tiles[m][1] > end){
                    j = m;
                    r = m - 1;
                } else {
                    l = m + 1;
                }
           }
           //calculate might use prefix sum
           if (j != -1){
             curSum += (prefixSum[j] - prefixSum[i]);
           } else {
            curSum += prefixSum[n] - prefixSum[i];
           }
           
            //partial sum
            if (j != -1 && tiles[j][0] <= end){
                curSum += (end - tiles[j][0] + 1);
            }
           //update
           res = Math.max(res, curSum );

           
        }
        return res;
        
    }
}