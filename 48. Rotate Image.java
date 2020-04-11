class Solution {
    public void rotate(int[][] matrix) {
       int N = matrix.length;
       for(int i=0; i<N; i++){
           for(int j=i; j< N; j++){
               int temp = matrix[i][j];
               matrix[i][j] = matrix[j][i];
               matrix[j][i] = temp;
           }
       }
  
        for(int i=0; i<N; i++){
            for(int j=0; j<(N/2); j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][N-1-j];
                matrix[i][N-1-j] = temp;
            }
        }
    }  
}