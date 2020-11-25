import java.io.*;
import java.util.*;
import java.util.stream.*;


class Solution {
  
   private int minimumNoOfMoves(int[] nums) {
      Integer[] dp = new Integer[nums.length];
      dp[nums.length-1] = 1;
      for(int index = nums.length - 2; index >= 0; index--) {
          int jumps = nums[index];
          int temp = 0;
          for(int jump = 1; jump <= jumps; jump++) {
             if(index + jump < nums.length)
                temp += dp[index + jump];  
          }  
         dp[index] = temp;
      }   
      return dp[0];
   }  
  
  
   public static void main(String[] args) {
    Solution sc = new Solution();
    System.out.println(sc.minimumNoOfMoves(new int[]{2,1,1,1,4}));
  }
}