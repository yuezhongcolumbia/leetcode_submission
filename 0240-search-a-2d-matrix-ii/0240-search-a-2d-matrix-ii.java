class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int r = 0;
        int c = cols - 1;
        
        while (c >= 0 && r < rows){
            if (matrix[r][c] > target){
                c--;
            } else if (matrix[r][c] < target){
                r++;
            } else {
                return true;
            }
        }
        return false;
    }
}