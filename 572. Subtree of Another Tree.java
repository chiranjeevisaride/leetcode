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


 // Time - O(m*n) Space - O(n)
 class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
       return  s!= null && (equals(s,t) || isSubtree(s.left, t) || isSubtree(s.right, t));
    }
    
    public boolean equals(TreeNode s, TreeNode t){
        if(s == null && t == null) return true;
        if(s == null || t == null) return false;
        if(s.val != t.val) return false;
        return (s.val == t.val) && equals(s.left, t.left) && equals(s.right, t.right);
    }
}
