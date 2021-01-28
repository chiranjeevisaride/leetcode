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
    int count = 0;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode result = getLCA(root, p, q);
        return count == 2 ? result : null;
    }
    
    private TreeNode getLCA(TreeNode node, TreeNode p, TreeNode q) {
        if(node == null) return null;
        TreeNode leftNode = getLCA(node.left, p, q);
        TreeNode rightNode = getLCA(node.right, p, q);
        if(leftNode != null && rightNode != null) 
            return node;
        else if(node.val == p.val || node.val == q.val) {
             count ++;
             return node;
        }
        else if(leftNode == null && rightNode == null)
            return null;
        return leftNode == null ? rightNode : leftNode;
    }
}