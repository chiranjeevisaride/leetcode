
import java.io.*;
import java.util.*;



class Solution {
 
  public int minCost(String S, int[] cost) {
    int minCost = 0;
    if(S == null || S.length() < 2) return 0;
    for(int i = 1; i < S.length(); i++) {
      if(S.charAt(i) == S.charAt(i-1))
        minCost += Math.min(cost[i], cost[i-1]);
    }  
    return minCost;
  }  
  
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.minCost("abccbd" ,new int[]{0, 1, 2, 3, 4, 5}));
    System.out.println(s.minCost("aabbcc" ,new int[]{1, 2, 1, 2, 1, 2}));
    System.out.println(s.minCost("aaaa" ,new int[]{3,4,5,6}));
  }
}
