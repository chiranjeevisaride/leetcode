class Solution {
  
    private static int lis(int[] nums) {
      Integer[][] dp = new Integer[nums.length][nums.length+1];
      return lisTopDown(nums, 0, -1, dp);
    }  
    
    private static int lisTopDown(int[] nums, int current, int previous, Integer[][] dp) {
      if(current == nums.length || previous == nums.length)
        return 0;
      if(dp[current][previous+1] == null) {
        int c1 = 0;
        if(previous == -1 || nums[current] > nums[previous])
         c1 = 1 + lisTopDown(nums, current+1, current, dp);
      
        int c2 = lisTopDown(nums, current+1, previous, dp);
        dp[current][previous+1] = Math.max(c1, c2);
        
      }  
      return dp[current][previous+1];
    }  
    
    
    public static void main(String[] args) {
       System.out.println(lis(new int[]{4,2,5,6,10,1,12}));
       System.out.println(lis(new int[]{-4,10,3,7,15}));
       System.out.println(lis(new int[]{0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15}));
    }
    
  }

  /*
   The above algorithm will be using O(N^2)O(N2) space for the memoization array. 
   Other than that we will use O(N)O(N) space for the recursion call-stack. 
   So the total space complexity will be O(N^2 + N)O(N2+N), which is asymptotically equivalent to O(N^2)O(N2).
  */