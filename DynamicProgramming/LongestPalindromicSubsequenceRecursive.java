
import java.io.*;
import java.util.*;



class Solution {
  
  public static void main(String[] args) {
    System.out.println(lps("abdbca"));
    System.out.println(lps("cddpd"));
    System.out.println(lps("pqr"));
  }
  
  
  private static int lps(String input) {
     return lpsRec(input, 0, input.length()-1); 
  }  
  
  private static int lpsRec(String str, int startIndx, int endIndx) {
   //System.out.println(str + " " + startIndx + " " + endIndx);
    if(startIndx > endIndx) return 0;
    if(startIndx == endIndx) return 1;
    else if(str.charAt(startIndx) == str.charAt(endIndx))
      return 2 + lpsRec(str, startIndx+1, endIndx-1);
    else
      return Math.max(lpsRec(str, startIndx+1, endIndx), lpsRec(str, startIndx, endIndx-1));
  } 
  
}
