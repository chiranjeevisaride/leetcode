class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        for(int row = 1; row < rows; row++) {
            for(int col = 1; col < cols; col++) {
                if(matrix[row][col] != matrix[row-1][col-1]) return false;
            }
        }
        return true;
    }
}