import java.io.*;
import java.util.*;

/*

  a b c z d -> a b c d 
  
  x y a z -> x y z
  
  
  z x y z 

 */

class Solution {
  
  private static String getSmallString(String s) {
    if(s == null || s.length() == 0) return s;
    StringBuilder sb = new StringBuilder();
    Stack<Character> stack = new Stack<>();
    int counter = 0;
    for(int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
     if(!stack.isEmpty() && counter < 1 && stack.peek() > c) {
        stack.pop();
        ++counter;
      }
      stack.push(c);
    }
    
    if(counter == 0)
      stack.pop();
    
    while(!stack.isEmpty())
      sb.insert(0, stack.pop());
    
    return sb.toString();
}
  
  public static void main(String[] args) {
  String s1 = "abczd";
  System.out.println(getSmallString(s1));
  String s2 = "axyz";
  System.out.println(getSmallString(s2));
  }
}
