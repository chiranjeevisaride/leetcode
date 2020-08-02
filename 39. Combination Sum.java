class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(candidates == null || candidates.length == 0) return result;
        generateCombinations(candidates, target, 0, new ArrayList<>(), result);  
        return result;
    }
    
    
   public void generateCombinations(int[] nums, int target, int index, 
                                          List<Integer> current, List<List<Integer>> result) {
    if(target == 0) {
      result.add(new ArrayList<>(current));
      return;
    } else if(target < 0)
      return;
    
    for(int i = index; i < nums.length; i++) {
      current.add(nums[i]);
      generateCombinations(nums, target - nums[i], i, current, result);
      current.remove(current.size() - 1);
    }  
  }
    
}