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
// Pattern - inorder traversal is ascending order when node at n matches k return it 
// inorder recursion - O(n) Space - O(1)
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int[] nums = new int[2];
        inorder(root, nums, k);
        return nums[1];
    }
    
    
    public void inorder(TreeNode root, int[] nums, int k) {
        if(root == null) return;
        inorder(root.left, nums, k);
        if(++nums[0] == k) nums[1] = root.val;
        inorder(root.right, nums, k);    
    }
}


// inorder iteration - O(n) Space - O(1)
// memory most efficient 
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        return  inorder(root, k);
    }
    
    
    public int inorder(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode current = root;
        int[] nums = new int[2];
        while(current != null || !stack.isEmpty()){
            while(current != null){
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            if(++nums[0] == k) {
                nums[1] = current.val;
                break;
            }
           
            current = current.right;
        }
        return nums[1];
    }
}