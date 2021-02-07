
import java.io.*;
import java.util.*;

class Solution {
  
  public static void main(String[] args) {
    System.out.println(lps("abdbca"));
    System.out.println(lps("cddpd"));
    System.out.println(lps("pqr"));
  }
  
  
  private static int lps(String input) {
    Integer[][] dp = new Integer[input.length()][input.length()];
     return lpsRec(dp, input, 0, input.length()-1); 
  }  
  
  private static int lpsRec(Integer[][] dp, String str, int startIndx, int endIndx) {
    //System.out.println(str + " " + startIndx + " " + endIndx);
    if(startIndx > endIndx) return 0;
    if(startIndx == endIndx) return 1;
    if(dp[startIndx][endIndx] != null) return dp[startIndx][endIndx];
    else if(str.charAt(startIndx) == str.charAt(endIndx))
      dp[startIndx][endIndx] = 2 + lpsRec(dp, str, startIndx+1, endIndx-1);
    else
      dp[startIndx][endIndx] = Math.max(lpsRec(dp, str, startIndx+1, endIndx), 
                                        lpsRec(dp, str, startIndx, endIndx-1));
    
    return dp[startIndx][endIndx];
  } 
  
}
