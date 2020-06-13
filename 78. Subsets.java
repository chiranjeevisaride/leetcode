// Approach 1 Cascading Time & SPace O(N*2^N)
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
      List<List<Integer>> output = new ArrayList();
      output.add(new ArrayList<Integer>());
  
      for(int num : nums) {
          List<List<Integer>> newSubsets = new ArrayList<>(); 
          for(List<Integer> cur : output) {
              List<Integer> current = new ArrayList<Integer>(cur);
              current.add(num);
              newSubsets.add(new ArrayList<Integer>(current));
          }
          for(List<Integer> curr : newSubsets) {
              output.add(curr);
          }
      }
        
      return output;
    }
  }


  // Approach 2: Backtracking  Time & Space O(N*2^N)
  class Solution {
    public List<List<Integer>> subsets(int[] nums) {
         List<List<Integer>> subsets = new ArrayList<>();
         generateSubsets(0, nums, new ArrayList<Integer>(), subsets);
         return subsets;
    }
    
    public void generateSubsets(int index, int[] nums, List<Integer> current, 
                                List<List<Integer>> subsets) {
        subsets.add(new ArrayList<Integer>(current));
        for(int i= index; i< nums.length; i++) {
            current.add(nums[i]);
            generateSubsets(i+1, nums, current, subsets);
            current.remove(current.size() - 1);
        }
    }
}

// Approach 3: 