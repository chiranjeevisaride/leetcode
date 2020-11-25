class Solution {
    
    int[][] directions = new int[][]{{-1,0}, {1,0}, {0,1}, {0,-1}};
    Set<Integer> shape;
    boolean[][] visited;
    public int numDistinctIslands(int[][] grid) {
      if(grid == null || grid.length == 0) return 0;
       int rows = grid.length, columns = grid[0].length;
       visited = new boolean[rows][columns]; 
       Set shapes = new HashSet<HashSet<Integer>>(); 
       for(int row = 0; row < rows; row++) {
           for(int col = 0; col < columns; col++) {
               if(grid[row][col] == 1 && !visited[row][col]) {
                   this.shape = new HashSet<>();
                   dfs(grid, row, col, 0);
                   if(!shape.isEmpty()) {
                       shapes.add(shape);
                   }
               }
           }
       } 
       return shapes.size();         
    }
    
    private void dfs(int[][] grid, int row, int col, int path) {
       Stack<int[]> stack = new Stack<>();
       visited[row][col] = true;
       stack.push(new int[]{row, col});
       this.shape.add(path);
       while(!stack.isEmpty()) {
           int[] current = stack.pop();
           for(int index = 0; index < directions.length; index++) {
               int new_row = current[0] + directions[index][0];
               int new_col = current[1] + directions[index][1];
               if(check(grid, new_row, new_col) && !visited[new_row][new_col]) {
                   shape.add(index + 1);
                   stack.push(new int[]{new_row, new_col});
               }
           }
       } 
    }
    
    private boolean check(int[][] grid, int new_row, int new_col) {
        if(new_row < 0 || new_row >= grid.length || new_col < 0 || new_col >= grid[0].length || grid[new_row][new_col] != 1)
            return false;
        grid[new_row][new_col] = 0;
        return true;
    }
}