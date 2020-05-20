//Time O(n2)
//Space O(n)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> triplets = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for(int current = 0;current<nums.length-2; current++){
            if(current == 0 || (current > 0 && (nums[current] != nums[current-1]))) {
                int left = current + 1;
                int right = nums.length -1;
                while(left < right){
                    int currentSum = nums[current] + nums[left] + nums[right];
                    if(currentSum > 0) right--;
                    else if (currentSum < 0) left++;
                    else {
                        triplets.add(Arrays.asList(nums[current], nums[left], nums[right]));
                        while(left< right && nums[left] == nums[left+1]) left++; 
                        while(left<right && nums[right] == nums[right-1]) right--;
                        left++; right--;
                    }
                }
            }
        }
        return triplets;
    }
}