class Solution {
    int ans = 1;
    public int diameterOfBinaryTree(TreeNode root) {
      depth(root);  
      return ans - 1;
    }
    
    public int depth(TreeNode root) {
      if(root == null) return 0; 
      int leftHeight =  depth(root.left);
      int rightHeight = depth(root.right);
        
      int passOnToParent = 1 + Math.max(leftHeight, rightHeight);
      int currentIsLongest = Math.max(1 + leftHeight + rightHeight, passOnToParent);
      ans = Math.max(ans, currentIsLongest); 
      return passOnToParent;  
    }
}