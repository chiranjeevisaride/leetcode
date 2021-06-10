class Solution {
    private int[][] directions = {{-1,0}, {1,0}, {0,1}, {0,-1}};
    int[][] grid;
    boolean[][] visited;
    int n;    
    Queue<int[]> queue = new LinkedList<>();
    
    public int shortestBridge(int[][] grid) {
        this.n = grid.length;
        this.visited = new boolean[n][n];
        this.grid = grid;
        
        for(int row = 0; row < n; row++) {
            for(int col = 0; col < n; col++) {
                if(grid[row][col] == 1) {
                    dfs(row, col);
                    System.out.println(queue.size());
                    return bfs();        
                }   
            }
        }
        return 0;
    }
    
    private int bfs() {
        int minFlips = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int index = 0; index < size; index++) {
                int[] current = queue.poll();
                for(int[] direction : directions) {
                    int newRow = direction[0] + current[0];
                    int newCol = direction[1] + current[1];
                    if(inBound(newRow, newCol)) {
                        if(grid[newRow][newCol] == 1)
                            return minFlips;
                        visited[newRow][newCol] = true;
                        queue.offer(new int[]{newRow, newCol});
                    }
                }
            }
            minFlips++;
        }
        return 0;
    }
    
    private void dfs(int row, int col) {
        if(!inBound(row, col)) return;
        if(grid[row][col] == 0) return;
        visited[row][col] = true;
        queue.offer(new int[]{row, col}); 
        for(int[] direction : directions) {
            dfs(direction[0] + row, direction[1] + col);
        }
    } 
    
    private boolean inBound(int row, int col) {
         return row >= 0 && row < n && col >= 0 && col < n && !visited[row][col];
    }
}