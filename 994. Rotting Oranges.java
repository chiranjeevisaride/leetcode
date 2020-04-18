class Solution {
    public int orangesRotting(int[][] grid) {
        
        if(grid == null || grid.length == 0 || grid[0].length ==0)
            return 0;
        
        int rows = grid.length;
        int columns = grid[0].length;
        
        Queue<int[]> rotten = new LinkedList<>();
        int fresh = 0;
        
        for(int i=0; i< rows ; i++){
            for(int j=0; j< columns; j++){
                if(grid[i][j] == 2) rotten.add(new int[]{i,j});
                if(grid[i][j] == 1) fresh ++;
            } 
        }
        
      
       int days = 0;   
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};  
        while (!rotten.isEmpty() && fresh > 0) {   
            int queueSize = rotten.size();
            for (int i = 0; i < queueSize; i++) {
                int[] node = rotten.poll();
                for (int[] dir : directions) {
                    int x = node[0] + dir[0];
                    int y = node[1] + dir[1];
                    if (x < 0 || y < 0 || x >= rows || y >= columns || grid[x][y] == 0 || grid[x][y] == 2) {   
                        continue;
                    }
                    grid[x][y] = 2;    
                    rotten.offer(new int[]{x, y});  
                    fresh--;
                }
            }
            days++;   // increment the level 
        }
        return fresh == 0 ? days : -1;
    }
}