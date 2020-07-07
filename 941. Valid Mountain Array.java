class Solution {
    public boolean validMountainArray(int[] A) {
        if(A == null || A.length < 3) return false;
        int index = 0;
        
        // upward slope
        while(index < A.length && index + 1 < A.length && A[index] < A[index + 1]) {
            index++;
        }
        
        //At peak now - check not mountain conditions
        // i == 0 only downward slope or index + 1 >= A.length flattened curve
        if(index == 0 || index + 1 >= A.length)
            return false;
        
        // Downward slope
        while(index < A.length && index + 1 < A.length ) {
            if(A[index] <= A[index+1]) return false;
            index++;
        }
        
        return true;
    }
}