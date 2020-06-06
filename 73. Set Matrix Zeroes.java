class Solution {
    public void setZeroes(int[][] matrix) {
        int MODIFIED = -1000000;
        for(int row =0; row < matrix.length; row++) {
            for(int col = 0; col < matrix[row].length; col++) {
                if(matrix[row][col] == 0)
                       processZeros(matrix, row, col, MODIFIED);         
            }
        }
        
         for(int row = 0; row < matrix.length; row++) {
            for(int col = 0; col < matrix[row].length; col++) {
                 if(matrix[row][col] == MODIFIED)
                     matrix[row][col] = 0;
            }
         }    
        
    }
    
    public void processZeros(int[][] matrix, int row, int col, int MODIFIED) {
        for(int i=0; i< matrix.length; i++)
                if(matrix[i][col] != 0 && matrix[i][col] != MODIFIED) 
                    matrix[i][col] = MODIFIED;
                        
          for(int j=0; j< matrix[row].length; j++)
                if(matrix[row][j] != 0 && matrix[row][j] != MODIFIED)
                    matrix[row][j] = MODIFIED;
    }
}