import java.io.*;
import java.util.*;


class Solution {
  
  public int targetSum(int[] arr, int S) {
    if(arr == null || arr.length == 0) return 0; 
    return targetSumRec(arr, 0, S, arr.length-1);
  }  
  
  
  public int targetSumRec(int[] arr, int sum, int S, int n) {
   if(n < 0) return sum == S ? 1 : 0;
   else
     return targetSumRec(arr, sum + arr[n], S, n-1) 
     + targetSumRec(arr, sum - arr[n], S, n-1);
  }  
  
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.targetSum(new int[]{1, 1, 2, 3}, 1));
  }
  
}
