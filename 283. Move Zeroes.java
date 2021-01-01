class Solution {
    public void moveZeroes(int[] nums) {
        int left = 0, cur_indx = 0;
        while(cur_indx < nums.length) {
            if(nums[cur_indx] != 0) {
                int temp = nums[left];
                nums[left] = nums[cur_indx];
                nums[cur_indx] = temp;
                left++;
            }
            cur_indx++;
        }
    }
}

class Solution {
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length <= 1) return;
         int left = 0, right = 0;
        while(left < nums.length && right < nums.length) {
             while(left < nums.length && nums[left] != 0)
                 left++;
            right = left + 1;
            while(right < nums.length && nums[right] == 0)
                right++;
            if(left < nums.length && right < nums.length) {
                nums[left] = nums[right];
                nums[right] = 0;
            }
        }
    }
}