/*

  Time - O(n)
  Space - O(n)

*/

import java.io.*;
import java.util.*;

public class Solution {
  
  public int[] nextGreaterRight(int[] nums) {
    Stack<Integer> stack = new Stack<>();
    int[] output = new int[nums.length];
    for(int i = nums.length - 1; i >= 0; i--) {
      if(stack.isEmpty())
        output[i] = -1;
      else if(!stack.isEmpty() && nums[i] < stack.peek()) {
        output[i] = stack.peek();
      } else {
          while(!stack.isEmpty() && nums[i] > stack.peek())
            stack.pop(); 
       output[i] = stack.isEmpty() ? -1 : stack.peek();
      }  
       stack.push(nums[i]); 
    } 
    return output;
  }
  
  public static void main(String args[]) {
     Solution s = new Solution();
     int[] output = s.nextGreaterRight(new int[]{4,8,2,10,8});
     for(int i : output) System.out.print(i + " ");
  }  
}
