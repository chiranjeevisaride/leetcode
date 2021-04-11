/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/*
Complexity Analysis
Time complexity : O(N) since each node is processed exactly once.
Space complexity : O(N) to keep the output structure which contains N node values.
*/
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<Integer>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> levelNodes = new ArrayList<Integer>();
            for(int i=0; i<size; i++){
                TreeNode current = queue.poll();
                levelNodes.add(current.val);
                if(!visited.contains(current.val)){
                    visited.add(current.val);
                } 
                if(current.left != null) queue.add(current.left);
                if(current.right != null) queue.add(current.right);
            }
            res.add(levelNodes);
        }
        
        return res;
    }
}