package DataStructures;

import java.util.Stack;


class InorderTraversalIterative { 
    TreeNode root;


    void inOrderRecursive(TreeNode node){
            if(node == null) return;
            inOrderRecursive(node.left);
            System.out.println(node.data);
            inOrderRecursive(node.right);
    }

    void inOrder() {
        if(root == null) return;;
        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(current != null || !stack.isEmpty()){
            while(current != null) {
                stack.push(current);
                current = current.left;
            }
             current = stack.pop();
             System.out.println(current.data);
             current = current.right;
        }
    }
  
    public static void main(String[] args) {
        InorderTraversalIterative tree = new InorderTraversalIterative();
        tree.root = new TreeNode(8);
        tree.root.left = new TreeNode(6);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(7);
        tree.root.right = new TreeNode(10);
        tree.root.right.left = new TreeNode(9);
        tree.root.right.right = new TreeNode(11);
        System.out.println("Tree Traversal Iterative");
        tree.inOrder();
        System.out.println("Tree Traversal Recursive");
        tree.inOrderRecursive(tree.root);
    }
} 


class TreeNode { 
    int data; 
    TreeNode left, right; 
  
    public TreeNode(int item) { 
        data = item; 
        left = right = null; 
    } 
} 