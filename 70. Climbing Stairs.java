// Recursion Time O(2^n) space O(n)
class Solution {
    public int climbStairs(int n) {
        return calculateSteps(n);
    }
    
    public int calculateSteps(int n) {
        if(n == 0) return 1;
        if(n < 0) return 0;
        return calculateSteps(n -1) +  calculateSteps(n - 2);    
    }
}

// Memoization O(n) Space O(n)
class Solution {
    public int climbStairs(int n) {
        int[] count = new int[n + 1];
        return calculateSteps(n, count);
    }
    
    public int calculateSteps(int n, int[] count) {
        if(n == 0) return 1;
        if(n < 0) return 0;
        if(count[n] > 0)
            return count[n];
        count[n] = calculateSteps(n -1, count) +  calculateSteps(n - 2, count); 
        return count[n];
    }
}

// DP - Top Down Time O(n) Space O(n)
class Solution {
    public int climbStairs(int n) {
        return calculateSteps(n);
    }
    
    public int calculateSteps(int n) {
       int[] count = new int[n+1];
       count[0] = 1; count[1] = 1;
       for(int i = 2; i<= n; i++) {
           count[i] = count[i-1] + count[i-2];
       }    
        return count[n];
    }
}

