// Approach 1 Cascading Time & SPace O(N*2^N)
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());
        for(int num : nums) {
          int n = subsets.size();
          for(int index = 0; index < n; index++) {
             List<Integer> current = new ArrayList<>(subsets.get(index));
             current.add(num);
             subsets.add(current);
          }  
        }  
        return subsets;
    }
  }


  // Approach 2 a: Backtracking  Time & Space O(N*2^N)
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


// Approach 2b: Backtracking (variation) Time & Space O(N*2^N)

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        generateSubsets(0, nums, new ArrayList<Integer>(), output);
        return output;
    }
    
    public void generateSubsets(int index, int[] nums, List<Integer> current, List<List<Integer>> output) {
         if(index == nums.length) {
             output.add(new ArrayList<Integer>(current));
         }
         else {
            current.add(nums[index]);
            generateSubsets(index + 1, nums, current, output);
            current.remove(current.size() - 1);
            generateSubsets(index + 1, nums, current, output);
         }
    }
}