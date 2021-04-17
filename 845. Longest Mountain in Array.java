class Solution {
    public int longestMountain(int[] arr) {
        if(arr == null || arr.length < 3) return 0;
        int end = 0, start = 0, maxLen = 0, len = arr.length;
        while(end < len) {
            if(end + 1 < len && arr[end + 1] > arr[end]) {
                while(end + 1 < len && arr[end + 1] > arr[end]) end++;
                
                if(end + 1 < len && arr[end] > arr[end+1]) {
                    while(end + 1 < len && arr[end] > arr[end+1]) end++;
                    maxLen = Math.max(maxLen, end - start + 1);
                }
            } else
                end++;
            start = Math.max(end, start + 1);
        }
        return maxLen;
    }
}


