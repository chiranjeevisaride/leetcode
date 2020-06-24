// DFS approach 
class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int numIslands = 0;
        for(int i=0; i< grid.length; i++){
            for(int j=0; j< grid[i].length; j++){
                if(grid[i][j] == '1') {
                    numIslands += callBfs(grid, i, j);
                    
                }
            }
        }
        return numIslands;  
    }    

    public int callBfs(char[][] grid, int i, int j){
        if( i< 0 || i >= grid.length || j<0 || j>= grid[i].length || grid[i][j] == '0') return 0;
        grid[i][j] = '0';
        callBfs(grid, i+1, j);
        callBfs(grid, i-1, j); 
        callBfs(grid, i, j+1); 
        callBfs(grid, i, j-1); 
        return 1;
    }
}


// Union Find with path compression - O(n*m) Space & Time 
public class Solution {
    public int numIslands(char[][] grid) {
        if (grid.length == 0) return 0;

        final UnionFind uf = new UnionFind(grid.length*grid[0].length);
        int zeros = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '0') {
                    ++zeros;
                    continue;
                }    
                    
                if (j > 0 && grid[i][j] == '1' && grid[i][j-1] == '1')
                    uf.union(i*grid[0].length+j, i*grid[0].length+(j-1));
                    
               
                if (i > 0 && grid[i][j] == '1' && grid[i-1][j] == '1')
                    uf.union(i*grid[0].length+j, (i-1)*grid[0].length+j);
                    
            }  
        }
        return Math.abs(uf.getCount()-zeros);
    }
    
    private class UnionFind {
        private final int[] parents;
        private final int[] rank;
        private int noOfIslands;
        
        UnionFind(int n) {
            rank = new int[n]; parents = new int[n];
            noOfIslands = n;
            for (int i = 0; i < n; i++) {
                rank[i] = 1; parents[i] = i;
            }
        }
        
        void union(int p, int q) {
            final int pParent = find(p);
            final int qParent = find(q);
            
            if (pParent == qParent) return;
            
            if (rank[pParent] >= rank[qParent]) {
               rank[pParent] = (rank[qParent] == rank[pParent]) 
                   ? rank[pParent]++ : rank[pParent];
               parents[qParent] =  pParent;
            } else {
                parents[pParent] = qParent;
            }
            noOfIslands--;
        }
        
        int find(int node) {
            int parent = parents[node];
             if(node == parent) return parent; 
             parents[node] = find(parent);
            return parents[node];
        }
        
        int getCount() {
            return noOfIslands;
        }
    }
}