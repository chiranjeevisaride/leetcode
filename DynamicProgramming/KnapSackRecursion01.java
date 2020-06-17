package DynamicProgramming;
public class KnapSackRecursion01 {
    
    public static void main(String[] args) {
        int[] wt = new int[]{1,3,4,5};
        int[] val = new int[]{1,4,5,7};
        int W = 7;
        System.out.println(knapsack(wt, val, W , val.length));
    }


    public static int knapsack(int[] wt, int[] val, int W, int n){
        if(n == 0 || W == 0) return 0;    
        else if (wt[n-1] > W) return knapsack(wt, val, W, n-1);   
        else 
            return max( val[n-1] + knapsack(wt, val, W - wt[n-1], n-1), 
                knapsack(wt, val, W, n-1)); 
    }

    static int max(int a, int b) { return (a > b)? a : b; } 

}