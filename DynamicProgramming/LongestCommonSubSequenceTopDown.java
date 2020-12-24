
import java.io.*;
import java.util.*;


class Solution {

  public int findLCS(String s1, String s2) {
    int[][] dp = new int[s1.length()+1][s2.length()+1];
    int maxLen = 0;
    
    for(int i = 1; i <= s1.length(); i++) {
      for(int j = 1; j <= s2.length(); j++) {
        if(s1.charAt(i-1) == s2.charAt(j-1)) 
            dp[i][j] = 1 + dp[i-1][j-1]; 
         else
          dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
        maxLen = Math.max(maxLen, dp[i][j]);
      }  
    } 
    return maxLen;
  } 
  
  
  
  
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.findLCS("passport", "ppsspt"));
  }
}
