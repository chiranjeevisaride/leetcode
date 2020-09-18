/*

  Time - O(n)
  Space - O(n)

*/

import java.io.*;
import java.util.*;

public class Solution {
  
  public int[] nearestLeft(int[] input) {
    Stack<Integer> stack = new Stack<>();
    int[] output = new int[input.length];
    for(int i = 0; i < input.length; i++) {
       if(stack.isEmpty()) { 
         output[i] = -1; 
       }
       else if(stack.peek() < input[i]) {
          output[i] = stack.peek();
       } else {
          while(!stack.isEmpty() && input[i] < stack.peek()) {
               stack.pop();
          }
          output[i] = stack.isEmpty() ? -1 : stack.peek(); 
       } 
       stack.push(input[i]);
    } 
    return output;
  }  
  
  public static void main(String args[]) {
     Solution s = new Solution();
     int[] output = s.nearestLeft(new int[]{4,5,2,10,8});
     for(int i : output) System.out.print(i + " ");
  }  
}
