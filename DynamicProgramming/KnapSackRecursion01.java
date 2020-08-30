package DynamicProgramming;

class Solution {
  
 
    public static void main(String[] args) {
        System.out.println(knapsack(new int[]{1,3,4,5}, new int[]{1,4,5,7}, 7));
    }

    private static int knapsack(int[] wt, int[] val, int W){
      return knapsackRec(wt, val, W, wt.length-1);
    }  

    private static int knapsackRec(int[] wt, int[] val, int W, int n){
        if(n <= 0 || W == 0) return 0;    
        else if (wt[n] > W) return knapsackRec(wt, val, W, n-1);   
        else 
            return Math.max(val[n] + knapsackRec(wt, val, W - wt[n], n-1), 
                knapsackRec(wt, val, W, n-1)); 
    }
  
}
