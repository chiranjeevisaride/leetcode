class Solution {
  
    private static int lps(String str) {
      
      int[][] dp = new int[str.length()][str.length()];
      
      for(int startIndx = 0; startIndx < str.length(); startIndx++)
        dp[startIndx][startIndx] = 1;
      
      for(int startIndx = str.length()-1; startIndx >= 0; startIndx--) {
        for(int endIndx = startIndx + 1; endIndx < str.length(); endIndx++) {
            
            if(str.charAt(startIndx) == str.charAt(endIndx)) {
              dp[startIndx][endIndx] = 2 + dp[startIndx+1][endIndx-1]; 
            } else {
               dp[startIndx][endIndx] = Math.max(dp[startIndx+1][endIndx], dp[startIndx][endIndx-1]);
            }  
        } 
      }  
      
      /*
      for(int startIndx = 0; startIndx < str.length(); startIndx++) {
        for(int endIndx = 0; endIndx < str.length(); endIndx++) {
          System.out.print(dp[startIndx][endIndx] + " ");
        } 
         System.out.println();
      }  
      */
       
       return dp[0][str.length()-1];
    }
    
    
    
    public static void main(String[] args) {
       System.out.println(lps("cddpd"));
       System.out.println(lps("aaaabbaa"));
    }
    
  }
  