// Recursion Time - O(n^2) Space - O(n)
class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        return getMaxAmount(nums, nums.length - 1);
    }
    
    
    public int getMaxAmount(int[] nums, int n) {
       if(n < 0) return 0; 
       if(n == 0) return nums[0];
       if(n == 1) return Integer.max(nums[1], nums[0]);
       return Integer.max(nums[n] + getMaxAmount(nums, n-2), getMaxAmount(nums, n-1));
    }
}


// DP - Memoization Time - O(n^2) Space - O(n)
class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int dp[] = new int[nums.length];
        Arrays.fill(dp, -1);
        return getMaxAmount(nums, nums.length - 1, dp);
    }
    
    
    public int getMaxAmount(int[] nums, int n, int[] dp) {
       if(n < 0) return 0; 
       if(n == 0) return nums[0];
       if(n == 1) return Integer.max(nums[1], nums[0]);
       if(dp[n] != -1) return dp[n]; 
       dp[n] = Integer.max(nums[n] + getMaxAmount(nums, n-2, dp), getMaxAmount(nums, n-1, dp));
       return dp[n]; 
    }
}

// DP - Top Down Time - O(n) Space - O(n)
class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        return getMaxAmount(nums);
    }
    
    
    public int getMaxAmount(int[] nums) {
       int dp[] = new int[nums.length];
       dp[0] = nums[0];
       dp[1] = Integer.max(nums[1], nums[0]); 
       for(int i = 2; i < nums.length; i++) {
           if(dp[i] > 0) return dp[i]; 
            dp[i] = Integer.max(nums[i] + dp[i-2], dp[i-1]);
       }
       return dp[nums.length-1]; 
    }
}

// Optimised DP 
// Time O(n)
// Space O(1)
class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        return getMaxAmount(nums);
    }
    
     public int getMaxAmount(int[] nums) { 
        nums[1] = Math.max(nums[1], nums[0]);
        for(int i = 2; i < nums.length; i++) {
            nums[i] = Math.max(nums[i] + nums[i-2], nums[i-1]);
           System.out.println(nums[i]); 
        }  
         return nums[nums.length-1]; 
    }
}



// Time - O(n) space - O(1)
class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        if(nums.length == 1) return nums[0];
       int previousTwo = 0, previousOne = 0, max = 0;
       for(int index = 0; index < nums.length; index++){
           max = Math.max(previousTwo + nums[index], previousOne);
           previousTwo = previousOne;
           previousOne = max;
       }
       return max; 
    }
}


class Solution {
  
    public static void main(String[] args) {
      System.out.println(rob(new int[]{2,7,9,3,1}));
    }
    
    
    public static int rob(int[] nums) {
          if(nums == null || nums.length < 1) return 0;
          if(nums.length == 1) return nums[0];
          int[] temp = new int[nums.length];
          int maxProfit = Math.max(nums[0], nums[1]);
          temp[0] = nums[0]; temp[1] = maxProfit;
          for(int index = 2; index < nums.length; index++) {
              int tempProfit = Math.max(nums[index] + temp[index-2], temp[index-1]);
              if(tempProfit > maxProfit) {
                  maxProfit = tempProfit;
              }
              temp[index] = maxProfit;
          }
          return maxProfit;
    }
  }
  