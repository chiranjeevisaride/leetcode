
import java.io.*;
import java.util.*;


class Solution {

  public int findLCS(String s1, String s2) {
     Integer[][] dp = new Integer[s1.length()][s2.length()];
     return findLCSRecursive(s1, s2, 0 , 0, dp); 
  } 
  
  
  private int findLCSRecursive(String s1, String s2, int s1Ptr, int s2Ptr, Integer[][] dp) {
    if(s1Ptr == s1.length() || s2Ptr == s2.length()) 
      return 0;
    
    if(dp[s1Ptr][s2Ptr] == null) {
      if(s1.charAt(s1Ptr) == s2.charAt(s2Ptr))
          dp[s1Ptr][s2Ptr] = 1 + findLCSRecursive(s1, s2, s1Ptr+1, s2Ptr+1, dp);
      else {
          int c1 = findLCSRecursive(s1, s2, s1Ptr, s2Ptr+1, dp);
          int c2 = findLCSRecursive(s1, s2, s1Ptr+1, s2Ptr, dp);
          dp[s1Ptr][s2Ptr] = Math.max(c1, c2);
      }  
    }  
      return dp[s1Ptr][s2Ptr];
  }  
  
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.findLCS("passport", "ppsspt"));
  }
}
