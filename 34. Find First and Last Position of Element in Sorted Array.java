class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length < 1 || nums[0] > target || nums[nums.length-1] < target)                 return new int[]{-1,-1};
        int[] range = {binarySearch(nums, target, true), binarySearch(nums, target, false)};
        return range;
    }
    
    public int binarySearch(int[] nums, int target, boolean isStart){
       int left = 0, right = nums.length - 1, index = -1;
        
        while(left <= right){
            int mid = left + (right - left) / 2;
            
            if(nums[mid] > target){
                right = mid - 1;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else{
                if(isStart){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
                
                index = mid;
            }
        }
        
        return index;
    }
}