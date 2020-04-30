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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<Integer>();
        queue.add(root);
        boolean leftToRight = true;
        while(!queue.isEmpty()){
            int size = queue.size();
            LinkedList<Integer> levelNodes = new LinkedList<Integer>();
            for(int i=0; i<size; i++){
                TreeNode current = queue.poll();
                if(leftToRight)
                    levelNodes.add(current.val);
                else
                    levelNodes.addFirst(current.val);
                if(!visited.contains(current.val)){
                    visited.add(current.val);
                } 
                if(current.left != null) queue.add(current.left);
                if(current.right != null) queue.add(current.right);
            }
            leftToRight = !leftToRight;
            res.add(levelNodes);
        }
        
        return res;
    }
}