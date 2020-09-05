
import java.io.*;
import java.util.*;



class Solution {
  
  public String largestAlphabeticChar(String input) {
    int start = 0, end = input.length() - 1;
    int index = -1;
    boolean[] lowercase = new boolean[26];
    boolean[] uppercase = new boolean[26];
    
    for(char c : input.toCharArray()) {
      if(Character.isUpperCase(c))
          uppercase[c-'A'] = true;
      else
          lowercase[c-'a'] = true;
    }  
    
    for(int i = 0; i < lowercase.length; i++) {
      if(lowercase[i] && uppercase[i]) index = Math.max(index, i);
    }  
    
    return index != -1 ? String.valueOf((char) ('A' + index)) : "NO";
  }  
  
 
  
  public static void main(String[] args) {
     Solution s = new Solution();
     System.out.println(s.largestAlphabeticChar("admeDCAB"));
     System.out.println(s.largestAlphabeticChar("aaaaaa"));
     System.out.println(s.largestAlphabeticChar("CodilIty"));
  }
}
