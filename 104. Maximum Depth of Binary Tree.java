//Recursion
//Time - O(n) Space - O(logn)

class Solution {
    public int maxDepth(TreeNode node) {
     if(node == null) return 0;
     int leftDepth = maxDepth(node.left);
     int rightDepth = maxDepth(node.right);
     return Math.max(leftDepth, rightDepth) + 1; 
    }
}
//BFS
//Time - O(n) Space - O(n)

class Solution {
    public int maxDepth(TreeNode node) {
     int depth = 0;
     if(node == null) return depth;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(node);
    while(!queue.isEmpty()) {
      int size = queue.size();
      depth++;
      for(int i = 0; i < size; i++) {
        TreeNode root = queue.poll();
        if(root.left != null) queue.add(root.left);
        if(root.right != null) queue.add(root.right);
      }  
    }  
    return depth;
    }
}