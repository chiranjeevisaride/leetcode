class Solution {
    public int arraySign(int[] nums) {
        if(nums == null || nums.length < 0) return 0;
        int len = nums.length, left = 0, right = len - 1,  negCnt = 0;
        
       while(left < right) {
            if(nums[left] == 0 || nums[right] == 0) return 0;
            if(nums[left++] < 0) negCnt++;
            if(nums[right--] < 0) negCnt++;
        }
        
        if(left == right) {
            if(nums[left] == 0) return 0;
            if(nums[left++] < 0) negCnt++;
        }
        
        return negCnt%2 == 0 ? 1 : -1;
    }
}