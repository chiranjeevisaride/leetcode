class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length ==0) return -1;
        return binarySearch(nums, 0, nums.length-1, target);
    }
    
    public int binarySearch(int[] nums, int low, int high, int target) {
        if(low > high) return -1;
        int mid = low + (high-low)/2;
        if(nums[mid] == target) return mid;
        if(nums[low] <=  nums[mid]) {
            if(target >= nums[low] && target <= nums[mid])
                return binarySearch(nums, low, mid-1, target);
            else
                return binarySearch(nums, mid+1, high, target);
        }
        else if(target >= nums[mid] && target <= nums[high]) 
            return binarySearch(nums, mid+1, high, target);
        else 
            return binarySearch(nums, low, mid-1, target);
        
    }
}


// Iterative O(logn) O(1)
class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) return mid;
            else if (nums[mid] <= nums[right]) {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else
                    right = mid - 1;
            } else {
                if (target < nums[mid] && target >= nums[left]) {
                    right = mid - 1;
                } else
                    left = mid + 1;
            }
        }
        return -1;

    }
}