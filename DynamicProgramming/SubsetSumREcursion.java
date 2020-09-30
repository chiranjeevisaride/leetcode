
class Solution {
  
 
    public static void main(String[] args) {
        System.out.println(subsetSum(new int[]{3, 34, 4, 12, 5, 2}, 7));
    }

    private static boolean subsetSum(int[] arr, int sum) {
      return isSubsetSum(arr, arr.length-1, sum);
    }  
  
  
   private static boolean isSubsetSum(int[] arr, int n, int sum) {
      if(sum == 0) return true;
      else if(n < 0) return false;
      else if(arr[n] > sum) return isSubsetSum(arr, n-1, sum);
      else
        return isSubsetSum(arr, n-1, sum - arr[n]) || isSubsetSum(arr, n-1, sum);
   }  
   
}
