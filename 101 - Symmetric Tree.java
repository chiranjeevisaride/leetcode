/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// 1st Method BFS
// Recursion
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return checkSymmetric(root, root);
    }
    
   private boolean checkSymmetric(TreeNode t1, TreeNode t2){
       if(t1 == null && t2 == null) return true;
       if(t1 == null || t2 == null) return false;
       return (t1.val == t2.val) && checkSymmetric(t1.right, t2.left) &&
           checkSymmetric(t1.left, t2.right);
   }
}

// BFS - Time & Space O(n)
// 2nd Method BFS
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return true;
        if (root.left == null || root.right == null) return false;
        return checkSymmetric(root);
    }
    
    public boolean checkSymmetric(TreeNode root) {
       Queue<TreeNode> queue = new LinkedList<TreeNode>();
       queue.add(root.left); queue.add(root.right);
       while(!queue.isEmpty()){
           for(int i=0; i< queue.size()/2; i++){
               TreeNode root1 = queue.poll();
               TreeNode root2 = queue.poll();
               
               if(!compareNodes(root1, root2)) return false;
                
               if (root1.left != null) {
                    queue.add(root1.left); 
                    queue.add(root2.right);
                }
               
                if (root1.right != null) {
                    queue.add(root1.right); 
                    queue.add(root2.left);
                }
           }
       } 
        return true;   
    }
    
    public boolean compareNodes(TreeNode root1, TreeNode root2) {
        if(root1.val != root2.val) return false;
        if(root1.left != null && root2.right == null ||
           root2.right != null && root1.left == null ||
           root1.right != null && root2.left == null ||
           root2.left != null && root1.right == null) return false;
        return true;   
    }
}