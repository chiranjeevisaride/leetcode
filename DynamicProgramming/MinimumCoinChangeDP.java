class Solution {
  
    private int minCoinChange(int[] arr, int T) {
      if(arr == null || arr.length == 0 || T <=0) return 0;
      return minCoinChangeDP(arr, T);
    }  
  
    private int minCoinChangeDP(int[] arr, int T) {
      int n = arr.length;
      int[][] dp = new int[n+1][T+1];
      
      for(int t=0; t<=T; t++)
        dp[0][t] = Integer.MAX_VALUE;
      
      for(int i=1; i<=n; i++) {
        for(int t=1; t<=T; t++) {
          if(arr[i-1] > t)
            dp[i][t] = dp[i-1][t];
          else
            dp[i][t] = Math.min(1 + dp[i][t-arr[i-1]], dp[i-1][t]);
        }  
      }  
      return dp[n][T];
    }  
    
    public static void main(String[] args) {
      Solution s = new Solution();
      System.out.println(s.minCoinChange(new int[]{1,2,3}, 5));
      System.out.println(s.minCoinChange(new int[]{1,2,3}, 11));
      System.out.println(s.minCoinChange(new int[]{1,2,3}, 7));
    }
    
  }
  