class Solution {
    public boolean validMountainArray(int[] A) {
        if(A == null || A.length < 3) return false;
        int i = 0;
        while(i + 1 < A.length - 1 && A[i] < A[i+1]) {
            i++;
        }
        
        if(i == 0 || i+1 >= A.length) return false;
        
        while(i + 1 < A.length && A[i] > A[i+1]) {
            i++;
        }
        
        if(A[i-1] <= A[i] || i != A.length -1) return false;
        
        return true;
    }
}