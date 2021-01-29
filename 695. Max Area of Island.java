class Solution {
    private int[][] directions = new int[][]{{-1, 0}, {1,0}, {0, 1}, {0, -1}};   
     public int maxAreaOfIsland(int[][] grid) {
           if(grid == null || grid.length == 0) return 0;
           int rows = grid.length, cols = grid[0].length, maxArea = 0;
           boolean[][] visited = new boolean[rows][cols];
           for(int row = 0; row < rows; row++) {
             for(int col = 0; col < cols; col++) {
               if(grid[row][col] == 1 && !visited[row][col]) {
                   maxArea = Math.max(maxArea, dfs(grid, row, col, visited));
               }
             }
           }
           return maxArea;
       }
       
    private int dfs(int[][] input, int row, int col, boolean[][] visited) {
       Stack<int[]> stack = new Stack<>();
       stack.push(new int[]{row, col});
       visited[row][col] = true;
       int area = 1;
       while(!stack.isEmpty()) {
           int[] current = stack.pop();
           for(int[] direction : directions) {
               int newRow = direction[0] + current[0];
               int newCol = direction[1] + current[1];
               if(isValid(newRow, newCol, input) && !visited[newRow][newCol]) {
                  visited[newRow][newCol] = true;
                  stack.push(new int[]{newRow, newCol});
                  area += 1;
               }   
           }
       }
       return area;
     }
     
    private boolean isValid(int row, int col, int[][] input) {
       if(row < 0 || row >= input.length || col < 0 || 
          col >= input[row].length || input[row][col] == 0)
         return false;
       input[row][col] = 0;
       return true;
     }  
       
   }