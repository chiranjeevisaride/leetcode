
import java.io.*;
import java.util.*;



class Solution {
 
   public int largestMAlignedSubset(int[] nums, int M) {
      int[] counter = new int[M];
      int result = 0;
      for(int i = 0; i < nums.length; i++) {
         int index = Math.abs(nums[i]%M);
         counter[index] += 1;
      } 
     
      for(int i = 0; i < counter.length; i++) {
        result = Math.max(result, counter[i]);
      }  
      return result < M ? 0 : result;
   }  
  
  
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.largestMAlignedSubset(new int[]{-3, -2, 1, 0, 8, 7, 1}, 3));
    System.out.println(s.largestMAlignedSubset(new int[]{7, 2, 4, 8, 6}, 2));
    System.out.println(s.largestMAlignedSubset(new int[]{3, 1, 4, 1, 5}, 1));
  }
}
