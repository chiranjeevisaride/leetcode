class Solution {
  
 
    public static void main(String[] args) {
        System.out.println(subsetSum(new int[]{3, 34, 4, 12, 5, 2}, 14));
    }

    private static boolean subsetSum(int[] arr, int sum) {
      return isSubsetSum(arr, arr.length, sum);
    }  
  
  
   private static boolean isSubsetSum(int[] arr, int n, int sum) {
      boolean[][] dp = new boolean[arr.length + 1][sum + 1];
      for(int i = 0; i <= n; i++) {
        for(int j = 0; j <= sum; j++) {
          if(i == 0) dp[i][j] = false;
          else if(j == 0) dp[i][j] = true;
          else if(arr[i-1] <= j)
                    dp[i][j] = dp[i-1][j-arr[i-1]] ||  dp[i-1][j];
                else
                   dp[i][j] = dp[i-1][j];  
          
        } 
      }
      return dp[n][sum];
   }  
   
}