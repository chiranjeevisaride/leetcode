// Time = O(mn)
// Space = O(mn)
class Solution {
    private int[][] directions = new int[][]{{-1, 0}, {1,0}, {0, 1}, {0, -1}};  
    private int perimeter = 0;
     public int islandPerimeter(int[][] grid) {
           if(grid == null || grid.length == 0) return 0;
           int rows = grid.length, cols = grid[0].length;
           boolean[][] visited = new boolean[rows][cols];
           for(int row = 0; row < rows; row++) {
             for(int col = 0; col < cols; col++) {
               if(grid[row][col] == 1 && !visited[row][col]) {
                  dfs(grid, row, col, visited);
               }
             }
           }
           return perimeter;
       }
       
    private void dfs(int[][] input, int row, int col, boolean[][] visited) {
       Stack<int[]> stack = new Stack<>();
       stack.push(new int[]{row, col});
       visited[row][col] = true;
       while(!stack.isEmpty()) {
           int[] current = stack.pop();
           int tempPerimeter = 4;
           for(int[] direction : directions) {
               int newRow = direction[0] + current[0];
               int newCol = direction[1] + current[1];
               if(isValid(newRow, newCol, input) && tempPerimeter-- >=0  
                  && !visited[newRow][newCol]) {
                  visited[newRow][newCol] = true;
                  stack.push(new int[]{newRow, newCol});
               }   
           }
           perimeter += tempPerimeter;
           //System.out.println(current[0] + " " + current[1] + " "+ tempPerimeter);
       }
     }
     
    private boolean isValid(int row, int col, int[][] input) {
       if(row < 0 || row >= input.length || col < 0 || 
          col >= input[row].length || input[row][col] == 0)
         return false;
       return true;
     }  
       
}    


// Time = O(mn)
// Space = O(1)
class Solution {
  
   
    public int islandPerimeter(int[][] grid) {
          if(grid == null || grid.length == 0) return 0;
          int rows = grid.length, cols = grid[0].length;
          int left, right, down, up, perimeter = 0;
          for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
               if(grid[row][col] == 1) {
                   
                   if(row == 0) up = 0;
                   else
                     up = grid[row-1][col];
                   
                   if(row == rows - 1) down = 0;
                   else
                     down = grid[row+1][col];
                   
                   if(col == 0) left = 0;
                   else
                     left = grid[row][col-1];
                   
                   if(col == cols - 1) right = 0;
                   else
                     right = grid[row][col+1];
                   
                   perimeter += 4 - (left + right + up + down);
               }
            }
          }
          return perimeter;
      }    
}    
   
   
    
    