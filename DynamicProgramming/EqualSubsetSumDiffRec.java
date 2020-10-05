import java.io.*;
import java.util.*;


class Solution {
  public int minimumSubsetSumDiff(int[] arr) {
    if(arr == null || arr.length == 0) return 0;
    return minimumSubsetSumDiffRec(arr, 0, 0, arr.length - 1);
  }
  
  public int minimumSubsetSumDiffRec(int[] arr, int S1, int S2, int n) {
    if(n < 0) return Math.abs(S1-S2);
    else
      return Math.min(minimumSubsetSumDiffRec(arr, S1 + arr[n], S2, n-1), 
      minimumSubsetSumDiffRec(arr, S1, S2 + arr[n], n-1));
  }  
  
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.minimumSubsetSumDiff(new int[]{1, 3, 100, 4}));
  }
}
