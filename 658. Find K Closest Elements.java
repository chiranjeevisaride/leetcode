class Solution {
    
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        if(arr == null || arr.length < 1) return list;
        int index = getNearestIndex(arr, x);
        System.out.println(index);
        int left = index, right = index, len = arr.length - 1;
        while(right - left + 1 < k) {
            if(left - 1 >=0 && right + 1 <= len) {
               if(Math.abs(arr[left - 1] - x) <= Math.abs(arr[right + 1] - x))
                   left--;
                else 
                   right++;  
            } else {
                if(left - 1 >=0) left--;
                if(right + 1 <= len) right++;
            }
        }
        while(left <= right) {
            list.add(arr[left++]);
        }
        return list;
    }
    
    private int getNearestIndex(int[] arr, int x) {
        int left = 0, right = arr.length - 1;
        while(left <= right) {
            int mid = (left + right)/2;
            if(arr[mid] == x) return mid;
            else if(arr[mid] < x)
                left = mid + 1;
            else
                right = mid - 1; 
        }
        if(right < 0) return 0;
        if(left >= arr.length) return right;
        
        if(Math.abs(arr[left] - x) < Math.abs(arr[right] - x))
            return left;
        else
            return right;
    }
}