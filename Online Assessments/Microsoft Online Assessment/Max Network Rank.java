
import java.io.*;
import java.util.*;


class Solution {
    
    public int maxNetworkRank(int[] A, int[] B) {
        int maxRank = 0;
        int[][] grid = new int[A.length][B.length];

        for(int i = 0; i < A.length; i++) {
          int row = A[i] - 1;
          int col = B[i] - 1;
          grid[row][col] = 1;
          grid[col][row] = 1;
        }  
      
       for(int i = 1; i < A.length; i++) {
        int counter = 0;
        for(int j = 0; j < B.length; j++) {
          if(grid[i][j] == 1 || grid[i-1][j] == 1) {
              counter += 1;
          }  
        }
        maxRank = Math.max(maxRank, counter); 
       }  
      
      return maxRank;
    }  

    public static void main(String[] args) {
     Solution s = new Solution();
     System.out.println(s.maxNetworkRank(new int[]{1,2,3,3}, new int[]{2,3,1,4}));
    }
}
  

                                 
