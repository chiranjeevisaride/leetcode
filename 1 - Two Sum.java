class Solution {
    public int[] twoSum(int[] nums, int target) {
        if(nums != null && nums.length > 1){
          Map<Integer, Integer> hMap = new HashMap<Integer, Integer>();
            for(int i=0; i< nums.length; i++){
                int temp = target-nums[i];
                if(hMap.containsKey(temp))
                    return new int[]{i, hMap.get(temp)};
                else 
                    hMap.put(nums[i], i);
            }  
        }
        return nums;
    }
}