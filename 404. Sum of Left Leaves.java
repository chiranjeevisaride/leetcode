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
    public int sumOfLeftLeaves(TreeNode node) {
        if(node == null)
            return 0;
        else if(node.left != null && node.left.left == null && node.left.right == null)
            return node.left.val + sumOfLeftLeaves(node.right);
        else
            return sumOfLeftLeaves(node.left) + sumOfLeftLeaves(node.right);
    }
}