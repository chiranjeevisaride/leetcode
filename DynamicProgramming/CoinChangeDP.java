class Solution {
  
    public int coinChange(int[] denominations, int total) {
      if(denominations == null || denominations.length== 0 || total <=0) return 0;
      return coinChangeDP(denominations, total);
    }
    
    
    private int coinChangeDP(int[] denominations, int total) {
      int n = denominations.length;
      int[][] dp = new int[n+1][total+1];
      
      for(int i=0; i<=n; i++)
        dp[i][0] = 1;
      for(int t=1; t<=total;t++)
        dp[0][t] = 0;
      
      for(int i=1; i<=n; i++) {
        for(int t=1; t<= total; t++) {
          if(denominations[i-1] > t)
            dp[i][t] = dp[i-1][t];
          else
            dp[i][t] = dp[i][t-denominations[i-1]] + dp[i-1][t];
        }  
      }  
      return dp[n][total];
    }  
    
    public static void main(String[] args) {
      Solution s = new Solution();
      System.out.println(s.coinChange(new int[]{1,2,3}, 5));
    }
  }