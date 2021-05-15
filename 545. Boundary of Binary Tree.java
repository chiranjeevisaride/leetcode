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
class Solution {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        if(root.left != null || root.right != null) {
            leftBoundry(root.left, list);
            addLeaves(root, list);
            rightBoundry(root.right, list);
        }
        return list;
    }
    
    private void leftBoundry(TreeNode root, List<Integer> list) {
        while(root != null && (root.left != null || root.right != null)) {
            list.add(root.val);
            if(root.left != null)
                root = root.left;
            else
               root = root.right; 
        }
    }
    
    private void addLeaves(TreeNode node, List<Integer> list) {
        if(node != null && (node.left != null || node.right != null)) {
            addLeaves(node.left, list);
            addLeaves(node.right, list);
        } else if(node != null)
            list.add(node.val);
    }
    
    private void rightBoundry(TreeNode root, List<Integer> list) {
        Stack<Integer> stack = new Stack<>();
        while(root != null && (root.left != null || root.right != null)) {
            stack.push(root.val);
            if(root.right != null)
                root = root.right;
            else
                root = root.left;
        }
        while(!stack.isEmpty())
          list.add(stack.pop());
    }
    
}
