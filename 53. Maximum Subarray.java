class Solution {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
         int max_current = nums[0], global_max = nums[0];
         for(int i = 1; i < nums.length; i++) {
             max_current = Math.max(max_current + nums[i], nums[i]);
             if(max_current > global_max) global_max = max_current;
         }
         return global_max;
    }
}