class Solution {
    public int maxArea(int[] height) {
      if(height == null || height.length == 0) return 0;
      int max = Integer.MIN_VALUE, left = 0, right = height.length - 1;
      while(left < right) {
         int min =  Math.min(height[left], height[right]);
         max = Math.max(max, min * (right-left));
         if(height[left] < height[right]) 
             left++;
         else
             right--;
      }  
       return max; 
    }
}