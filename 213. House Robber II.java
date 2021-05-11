class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);
        int maxProfit1 = rob(nums, 0, nums.length - 1);
        int maxProfit2 = rob(nums, 1, nums.length);
        return Math.max(maxProfit1, maxProfit2);
    }
    
     public static int rob(int[] nums, int start, int len) {
        int[] temp = new int[nums.length];
        int maxProfit = Math.max(nums[start], nums[start + 1]);
        temp[start] = nums[start]; temp[start + 1] = maxProfit;
        for(int index = start + 2; index < len; index++) {
            int tempProfit = Math.max(nums[index] + temp[index-2], temp[index-1]);
            if(tempProfit > maxProfit) {
                maxProfit = tempProfit;
            }
            temp[index] = maxProfit;
        }
        return maxProfit;
  }
    
}