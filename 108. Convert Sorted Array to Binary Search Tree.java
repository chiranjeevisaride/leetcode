class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
       if(nums == null || nums.length == 0) return null;
       int left = 0, right = nums.length - 1;
       return recursiveBinarySearch(nums, left, right);
    }
    
    public TreeNode recursiveBinarySearch(int[] nums, int left, int right) {
       if(left > right) return null;
       int mid = left + (right - left) / 2;
       TreeNode node = new TreeNode(nums[mid]); 
       node.left = recursiveBinarySearch(nums, left, mid - 1);
       node.right = recursiveBinarySearch(nums, mid + 1, right);  
       return node; 
    }
}