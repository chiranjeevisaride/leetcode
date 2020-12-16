import java.io.*;
import java.util.*;


class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
      this.val = val;
      this.left = this.right = null;
    }  
}  

class Solution {
  
  TreeNode root;
  
  public String serialize(TreeNode root) {
    if(root == null) return "X";
    String leftValue = serialize(root.left);
    String rightValue = serialize(root.right);
    return root.val + "," + leftValue + "," + rightValue;
  }  
  
  
  public TreeNode deserialize(String data) {
    if(data == null) return null;
    System.out.println(data);
    Queue<String> queue = new LinkedList<>();
    queue.addAll(Arrays.asList(data.split(",")));
    return deserializeHelper(queue); 
  }  
  
  private TreeNode deserializeHelper(Queue<String> queue) {
      String nodeVal = queue.poll();
      if(nodeVal.equals("X")) return null;
      TreeNode root = new TreeNode(Integer.valueOf(nodeVal));
      root.left = deserializeHelper(queue);
      root.right = deserializeHelper(queue);
      return root;
  }  
  
  public static void main(String[] args) {
      Solution s = new Solution();
      s.root = new TreeNode(5);
      s.root.left = new TreeNode(3);
      s.root.right = new TreeNode(9);
      s.root.left.left = new TreeNode(1);
      s.root.right.left = new TreeNode(6);
      s.root.right.right = new TreeNode(11);
      String data = s.serialize(s.root);
      s.deserialize(data);
  }
}
