class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
     List<List<Integer>> subsets = new ArrayList<>();
     Arrays.sort(nums);   
     generateSubsets(nums, 0, new ArrayList<>(), subsets);
     return subsets;
    }
    
    public static void generateSubsets(int[] nums, int index, List<Integer> current, 
                                     List<List<Integer>> result) {
    result.add(new ArrayList<>(current));
     for(int i = index; i < nums.length; i++) {
         if(i > index && nums[i] == nums[i-1]) continue;
         current.add(nums[i]);
         generateSubsets(nums, i + 1, current, result);
         current.remove(current.size() - 1);
    }  
  }   
}    
    