class Solution {
    public int longestMountain(int[] A) {
        int len = 0, start = 0, N = A.length;
        while(start < N) {
            int end = start;
            if(end < N &&  end + 1 < N && A[end] < A[end+1]) {
                while(end < N && end + 1 < N && A[end] < A[end+1])  end++;
               
                if(end < N && end + 1 < N && A[end] > A[end+1]) {
                    while(end < N && end + 1 < N && A[end] > A[end+1])  end++;
                    len = Math.max(len, end - start + 1);
                }
            }
              start = Math.max(end, start + 1);    
         }  
         return len;
    }
}