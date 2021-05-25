class Solution {
    
    private int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    private char[][] board;
    private boolean[][] visited; 
    private String word; 
    
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length < 1 || word == null)
            return false;
        this.word = word;
        this.board = board;
        this. visited = new boolean[board.length][board[0].length];
        Stack<int[]> initials = new Stack<>();
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(board[i][j] == word.charAt(0)) {
                    Stack<int[]> stack = new Stack<>();
                    stack.push(new int[]{i, j});
                    visited[i][j] = true;
                    if(searchWord(1, visited, stack))
                        return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean searchWord(int matchIndex, 
                                       boolean[][] visited, 
                                       Stack<int[]> matched) {
        if(matchIndex >= word.length()) return true;
        int[] current = matched.peek();
            
        for(int[] direction : directions) {
            int newRow = direction[0] + current[0];
            int newCol = direction[1] + current[1];
            if(isValid(newRow, newCol, visited) && 
               board[newRow][newCol] == word.charAt(matchIndex)) {
                visited[newRow][newCol] = true;
                matched.push(new int[]{newRow, newCol});
                if(searchWord(matchIndex+1, visited, matched))
                    return true;
            }
        }
        if(!matched.isEmpty()) {
            matchIndex=-1;
            int[] unvisit = matched.pop();
            visited[unvisit[0]][unvisit[1]] = false;
        }
        return false;
    }
    
    private boolean isValid(int row, int col, boolean[][] visited) {
        if(row < 0 || row >= board.length || col < 0 || 
           col >= board[row].length || visited[row][col])
            return false;
        return true;
    }
}


// Without Stack using Recursion/backtracking 

class Solution {
    
    private char[][] board;
    private String word;
    private static int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        int rows = board.length, cols = board[0].length;
        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                if(isWordExist(row, col, 0))
                    return true;
            }
        }
        return false;
    }
    
    private boolean isWordExist(int row, int col, int index) {
        if(index >= word.length()) return true;
        
        if(row < 0 || row >= board.length || col < 0 || col >= board[row].length ||
           board[row][col] != word.charAt(index) || board[row][col] == '#')
            return false;
        
        board[row][col] = '#';
    
        for(int[] direction : directions) {
            if(isWordExist(row + direction[0], col + direction[1], index+1))
                return true;
        }
        
        board[row][col] = word.charAt(index);
        return false;
    }
}