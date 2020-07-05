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