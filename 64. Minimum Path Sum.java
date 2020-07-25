// Recursion
//O(2^m+n)
//O(m+n)
class Solution {
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        return getMinPathSum(grid, 0, 0, grid.length, grid[0].length);
    }
    
    public int getMinPathSum(int[][] grid, int i, int j, int m, int n) {
        if(i < 0 || j < 0 || i >= m || j >= n) return Integer.MAX_VALUE;
        if(i == m - 1 && j == n - 1) return grid[i][j];
        return grid[i][j] + Math.min(getMinPathSum(grid, i + 1, j, m, n), 
                                     getMinPathSum(grid, i, j + 1, m, n));
    }
}


// PD Top Down
// Time - O(n*m)
//SPace - O(n*m)
class Solution {
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int m =  grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        Arrays.stream(dp).forEach(row -> Arrays.fill(row, Integer.MAX_VALUE));    
        dp[m-1][n-1] = grid[m-1][n-1]; 
        for(int i = m-1; i>=0; i--) {
            for(int j = n-1; j>=0; j--) {
                if(i == m-1 && j == n-1) {
                    dp[i][j] = grid[i][j];
                    continue;
                }   
                else if(i == m-1 && j!= n-1) {
                    dp[i][j] = grid[i][j] + dp[i][j+1];
                    continue;
                }
                else if(j == n-1 && i!= m-1) {
                    dp[i][j] = grid[i][j] + dp[i+1][j];
                    continue;
                }
                else    
                    dp[i][j] = grid[i][j] + Math.min(dp[i+1][j], dp[i][j+1]);
             } 
        }
        return dp[0][0];
    }   
}

// DP with Constant Space
//Space O(1)
//Time O(mn)

class Solution {
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int m =  grid.length, n = grid[0].length;
        for(int i = m-1; i>=0; i--) {
            for(int j = n-1; j>=0; j--) {
                if(i == m-1 && j == n-1) {
                    continue;
                }   
                else if(i == m-1 && j!= n-1) {
                    grid[i][j] = grid[i][j] + grid[i][j+1];
                    continue;
                }
                else if(j == n-1 && i!= m-1) {
                    grid[i][j] = grid[i][j] + grid[i+1][j];
                    continue;
                }
                else    
                    grid[i][j] = grid[i][j] + Math.min(grid[i+1][j], grid[i][j+1]);
             } 
        }
        return grid[0][0];
    }   
}