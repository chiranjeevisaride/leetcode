class Solution {
    public int subarraySum(int[] nums, int k) {
        if(nums == null || nums.length < 1) return 0;
        int result = 0, currentSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for(int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
           currentSum += nums[windowEnd];
           if(map.containsKey(currentSum - k))
               result += map.get(currentSum - k);
           map.put(currentSum,  map.getOrDefault(currentSum, 0) + 1); 
        }
        return result;
    }
}