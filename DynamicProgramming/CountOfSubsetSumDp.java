import java.io.*;
import java.util.*;


class Solution {
  
  public int countOfSubsetSum(int[] arr, int S) {
    return countOfSubsetSumDP(arr, S, arr.length);
  } 
  
  public int countOfSubsetSumDP(int[] arr, int S, int n) {
     int[][] dp = new int[n + 1][S + 1];
     
     for(int i=0; i<= n; i++)
      dp[i][0] = 1;
     
     for(int s=1; s <= S ; s++)
      dp[0][s] = 0;
    
      for(int i = 1; i <= n; i++) {
        for(int s = 1; s <= S; s++) {
          if(arr[i-1] > s)
             dp[i][s] = dp[i-1][s]; 
          else
              dp[i][s] = dp[i-1][s-arr[i-1]] +  dp[i-1][s];              
        } 
      }
      return dp[n][S];
  }  

 
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.countOfSubsetSum(new int[]{1,1,2,3}, 4));
  }
}
