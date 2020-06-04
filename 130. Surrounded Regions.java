class Solution {
    public void solve(char[][] board) {
        if(board.length == 0) return;
        for(int i = 0; i < board[0].length; i++){
            if(board[0][i] == 'O')
                markO(board, 0, i);
            if(board[board.length - 1][i] == 'O')
                markO(board, board.length - 1, i);
        }
        
        for(int i = 0; i < board.length; i++){
            if(board[i][0] == 'O')
                markO(board, i, 0);
            if(board[i][board[0].length - 1] == 'O')
                markO(board, i, board[0].length - 1);
        }
        
        for(int i = 1; i < board.length - 1; i++){
            for(int j = 1; j < board[0].length - 1; j++){
                if(board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == '-')
                    board[i][j] = 'O';
            }
        }
        
        return; 
        
    }
    
    
    
    private void markO(char[][] board, int i, int j){
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O')
            return;
        board[i][j] = '-';
        markO(board, i + 1, j);
        markO(board, i - 1, j);
        markO(board, i, j + 1);
        markO(board, i, j - 1);
        
    }
}