class Solution {
    int[] nums, original;
    int len;
    public Solution(int[] nums) {
        this.nums = nums;
        this.original = nums.clone();
        this.len = nums.length;
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
       return original;
    }
    
    
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
      if(nums == null || nums.length == 0) return nums;
      int len = nums.length;
      for(int index = 0; index < len; index++) {
        Random rand = new Random();
        int swapIndex = index + rand.nextInt(len - index);
        int temp = nums[swapIndex];
        nums[swapIndex] = nums[index];
        nums[index] = temp;
      }
      return nums;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */