import java.io.*;
import java.util.*;

/*


         3  
       1   5 
     5   7 
          9
        11 

 */

class TreeNode {
  int val;
  TreeNode left, right;
  TreeNode(int val) {
   this.val = val;
   left = null;
   right = null; 
  }  
}  

class Pair {
  TreeNode key;
  Integer value;
  Pair(TreeNode key, Integer value) {
    this.key = key;
    this.value = value;
  }  
}  

class Solution {
  
  
  TreeNode root;
  
  Solution() {
   root = null; 
  }  
  
  public int numberOfVisibleNodes(TreeNode root) {
     if(root == null) return 0;
     int max_value = Integer.MIN_VALUE;
     int count = 0;
     Stack<Pair> stack = new Stack<>();
     stack.push(new Pair(root, root.val)); 
     while(!stack.isEmpty()) {
       Pair pair  = stack.pop();
       TreeNode node = pair.key;
       if(node.val >= pair.value) {
         if(node.val > max_value)
            max_value = node.val;
         count++;
       } 
        if(node.left != null)
          stack.push(new Pair(node.left, node.val));
        if(node.right != null)
          stack.push(new Pair(node.right, node.val));
     }  
     return count;
  }  
  
  public static void main(String[] args) {
      Solution s = new Solution();
      s.root = new TreeNode(5);
      s.root.left = new TreeNode(3);
      s.root.left.left = new TreeNode(20);
      s.root.left.right = new TreeNode(21);
      s.root.right = new TreeNode(10);
      s.root.right.left = new TreeNode(1);
      test(s.numberOfVisibleNodes(s.root), 4); 
    
      s.root = new TreeNode(-10);
      s.root.right = new TreeNode(-15);
      s.root.right.right = new TreeNode(-1);
      test(s.numberOfVisibleNodes(s.root), 2);
  }
  
  private static void test(int actual, int expected) {
      if (actual == expected) {
        System.out.println("PASSED!");
      } else {
        System.out.println(String.format("FAILED! Expected %d, but got: %d", expected, actual));
      }
  }
  
  
}
