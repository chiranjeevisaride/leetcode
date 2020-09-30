import java.io.*;
import java.util.*;


class Solution {
  
  public int countOfSubsetSum(int[] arr, int S) {
    return countOfSubsetSumRRec(arr, S, arr.length-1);
  } 
  
  
  public int countOfSubsetSumRRec(int[] arr, int S, int n) {
    if(S == 0) return 1;
    if(n < 0) return 0;
    else if(arr[n] > S) return countOfSubsetSumRRec(arr, S, n-1);
    else 
      return countOfSubsetSumRRec(arr, S - arr[n], n-1) + countOfSubsetSumRRec(arr, S, n-1);
  }  
  
 
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.countOfSubsetSum(new int[]{1,1,2,3}, 4));
  }
}
