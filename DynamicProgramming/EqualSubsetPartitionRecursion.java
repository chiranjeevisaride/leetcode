// O(n^2)

class Solution {
  
    public int countSubsetSum(int[] arr, int S) {
      if(arr == null || arr.length == 0 || S < 0) return 0;
      return subsetSumRec(arr, S, arr.length-1);
    }  
   
    public int subsetSumRec(int[] arr, int S, int n) {
       if(S == 0) return 1;
       else if(n < 0) return 0;
       else if(arr[n] > S) return subsetSumRec(arr, S, n-1);
       else return subsetSumRec(arr, S - arr[n], n-1) + subsetSumRec(arr, S, n-1);
    }  
    
   public static void main(String[] args) {
     Solution s = new Solution();
     System.out.println(s.countSubsetSum(new int[]{1, 1, 2, 3}, 4));
   }
   
 }