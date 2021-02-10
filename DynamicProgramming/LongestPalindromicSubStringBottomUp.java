import java.io.*;
import java.util.*;


class Solution {
  
  private static int lps(String str) {
     boolean[][] dp = new boolean[str.length()][str.length()];
      
      int maxLength = 1;
      
      for(int startIndx = str.length()-1; startIndx >= 0; startIndx--) {
        for(int endIndx = startIndx ; endIndx < str.length(); endIndx++) {
          if(startIndx == endIndx) 
            dp[startIndx][startIndx] = true;
          else if(str.charAt(startIndx) == str.charAt(endIndx) && 
                   dp[startIndx+1][endIndx-1]) {
             dp[startIndx][endIndx] = true;
             maxLength = Math.max(maxLength, endIndx - startIndx + 1);    
          } 
        } 
      }  
      
    /*
      for(int startIndx = 0; startIndx < str.length(); startIndx++) {
        for(int endIndx = 0; endIndx < str.length(); endIndx++) {
          System.out.print(dp[startIndx][endIndx] + " ");
        } 
         System.out.println();
      }  
      */
       
       return maxLength;
  }  
  
  public static void main(String[] args) {
     System.out.println(lps("abdbca"));
     System.out.println(lps("cdpdd"));
     System.out.println(lps("pqr"));
  }
  
}
