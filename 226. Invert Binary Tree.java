/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

 // 1st Method - Recursion 
class Solution {
    public TreeNode invertTree(TreeNode root) {
        TreeNode head = root;
        recursion(head);
        return root;
    }
    
    
   private void recursion(TreeNode root) {
     if(root == null) return;
      invertTree(root.left);
      invertTree(root.right);
      if(root.left != null && root.right != null) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
      } else if(root.left != null && root.right == null) {
           root.right = root.left;
           root.left = null;
      }
       else if(root.left == null && root.right != null) {
           root.left = root.right;
           root.right = null;
       } 
    }  
}

// 2nd Method - Recursion 
class Solution {
    public TreeNode invertTree(TreeNode root) {
       if(root == null) return root;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}


// 3rd Method - Iteration 
