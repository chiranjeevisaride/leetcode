import java.io.*;
import java.util.*;


import java.io.*;
import java.util.*;



class Solution {
  
  public boolean equalSubsetPartition(int[] arr) {
    if(arr == null || arr.length == 0) return false;
    long sum = 0;
    for(int i = 0; i < arr.length; i++)
      sum += arr[i];
    if(sum%2 != 0) return false;
    return subsetSum(arr, (int) sum/2, arr.length);
  } 
  
  public boolean subsetSum(int[] arr, int S, int n) {
    boolean[][] dp = new boolean[n+1][S+1];
    
    for(int i = 0; i<=n; i++)
      dp[i][0] = true;
    
    for(int s = 1; s<=S; s++)
      dp[0][s] = false;
    
    for(int i = 1; i <= n ; i++) {
      for(int s = 1; s <= S; s++) {
       if(arr[i-1] > s) 
         dp[i][s] = dp[i-1][s];
       else
         dp[i][s] = dp[i-1][s] || dp[i-1][s - arr[i-1]];
     } 
    }
    return dp[n][S];
  }  
  
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.equalSubsetPartition(new int[]{1,2,3,4}));
  }
}


