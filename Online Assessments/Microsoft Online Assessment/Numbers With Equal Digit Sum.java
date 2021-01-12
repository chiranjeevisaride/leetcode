class Solution {
  
  public static int findMaxSum(int[] nums) {
    int max_sum = -1;
    Map<Integer ,Integer>  map = new HashMap<Integer, Integer>();
    int len = nums.length;
    for(int i = 0; i < nums.length; i++) {
         int sum = getSum(nums[i]); 
         if(map.containsKey(sum)) {
            int value = map.get(sum); 
           if(value + nums[i] > max_sum) max_sum = value + nums[i];
           map.put(sum, value > nums[i] ? value : nums[i]);
         }  
          else {
            map.put(sum, nums[i]); 
          }  
    }
    return max_sum;
  }  
  
  public static int getSum(int num) {
    int sum = 0;
    while(num > 0) {
      sum += num%10;
      num = num/10;
    }   
     return sum;
  }  
  
  public static void main(String[] args) {
     System.out.println(findMaxSum(new int[] {51, 32, 43}));
  }
}