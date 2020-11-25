import java.io.*;
import java.util.*;
import java.util.stream.*;


/*

Given a staircase with ‘n’ steps and an array of ‘n’ numbers representing the fee that you have to pay if you take the step. Implement a method to calculate the minimum fee required to reach the top of the staircase (beyond the top-most step). At every step, you have an option to take either 1 step, 2 steps, or 3 steps. You should assume that you are standing at the first step.


*/


class Solution {
  
   private int minimumNoOfMoves(int[] nums) {
      int[] dp = new int[nums.length + 1];
       
      for(int index = nums.length - 1; index >=0; index--) {
          int oneStep =  index + 1 >= nums.length ? 0 : nums[index + 1];
          int twoStep = index + 2 >= nums.length ? 0 : nums[index + 2];
          int threeStep = index + 3 >= nums.length ? 0 : nums[index + 3];  
          dp[index] = nums[index] + Math.min(Math.min(twoStep, threeStep), oneStep);
      }   
      return dp[0];
   }  
  
  
   public static void main(String[] args) {
    Solution sc = new Solution();
    System.out.println(sc.minimumNoOfMoves(new int[]{1,2,5,2,1,2}));
  }
}