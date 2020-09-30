import java.io.*;
import java.util.*;


class Solution {
  
  public boolean subsetSum(int[] arr, int S) {
    return subSetSumDP(arr, S, arr.length);
  }  
  
  public boolean subSetSumDP(int[] arr, int S, int n) {
    boolean[][] dp = new boolean[n+1][S+1];
    
   for(int i=0; i<=n; i++) {
      dp[i][0] = true; 
   } 
    
   for(int s=1; s<=S; s++) {
      dp[0][s] = false; 
   }  
    
   for(int i = 1; i <= n; i++) {
     for(int s = 1; s <= S; s++) {
        if(arr[i-1] > s)
          dp[i][s] = dp[i-1][s];
        else
          dp[i][s] = dp[i-1][s] || dp[i-1][s-arr[i-1]];
      }  
    }  
    
    
    for(int i = 0; i <= n; i++) {
      for(int s = 0; s <= S; s++) {
        System.out.print(dp[i][s] + " ");
      }
       System.out.println();
    }  
    
     return dp[n][S];
  }  
  
  public static void main(String[] args) {
   Solution s = new Solution(); 
   System.out.println(s.subsetSum(new int[]{2,3,7,8}, 11));
  }
  
}
