import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


class TreeNode {
  int val;
  TreeNode left, right;
  TreeNode(int val) {
    this.val = val;
    this.left = this.right = null;
  }  
}  

class BinarySearchTree {
  
  TreeNode root;
  
  public boolean insert(int val) {
    TreeNode newNode = new TreeNode(val);
    if(root == null)
      root = newNode;
    else {
      TreeNode current = root, parent = null;
      while(current != null) {
         parent = current;
         if(val <= current.val)
          current = current.left;
        else
          current = current.right;
       }
       if(val > parent.val)
         parent.right = newNode;
       else
         parent.left = newNode;
    }  
    return true;
  }
  
  public void display() {
      if(root == null) return;
      Stack<TreeNode> stack = new Stack<>();
      TreeNode current = root;
      while(current != null || !stack.isEmpty()) {
        while(current != null) {
          stack.push(current);
          current = current.left;
        }
        current = stack.pop();
        System.out.print(current.val + " ");
        current = current.right;
      }  
    System.out.println();
  }
  
  public boolean delete(int val) {
    if(root == null) return false;
    else {
      TreeNode current = root, parent = null; 
      while(current != null && current.val != val) {
         parent = current;
         if(val < current.val)
          current = current.left;
        else
          current = current.right;
       }
       
       if(current == null) {
          System.out.println("Node not found");
          return false;
       } else if(current.left == null || current.right == null) {
          // Node has only one children 
          TreeNode tempNode;
          if(current.left == null)
            tempNode = current.right;
          else
            tempNode = current.left;
         
          if(parent == null)
            root = tempNode;
         
          if(parent.left.val == val)
            parent.left = tempNode;
          else
            parent.right = tempNode;
         
        } else {
              // Node has two children, find min val in right substree to replace
              TreeNode prev = null, temp = current.right;
              while(temp.left != null) {
                prev = temp;
                temp = temp.left;
              }
         
             if(prev != null)
               prev.left = temp.right;
             else
               current.right = temp.right;
         
         current.val = temp.val;
        }  
    }  
    return true;
  }  
  
}  

class Solution {  
  public static void main(String[] args) {
    BinarySearchTree bst = new BinarySearchTree();
    bst.insert(9);
    bst.insert(5);
    bst.insert(15);
    bst.insert(1);
    bst.insert(7);
    bst.insert(11);
    bst.insert(17);
    bst.display();
    bst.delete(7);
    bst.display();
    bst.delete(15);
    bst.display();
  }
}


