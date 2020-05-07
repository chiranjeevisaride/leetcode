/*

Please start my github https://github.com/chiranjeevisaride/leetcode/blob/master/62. Unique Paths.java
To think DP problems in easy way,
Step1 : find recursive solution
Step2: convert recursion to DP either Bottom Up or Top Down

*/

// Recursion 
// time - O(n2), space - O(n2)
class Solution {
    public int uniquePaths(int m, int n) {
        if(m<=0 || n<=0) return 0;
        return countUniquePaths(m-1, n-1);
    }
    
    public int countUniquePaths(int i, int j){
        if(i< 0 || j <0) return 0;
        else if(i == 0 && j== 0) return 1;
        else 
            return countUniquePaths(i-1, j) + countUniquePaths(i, j-1);
    }
}
// ---------------------------------------------------------------------------
// DP - Bottom Up - Recursion with Memoization  
// Time - O(n2) Space - O(n2)
// Stack memory is reduced compared to Recursion 
class Solution {
    public int uniquePaths(int m, int n) {
        if(m<=0 || n<=0) return 0;
        int[][] grid = new int[m][n];
        Arrays.stream(grid).forEach(row -> Arrays.fill(row, -1));
        return countUniquePaths(grid, m-1, n-1);
    }
    
    public int countUniquePaths(int[][] grid, int i, int j){
        if(i< 0 || j <0) return 0;
        else if(i == 0 && j== 0) return 1;
        else if(grid[i][j] != -1) return grid[i][j];
        else {
            grid[i][j] =  countUniquePaths(grid, i-1, j) + countUniquePaths(grid, i, j-1);
            return grid[i][j];
        }
    }
}
// ---------------------------------------------------------------------------
// DP - Top Down 
// Time - O(n2) Space - O(n2)
// Stack memory is most efficient 
class Solution {
    public int uniquePaths(int m, int n) {
        if(m<=0 || n<=0) return 0;
        int[][] grid = new int[m][n];
        Arrays.stream(grid).forEach(row -> Arrays.fill(row, -1));
        return countUniquePaths(grid, m-1, n-1);
    }
    
    public int countUniquePaths(int[][] grid, int X, int Y) {
        for(int i=0; i<= X; i++) {
            for(int j=0; j<= Y; j++) {
                if(i== 0 || j== 0) grid[i][j] = 1;
                else if(grid[i][j] != -1) return grid[i][j];
                else 
                    grid[i][j] =  grid[i-1][j] + grid[i][j-1];
            }    
        }
         return grid[X][Y];
    }
}