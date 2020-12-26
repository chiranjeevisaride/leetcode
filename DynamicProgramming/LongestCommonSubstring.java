
import java.io.*;
import java.util.*;


class Solution {

  public int lcs(String s1, String s2) {
    return lcsRec(s1, s2, 0, 0, 0);
  } 
  
  private int lcsRec(String s1, String s2, int s1Ptr, int s2Ptr, int count) {
     
      if(s1Ptr == s1.length() || s2Ptr == s2.length()) 
          return count;
    
      if(s1.charAt(s1Ptr) == s2.charAt(s2Ptr)) 
        count = lcsRec(s1, s2, s1Ptr+1, s2Ptr+1, count+1);
    
    
      int c1 = lcsRec(s1, s2, s1Ptr+1, s2Ptr, 0);
      int c2 = lcsRec(s1, s2, s1Ptr, s2Ptr+1, 0);
    
      return Math.max(count, Math.max(c1, c2));
  } 
  
  
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.lcs("passport", "ppsspt"));
  }
}




class Solution {

  public int lcs(String s1, String s2) {
    return lcsRec(s1, s2, 0, 0, 0, 0);
  } 
  
  private int lcsRec(String s1, String s2, int s1Ptr, int s2Ptr, int count, int maxLen) {
     
      if(s1Ptr == s1.length() || s2Ptr == s2.length()) 
          return maxLen;
       
       
      if(s1.charAt(s1Ptr) == s2.charAt(s2Ptr)) {
        count +=1;
        maxLen = Math.max(maxLen, count);
        return lcsRec(s1, s2, s1Ptr+1, s2Ptr+1, count, maxLen);
      }
    
      return Math.max(lcsRec(s1, s2, s1Ptr+1, s2Ptr, 0, maxLen), 
                      lcsRec(s1, s2, s1Ptr, s2Ptr+1, 0, maxLen));
  } 
  
  
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.lcs("passport", "ppsspt"));
  }
}
