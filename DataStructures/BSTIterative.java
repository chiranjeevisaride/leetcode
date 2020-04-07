package DataStructures;
// BST Deletion Iterative 

class Node {
    int data;
    Node left = null, right = null;
    Node(int data){
        this.data = data;
    }
}

public class BSTIterative {
    public static void main(String[]  args){
        Node root = null;
        int[] keys = {15, 10, 20, 8, 12, 6};
        for(int key : keys){
           root = insert(root, key);
        }
        inOrder(root);
        root = delete(root, 10);
        inOrder(root);
    }

    public static void inOrder(Node root){
        if(root == null) return;
        inOrder(root.left);
        System.out.println(root.data);
        inOrder(root.right);
    }

    public static Node insert(Node root, int key){
        if(root == null)
            return new Node(key);        
        else if(root.data < key)
            root.right = insert(root.right, key);  
        else if(root.data > key)
            root.left = insert(root.left, key);
        return root;
    }

    public static Node findMin(Node curr){
        while(curr.left != null )
            curr = curr.left;
        return curr;
    }

    public static Node delete(Node root, int key){ 

        if(root == null) 
            return root;
        Node curr = root;
        Node parent = null;
        
        while(curr != null && curr.data != key){
            parent = curr;
            if(curr.data > key) {
                curr = curr.left;
            } else if(curr.data < key) {
                curr = curr.right;
            }
        }

        /* Given key not found in tree */
        if(curr == null)
            return root;
        
        /* Case1: node to be deleted has no children i.e leaf node */    
        if(curr.left == null && curr.right==null){
            if(curr != root){
                if(parent.left == curr) 
                    parent.left = null;
                else
                    parent.right = null;
            }  else {
                root = null;
            }
            return root;
        }    

      /* Case 2: node to be deleted has two children */
      if(curr.left != null || curr.right != null){
            Node successor = findMin(curr.right);
            delete(curr.right, successor.data);
            curr.data = successor.data;
      } 
      /* Case 3: node to be deleted has one child */
      else {
          Node child = curr.left != null ? curr.left : curr.right;
          if(curr != root){
                if(curr == parent.left) 
                    parent.left = child;
                else 
                    parent.right = child;
          } else 
              root = child;
      } 

        return root;
    }

}