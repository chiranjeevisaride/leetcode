// Greedy 
// Time - O(n) Space - O(1)
class Solution {
    public boolean canJump(int[] nums) {
       if(nums == null || nums.length == 0) 
           return false; 
       boolean[] dp = new boolean[nums.length];
       dp[nums.length - 1] = true; 
       for(int i = nums.length - 1; i >=0; i--) {
           for(int j = 1; j <= nums[i] && i + j < nums.length; j++) {
               dp[i] = dp[i] || dp[i+j];
           }
       }
        return dp[0];
    }
}


// DP - Top Down
// Time - O(n)
// SPace - O(n)
class Solution {
    public boolean canJump(int[] nums) {
       if(nums == null || nums.length == 0) 
           return false; 
       int reachable = 0;
       for(int i = 0; i < nums.length; i++) {
           if(i > reachable) return false;
           else
               reachable = Math.max(reachable, i + nums[i]);
       } 
        return true;
    }
}