
import java.io.*;
import java.util.*;



class Solution {
  
  public String cropWords(String s, int k) {
    if(k >= s.length()) return s;
    StringBuffer sb = new StringBuffer(s.substring(0, k));
    
    if(s.charAt(k) != ' ') {
        while(s.charAt(--k) != ' ')
          sb.deleteCharAt(k);
    }
    
     return sb.toString().trim();
  }  
  
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.cropWords("Codility We test coders", 14));
    System.out.println(s.cropWords(" co de my", 5));
    System.out.println(s.cropWords(" co de my", 7));
  }
}
