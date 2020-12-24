
import java.io.*;
import java.util.*;


class Solution {

  public int findLCS(String s1, String s2) {
     return findLCSRecursive(s1, s2, 0 , 0); 
  } 
  
  
  private int findLCSRecursive(String s1, String s2, int s1Ptr, int s2Ptr) {
    if(s1Ptr == s1.length() || s2Ptr == s2.length()) 
      return 0;
    
    if(s1.charAt(s1Ptr) == s2.charAt(s2Ptr))
      return 1 + findLCSRecursive(s1, s2, s1Ptr+1, s2Ptr+1);
    
    int c1 = findLCSRecursive(s1, s2, s1Ptr, s2Ptr+1);
    int c2 = findLCSRecursive(s1, s2, s1Ptr+1, s2Ptr);
    return Math.max(c1, c2);
  }  
  
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.findLCS("passport", "ppsspt"));
  }
}
