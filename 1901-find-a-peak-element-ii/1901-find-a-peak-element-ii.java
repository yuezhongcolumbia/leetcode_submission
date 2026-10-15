class Solution {
    public int[] findPeakGrid(int[][] mat) {
    //    just remember this: the global max must be a valid answer;
      int rows = mat.length;
      int cols = mat[0].length;
      int l = 0;
      int r = rows - 1;



       while (l <= r){
        int m = (l + r) >> 1;
         //find row max
         int rowMaxIdx = 0;
         for(int i = 1; i < cols; i++ ){
            if (mat[m][i] > mat[m][rowMaxIdx]){
                rowMaxIdx = i;
            }
         }

         
        
         if (m < rows - 1 && mat[m][rowMaxIdx] < mat[m + 1][rowMaxIdx]){
           l = m + 1;
         } else if (m > 0 && mat[m][rowMaxIdx] < mat[m - 1][rowMaxIdx]){
            r = m - 1;
         } else {
            return new int[]{m, rowMaxIdx};
         }
       }
       return new int[]{-1, -1};

    }
}