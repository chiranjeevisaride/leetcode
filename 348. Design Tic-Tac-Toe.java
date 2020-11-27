class TicTacToe {

    int[] rowCount;
    int[] colCount;
    int boardSize;
    int diagnol;
    int antiDiagnol;
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        rowCount = new int[n];
        colCount = new int[n];
        boardSize = n;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int move = player == 1 ? 1 : -1;
        rowCount[row] += move;
        colCount[col] += move;
        if(row == col) diagnol += move;
        if(row+col == boardSize - 1) antiDiagnol+= move;
        if(Math.abs(rowCount[row]) == boardSize || 
           Math.abs(colCount[col]) == boardSize || 
           Math.abs(diagnol) == boardSize || 
           Math.abs(antiDiagnol) == boardSize) 
            return player;
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */