class Solution {
  
    public int maximimRibbonCut(int[] lengths, int L) {
      if(lengths == null || lengths.length == 0 || L <=0) 
        return 0;
      return maximimRibbonCutDP(lengths, L);
    }  
    
    private int maximimRibbonCutDP(int[] lengths, int L) {
      int n = lengths.length;
      int[][] dp = new int[n+1][L+1];
      for(int l=0; l<=L; l++)
        dp[0][l] = Integer.MIN_VALUE;
      for(int i=1; i<=n; i++) {
       for(int l=1; l<= L; l++) {
         if(lengths[i-1] > l)
           dp[i][l] = dp[i-1][l];
         else
           dp[i][l] = Math.max(1 + dp[i][l-lengths[i-1]], dp[i-1][l]);
        } 
      }  
      return dp[n][L];
    }
    
    public static void main(String[] args) {
      Solution s = new Solution();
      System.out.println(s.maximimRibbonCut(new int[]{2,3,5}, 5));
      System.out.println(s.maximimRibbonCut(new int[]{2,3}, 7));
      System.out.println(s.maximimRibbonCut(new int[]{3,5,7}, 13));
    }
    
  }
  