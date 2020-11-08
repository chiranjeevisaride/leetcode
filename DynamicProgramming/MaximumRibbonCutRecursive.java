class Solution {
  
    public int maximimRibbonCut(int[] lengths, int L) {
      if(lengths == null || lengths.length == 0 || L <=0) 
        return 0;
      return maximimRibbonCutRec(lengths, L, lengths.length-1, 0);
    }  
    
    private int maximimRibbonCutRec(int[] lengths, int L, int n, int count) {
      if(L == 0) return count;
      if(n < 0) return Integer.MIN_VALUE;
      if(lengths[n] > L)
        return maximimRibbonCutRec(lengths, L, n-1, count);
      else
        return Math.max(maximimRibbonCutRec(lengths, L-lengths[n], n, count+1), 
                        maximimRibbonCutRec(lengths, L, n-1, count));
    }
    
    public static void main(String[] args) {
      Solution s = new Solution();
      System.out.println(s.maximimRibbonCut(new int[]{2,3,5}, 5));
      System.out.println(s.maximimRibbonCut(new int[]{2,3}, 7));
       System.out.println(s.maximimRibbonCut(new int[]{3,5,7}, 13));
    }
    
  }
  