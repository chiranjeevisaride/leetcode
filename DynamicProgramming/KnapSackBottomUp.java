package DynamicProgramming;
import java.util.Arrays;

public class KnapSackBottomUp {

    public int kanpsack(int[] weights, int[] profits, int capacity) {
        if(capacity <=0 || profits.length == 0 || weights.length != profits.length)
          return 0;
        int n = weights.length;
        int[][] dp = new int[n + 1][capacity + 1];
        for(int i = 1; i <= n; i++) {
          for(int c = 1; c <= capacity; c++) {
             if(weights[i-1] <= c)
                dp[i][c] = Math.max(profits[i-1] + dp[i-1][c-weights[i-1]], dp[i-1][c]);
             else
               dp[i][c] = dp[i-1][c];
          }  
        }  
        return dp[n][capacity];
      }  
     
     public static void main(String[] args) {
       Solution s = new Solution();
       int[] profits = {1,6,10,16};
       int[] weights = {1,2,3,5};
       System.out.println(s.kanpsack(weights, profits, 7));   
     }

}