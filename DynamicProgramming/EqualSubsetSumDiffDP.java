import java.io.*;
import java.util.*;


class Solution {
  
  public int minimumSubsetSumDiff(int[] arr) {
    if(arr == null || arr.length == 0) return 0;
    int S = 0;
    for(int i=0; i<arr.length; i++)
      S += arr[i];
    return minimumSubsetSumDiffDP(arr, S, arr.length);
  }
  
  
  public int minimumSubsetSumDiffDP(int[] arr, int total, int n) {
    int S = total/2;
    boolean[][] dp = new boolean[n+1][S+1];
    
    for(int s=0; s<=S; s++)
      dp[0][s] = false;
    
    for(int i=0; i<=n; i++)
      dp[i][0] = true;
    
    for(int i=1; i<=n; i++) {
     for(int s=1; s<=S; s++) {
       if(arr[i-1] > s) dp[i][s] = dp[i-1][s];
       else
         dp[i][s] = dp[i-1][s] || dp[i-1][s-arr[i-1]];
     }  
    }
    
    int sum1 = 0;
    
    for(int s=S; s>=0; s--) {
      if(dp[n][s]) {
        sum1 = s;
        break;
      }
    }  

    int sum2 = total - sum1;
    return Math.abs(sum1-sum2);
  }  
 
  
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.minimumSubsetSumDiff(new int[]{1, 3, 100, 4}));
  }
}
