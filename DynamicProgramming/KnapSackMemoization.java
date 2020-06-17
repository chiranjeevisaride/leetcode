package DynamicProgramming;
import java.util.Arrays;

public class KnapSackMemoization {
    
    public static void main(String[] args) {
        int[] wt = new int[]{1,3,4,5};
        int[] val = new int[]{1,4,5,7};
        int W = 7;
        System.out.println(knapsack(wt, val, W , val.length));
    }


    public static int knapsack(int[] wt, int[] val, int W, int n){
       int[][] dp = new int[n+1][W+1];
       Arrays.stream(dp).forEach(row -> Arrays.fill(row, -1));
       return knapsackRec(wt,val, W ,n, dp);
    }


    public static int knapsackRec(int[] wt, int[] val, int W, int n, int dp[][]){
        if(n <= 0) return 0;   
        if(dp[n][W] != -1) return dp[n][W];  
        if (wt[n-1] > W) {
            dp[n][W] = knapsackRec(wt, val, W, n-1, dp);  
            return  dp[n][W];
        }    
        else {
            dp[n][W] = max( val[n-1] + knapsackRec(wt, val, W - wt[n-1], n-1, dp), 
            knapsackRec(wt, val, W, n-1, dp)); 
            return dp[n][W];
        }    
    }

    static int max(int a, int b) { return (a > b)? a : b; } 

}