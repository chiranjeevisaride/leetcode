import java.io.*;
import java.util.*;


class Solution {
    
  public int robCutting(int[] lengths, int[] prices, int L) {
    if(lengths == null || prices == null || lengths.length != prices.length) 
      return 0;
    return dp(lengths, prices, L);
  } 
  
  
  public int dp(int[] lengths, int[] prices, int L) {
    int n = lengths.length;
    int[][] dp = new int[n+1][L+1];
    for(int i = 1; i <= n; i++) {
     for(int l = 0; l <= L; l++) {
        if(lengths[i-1] <= l)
          dp[i][l] = Math.max(prices[i-1] + dp[i][l-lengths[i-1]], dp[i-1][l]);
        else
          dp[i][l] = dp[i-1][l];
     } 
    } 
    return dp[n][L];
  }  
  
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.robCutting(new int[]{1,2,3,4,5}, new int[]{2,6,7,10,13}, 5));  
  }
  
}
