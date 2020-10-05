import java.io.*;
import java.util.*;


class Solution {
  
  public int targetSum(int[] arr, int S) {
    if(arr == null || arr.length == 0) return 0; 
    int total = 0;
    for(int i=0; i<arr.length; i++)
      total += arr[i];
    if(total < S || (S+total)%2 == 1) return 0;
    return targetSumDP(arr, S + (total)/ 2, arr.length);
  }  
  
  
  public int targetSumDP(int[] arr, int S, int n) {
        int[][] dp = new int[n + 1][S + 1];
     
       for(int i=0; i<= n; i++)
        dp[i][0] = 1;

       for(int s=1; s <= S ; s++)
        dp[0][s] = 0;

        for(int i = 1; i <= n; i++) {
          for(int s = 1; s <= S; s++) {
            if(arr[i-1] > s)
               dp[i][s] = dp[i-1][s]; 
            else
                dp[i][s] = dp[i-1][s-arr[i-1]] +  dp[i-1][s];              
          } 
        }
        return dp[n][S];
  }  
  
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.targetSum(new int[]{1, 1, 2, 3}, 1));
  }
  
}
