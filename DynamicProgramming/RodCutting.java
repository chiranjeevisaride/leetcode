import java.io.*;
import java.util.*;


class Solution {
    
  public int robCutting(int[] lengths, int[] prices, int L) {
    if(lengths == null || prices == null || lengths.length != prices.length) 
      return 0;
    return helper(lengths, prices, L, prices.length - 1);
  } 
  
  
  public int helper(int[] lengths, int[] prices, int L, int n) {
    if(L == 0 || n < 0) return 0;
    else if(L >= lengths[n])
      return  Math.max(prices[n] + helper(lengths, prices, L - lengths[n], n), 
                                  helper(lengths, prices, L, n - 1));
    else
      return helper(lengths, prices, L, n - 1);
  }  
  
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.robCutting(new int[]{1,2,3,4,5}, new int[]{2,6,7,10,13}, 5));  
  }
  
}
