class Solution {
    
    public int unBoundedKnapSack(int[] wt, int[] val, int C) {
      if(wt == null || val == null || wt.length != val.length || C <= 0) return 0;
      return knapSackDP(wt, val, C);
    }  
    
    
    private int knapSackDP(int[] wt, int[] val, int C) {
     int n = wt.length;
     int[][] dp = new int[n+1][C+1];
      for(int i = 1; i<= n; i++) {
        for(int c = 1; c <= C; c++) {
          if(wt[i-1] <= c)
            dp[i][c] = Math.max(val[i-1] + dp[i][c-wt[i-1]], dp[i-1][c]);
          else
            dp[i][c] = dp[i-1][c];
        }  
      }  
      return dp[n][C];
    }  
    
    public static void main(String[] args) {
      Solution s = new Solution();
      System.out.println(s.unBoundedKnapSack(new int[]{1, 2, 3}, new int[]{15, 20, 50}, 5));
      System.out.println(s.unBoundedKnapSack(new int[]{1, 3, 4, 5}, new int[]{15, 50, 60, 90}, 8));
    }
    
  }
  