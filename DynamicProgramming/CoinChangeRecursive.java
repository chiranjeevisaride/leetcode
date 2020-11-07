class Solution {
    public int coinChange(int[] denominations, int total) {
      if(denominations == null || denominations.length== 0 || total <=0) return 0;
      return coinChangeRec(denominations, total, denominations.length-1);
    }
    
    private int coinChangeRec(int[] denominations, int total, int currentIndex) {
      if(total == 0) return 1;
      if(currentIndex < 0) return 0;
      if(denominations[currentIndex] <= total) 
        return coinChangeRec(denominations, total - denominations[currentIndex], currentIndex) 
        + coinChangeRec(denominations, total, currentIndex - 1);
      else
       return coinChangeRec(denominations, total, currentIndex-1);
    }  
    
    public static void main(String[] args) {
      Solution s = new Solution();
      System.out.println(s.coinChange(new int[]{1,2,3}, 5));
    }
  }
  