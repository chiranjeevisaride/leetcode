class Solution {
    public int singleNumber(int[] nums) {
        int missingNumber = 0;
        for(int num : nums) {
            missingNumber ^= num;
        }
        return missingNumber;
    }
}