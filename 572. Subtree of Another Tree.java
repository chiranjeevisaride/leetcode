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

 
 // 1st Approach Recursion
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

// 2nd Approach DFS + BFS 
class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(s);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            
            if (node.val == t.val) {
                if (comapre(node, t)) {
                    return true;
                }
            }
            
            if (null != node.right) {
                stack.push(node.right);
            }
            
            if (null != node.left) {
                stack.push(node.left);
            }
        }
        return false;
    }
    
    private boolean comapre(TreeNode main, TreeNode sub) {
        Queue<TreeNode> qMain = new LinkedList<>();
        Queue<TreeNode> qSub = new LinkedList<>();
        
        qSub.add(sub);
        qMain.add(main);
        
        while(!qMain.isEmpty() && !qSub.isEmpty()) {
            int childrenCount = qSub.size();
            for (int i = 0; i < childrenCount; i++) {
                TreeNode mainNode = qMain.poll();
                TreeNode subNode = qSub.poll();
                
                if (!checkNodes(subNode, mainNode)) {  
                    return false;
                }
                
                if (null != subNode.right) {
                    qSub.add(subNode.right);
                    qMain.add(mainNode.right);
                }
                if (null != subNode.left) {
                    qSub.add(subNode.left);
                    qMain.add(mainNode.left);
                }
            }
        }
        return true;
    }
    
    private boolean checkNodes(TreeNode a, TreeNode b) {
        if (a.val != b.val) {
            return false;
        }
        if ((a.left == null && b.left != null) || (a.left != null && b.left == null)) {
            return false;
        }
        if ((a.right == null && b.right != null) || (a.right != null && b.right == null)) {
            return false;
        }
        if (null != a.left && a.left.val != b.left.val) {
            return false;
        }
            if (null != a.right && a.right.val != b.right.val) {
            return false;
        }
        return true;
    }
    
}    
    