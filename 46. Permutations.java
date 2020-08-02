class Solution {
    public List<List<Integer>> permute(int[] nums) {
         List<List<Integer>> subsets = new ArrayList<>();
         if(nums == null || nums.length == 0) return subsets;
         Queue<Integer> input = new LinkedList<>();
         for(int  i : nums) input.add(i);
         generatePermutions(input, 0, new ArrayList<>(), subsets);
         return subsets;
    }
    
    
    public static void generatePermutions(Queue<Integer> input, int index, List<Integer> current, 
                                     List<List<Integer>> result) {
       if(input.isEmpty()) { 
          result.add(new ArrayList<>(current));       
          return; 
       }
    
      for(int i = 0; i < input.size(); i++) {
          current.add(input.poll());
          generatePermutions(input, index + 1, current, result);
          input.add(current.get(current.size()-1));
          current.remove(current.size()-1);
      }  
  }  
}