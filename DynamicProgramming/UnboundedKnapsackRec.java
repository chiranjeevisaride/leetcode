class Solution {
    
    public int unBoundedKnapSack(int[] wt, int[] val, int W) {
      if(wt == null || val == null || wt.length != val.length || W <= 0) return 0;
      return knapSackRec(wt, val, W, wt.length-1);
    }  
    
    
    private int knapSackRec(int[] wt, int[] val, int W, int n) {
      if(W == 0 || n < 0) return 0;
      else if(wt[n] <= W)
        return Math.max(val[n] + knapSackRec(wt, val, W-wt[n], n), knapSackRec(wt, val, W, n-1));
      else
        return knapSackRec(wt, val, W, n-1);
    }  
    
    public static void main(String[] args) {
      Solution s = new Solution();
      System.out.println(s.unBoundedKnapSack(new int[]{1, 2, 3}, new int[]{15, 20, 50}, 5));
      System.out.println(s.unBoundedKnapSack(new int[]{1, 3, 4, 5}, new int[]{15, 50, 60, 90}, 8));
    }
    
  }
  