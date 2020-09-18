/*

  Time - O(n)
  Space - O(n)

*/

import java.io.*;
import java.util.*;

public class Solution {
  
    public String simplifyPath(String A) {
        if(A.isEmpty()) return A;
        Stack<String> stack = new Stack<>();
        for(String dir : A.split("/")) {
            if(dir.isEmpty() || dir.equals("."))
              continue;
           else if(dir.equals("..")) {
             if(!stack.isEmpty()) stack.pop();
           }
           else 
             stack.push(dir);
        }
      
        StringBuffer sb = new StringBuffer();
        for(String dir : stack) {
            sb.append("/");
            sb.append(dir);
        }  
       
        return stack.isEmpty() ? "/" : sb.toString();
    }
  
   public static void main(String args[]) {
     Solution s = new Solution();
     System.out.println(s.simplifyPath("/a/./b/../../c/"));
   }  
}
