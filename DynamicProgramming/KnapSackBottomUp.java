package DynamicProgramming;
import java.util.Arrays;

public class KnapSackBottomUp {

    public static void main(String[] args) {
        int[] wt = new int[]{1,3,4,5};
        int[] val = new int[]{1,4,5,7};
        int W = 7;
        System.out.println(knapsack(wt, val, W , val.length));
    }

    public static int knapsack(int[] wt, int[] val, int W, int n){
        int[][] dp = new int[n+1][W+1];
        int result = knapsackRec(wt,val, W ,n, dp);
        for(int i=1; i<=n ; i++){ 
            for(int j=1; j<=W; j++){
                System.out.print(dp[i][j]);
            }
            System.out.println();
        }      
        return result;
     }
 
 
     public static int knapsackRec(int[] wt, int[] val, int W, int n, int dp[][]){
        for(int i=1; i<=n ; i++){ 
            for(int j=1; j<=W; j++){
                if(i == 0 || j== 0) dp[i][j] = 0;
                else if(wt[i-1] <= j)
                    dp[i][j] = max( val[i-1] + dp[i-1][j-wt[i-1]], dp[i-1][j]);
                else
                     dp[i][j] = dp[i-1][j];     
            }
        } 
        return dp[n][W];
     }
 
     static int max(int a, int b) { return (a > b)? a : b; } 

}