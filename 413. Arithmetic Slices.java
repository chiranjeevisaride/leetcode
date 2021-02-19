// Recursion 
// Time - O(n) 
// Space - O(n)
class Solution {
    int sum = 0;
    public int numberOfArithmeticSlices(int[] A) {
        arthimeticSlicesRec(A, A.length - 1);
        return sum;
    }
    
    private int arthimeticSlicesRec(int[] A, int start) {
        if(start < 2) return 0;
        int ap = 0;
        if((A[start] - A[start-1]) == (A[start-1] - A[start-2])) {
           ap = 1 + arthimeticSlicesRec(A, start - 1);  
           sum += ap;
        } else 
          arthimeticSlicesRec(A, start - 1);
      return ap;
    }
}