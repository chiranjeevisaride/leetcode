import java.io.*;
import java.util.*;


class Solution {
  
   private int minimumNoOfMoves(int[] nums) {
      Integer[] dp = new Integer[nums.length];
      dp[nums.length-1] = 0;
      for(int index = nums.length - 2; index >= 0; index--) {
          int jumps = nums[index];
          int minJump = Integer.MAX_VALUE;
          for(int jump = 1; jump <= jumps; jump++) {
             if(index + jump < nums.length)
                minJump = Math.min(minJump, dp[index + jump]);  
          }  
          dp[index] = minJump == Integer.MAX_VALUE ? 0 : 1 + minJump;
      }   
      return dp[0];
   }  
  
  
   public static void main(String[] args) {
    Solution sc = new Solution();
    System.out.println(sc.minimumNoOfMoves(new int[]{2,1,1,1,4}));
    System.out.println(sc.minimumNoOfMoves(new int[]{1,1,3,6,9,3,0,1,3}));
  }
}