public class Solution {
    /**
     * @param rooms: m x n 2D grid
     * @return: nothing
     */
    public void wallsAndGates(int[][] rooms) {
        for(int i=0; i< rooms.length; i++) {
            for(int j=0; j < rooms[i].length; j++)
                if(rooms[i][j] == 0)
                    dfs(rooms, i, j, 0);
        }
    }
    
    public void dfs(int[][] rooms, int i, int j, int count) {
        if(i<0 || j<0 || i >= rooms.length || j >= rooms[i].length || rooms[i][j] < count) return;
        rooms[i][j] = count;
        dfs(rooms, i - 1, j, count + 1);
        dfs(rooms, i + 1, j, count + 1);
        dfs(rooms, i, j + 1, count + 1);
        dfs(rooms, i, j - 1, count + 1);
        
    }
}