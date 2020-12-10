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
    


// 2nd Method

class Solution {
  
  List<List<Integer>> subsets;
  public List<List<Integer>> subsets(int[] nums) {
    subsets = new ArrayList<>();
    subsets.add(new ArrayList<>());
    if(nums == null || nums.length == 0) return subsets;
    Arrays.sort(nums);
    int startIndex = 0, endIndex = 0;
    for(int i = 0; i < nums.length; i++) {
      if(i > 0 && nums[i-1] == nums[i]) {
        startIndex = endIndex + 1;
      } 
      endIndex = subsets.size() - 1;
      for(int index = startIndex; index <= endIndex; index++) {
        List<Integer> list = new ArrayList<>(subsets.get(index));
        list.add(nums[i]);
        subsets.add(list);
      }  
    }  
    return subsets;
  }
  
public static void main(String args[]) {
  Solution s = new Solution();
  System.out.println(s.subsets(new int[]{1,3, 3}));
}  
}
