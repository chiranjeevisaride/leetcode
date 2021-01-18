/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        return isBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean isBST(TreeNode node, long min ,long max) {
        if(node == null) return true;
        if(node.val <= min || node.val >= max) 
                return false;
          return isBST(node.left, min, (long) node.val) && 
            isBST(node.right, (long) node.val, max);  
    } 
}