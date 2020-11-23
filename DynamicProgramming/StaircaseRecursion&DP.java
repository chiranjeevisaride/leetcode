import java.io.*;
import java.util.*;

/*

Given a number ‘n’, implement a method to count how many possible ways there are to express ‘n’ as the sum of 1, 3, or 4.

 */

class Solution {
  
 public int countWays(int n) {
     if(n < 0) return 0;
     if(n == 0 || n == 1) return 1;
     else
       return countWays(n - 3) + countWays(n - 2) + countWays(n - 1);
 }  
  
  
 public int countWaysDP(int n) {
    int dp[] = new int[n+1];
    dp[0] = 1;
    dp[1] = 1;
    dp[2] = 2;

    for(int i=3; i<=n; i++)
      dp[i] = dp[i-1] + dp[i-2] + dp[i-3];

    return dp[n];
  }

  public static void main(String[] args) {
    Solution sc = new Solution();
    System.out.println(sc.countWays(3));
    System.out.println(sc.countWaysDP(4));
    System.out.println(sc.countWays(5));
  }
  
}
