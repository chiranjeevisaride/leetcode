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
    
    class MyNode {
        TreeNode node;
        int depth;
        MyNode(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }
    
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if(root == null) return new ArrayList();
        Map<Integer, List<Integer>> map = new TreeMap<>();
        Queue<MyNode> queue = new LinkedList<>();
        queue.offer(new MyNode(root, 0));
        while(!queue.isEmpty()) {
            MyNode currentNode = queue.poll();
            map.putIfAbsent(currentNode.depth, new ArrayList<>());
            map.get(currentNode.depth).add(currentNode.node.val);
            if(currentNode.node.left != null) {
                queue.offer(new MyNode(currentNode.node.left, currentNode.depth -1));
            }
            if(currentNode.node.right != null) {
                queue.offer(new MyNode(currentNode.node.right, currentNode.depth + 1));
            }
        }
        return new ArrayList<>(map.values());
    }
}