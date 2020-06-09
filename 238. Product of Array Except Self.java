// Time O(n) Space O(n)
class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        if(nums == null || nums.length < 1) return null;
        
        int len = nums.length;
        int[] output = new int[len];
        int[] left_arrray = new int[len];
        int[] right_array = new int[len];
       
        left_arrray[0] = 1; 
        right_array[len-1] = 1;
        
        for(int i = 1; i< len; i++) {
            left_arrray[i] =  nums[i-1] * left_arrray[i-1];
        }

        for(int i = len-2; i >= 0; i--) {
            right_array[i] =  nums[i+1] * right_array[i+1];
        }
        
        for(int i = 0; i < len; i++) {
            output[i] = left_arrray[i]  * right_array[i];
        }
        
        return output;
    }
    
    
}


// Time O(n) Space O(1)
class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        if(nums == null || nums.length < 1) return null;
        
        int len = nums.length;
        int[] output = new int[len];
        
        output[0] = 1; 
        
        for(int i = 1; i< len; i++) {
            output[i] =  nums[i-1] * output[i-1];
        }

        int rightCount = 1;
        for(int i = len-1; i >= 0; i--) {
            output[i] =  output[i] * rightCount;
            rightCount *= nums[i];
        }
     
        return output;
    }
}