
class Solution {
    public int findPairs(int[] nums, int k) {
      if(nums == null || nums.length == 0) return 0;
      Arrays.sort(nums);  
      int left = 0,  right = left + 1, len = nums.length, count = 0;
      while(left < len && right < len) {
          if(left == right || nums[right] - nums[left] < k) {
              right++;
          } else if(nums[right] - nums[left] > k) {
              left++;
          } else {
              count++;
              while(left + 1 < len && nums[left + 1] == nums[left])
                 left++; 
               left++;
          }
      }  
        return count;
    }
}