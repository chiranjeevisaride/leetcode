class Solution {
  
    private int minCoinChange(int[] arr, int T) {
      if(arr == null || arr.length == 0 || T <=0) return 0;
      return minCoinChangeRec(arr, T, arr.length-1, 0);
    }  
    
    
    private int minCoinChangeRec(int[] arr, int T, int n, int count) {
      if(T == 0) return count;
      if(n < 0) return Integer.MAX_VALUE;
      if(arr[n] > T) return minCoinChangeRec(arr, T, n-1, count);
      else 
        return Math.min(minCoinChangeRec(arr, T-arr[n], n, count+=1), minCoinChangeRec(arr, T, n-1, count));
    }  
    
    public static void main(String[] args) {
      Solution s = new Solution();
      System.out.println(s.minCoinChange(new int[]{1,2,3}, 5));
      System.out.println(s.minCoinChange(new int[]{1,2,3}, 11));
      System.out.println(s.minCoinChange(new int[]{1,2,3}, 7));
    }
    
  }
  