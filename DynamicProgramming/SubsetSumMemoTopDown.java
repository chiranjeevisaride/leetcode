import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/*

Input: set[] = {3, 34, 4, 12, 5, 2}, sum = 9
Output: True  
There is a subset (4, 5) with sum 9.


W = sum
n = arr.length

*/


class Solution {
  
 
    public static void main(String[] args) {
        System.out.println(subsetSum(new int[]{3, 34, 4, 12, 5, 2}, 17));
    }

    private static boolean subsetSum(int[] arr, int sum) {
      boolean[][] dp = new boolean[arr.length + 1][sum + 1];
      return isSubsetSum(arr, arr.length, sum, dp);
    }  
  
  
   private static boolean isSubsetSum(int[] arr, int n, int sum, boolean[][] dp) {
      if(sum == 0) return true;
      else if(n == 0) return false;
      else if(dp[n][sum]) return dp[n][sum];
      else if(arr[n-1] > sum) { 
        dp[n][sum] = isSubsetSum(arr, n-1, sum, dp); 
        return  dp[n][sum];
      }
      else {
       dp[n][sum] = isSubsetSum(arr, n-1, sum - arr[n-1], dp) || isSubsetSum(arr, n-1, sum, dp);
       return dp[n][sum]; 
      }  
   }  
   
}
