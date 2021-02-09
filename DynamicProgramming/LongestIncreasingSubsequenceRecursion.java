class Solution {
  
    private static int lis(int[] nums) {
      return lis(nums, 0, -1);
    }  
    
    private static int lis(int[] nums, int current, int previous) {
      if(current == nums.length || previous == nums.length)
        return 0;
      
      int c1 = 0;
      if(previous == -1 || nums[current] > nums[previous])
        c1 =  1 + lis(nums, current+1, current);
     
        int c2 = lis(nums, current+1, previous);
        return Math.max(c1, c2);
      
    }  
    
    
    public static void main(String[] args) {
       System.out.println(lis(new int[]{4,2,5,6,10,1,12}));
       System.out.println(lis(new int[]{-4,10,3,7,15}));
       System.out.println(lis(new int[]{0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15}));
    }
    
  }
  