class Solution {
    
    int sum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
      if(root == null) return sum; 
      getMaxPathSumBT(root);
      return sum;
    }
    
     public int getMaxPathSumBT(TreeNode node) {
       if(node == null) return 0;
       int rightSum = getMaxPathSumBT(node.right);
       int leftSum = getMaxPathSumBT(node.left);
       int currentPathSum = Math.max(node.val, node.val + Math.max(leftSum, rightSum));
       int currentMax = Math.max(currentPathSum, node.val + leftSum + rightSum); 
       sum = Math.max(sum, currentMax);
       return currentPathSum;
     }
}