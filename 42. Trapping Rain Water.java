/*
 
   height - [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
   
   left_max at each level - [0, 0, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3]
   right_max at each level - [3, 3, 3, 3, 3, 3, 3, 2, 2, 2, 1, 0]
 
    rsult = Min_val(left_max[i], right_max[i]) - height[i]
    result - [0, 0, 1, 0, 1, 2, 1, 0, 0, 1, 0, 0]

    Time O(n) Space (n)

*/


class Solution {
    public int trap(int[] height) {
        if(height == null || height.length <= 1) return 0;
        int max = 0;
        int[] left_max = new int[height.length];
        int[] right_max = new int[height.length];
        left_max[0] = 0;
        for(int i = 1; i < height.length; i++) {
               int current_max =  Math.max(height[i-1], max);
               left_max[i] = current_max; 
               if(current_max > max) max = current_max;
              
        }
        max = 0;
        for(int i = height.length - 2; i >= 0; i--) {
               int current_max =  Math.max(height[i+1], max);
               right_max[i] = current_max; 
               if(current_max > max) max = current_max;
              
        }
        
        int totWaterTrapped = 0;
        for(int i = 0; i < height.length; i++) {
            int curr_cap =  Math.min(left_max[i], right_max[i]) - height[i] ;
            totWaterTrapped += curr_cap <= 0 ? 0 : curr_cap;
        }
        
        return totWaterTrapped;
    }
}