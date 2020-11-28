import java.io.*;
import java.util.*;


class Solution {
  
    int[] rowCounter;
    int[] columnCounter;
    int boardSize, diagnoal = 0, antiDiagnol = 0;
    
    /** Initialize your data structure here. */
    public Solution(int n) {
        rowCounter = new int[n];
        columnCounter = new int[n];
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
      rowCounter[row] += move;
      columnCounter[row] += move;
      if(row == col) diagnoal += move;
      if(row + col == boardSize - 1) antiDiagnol += move;
      if(Math.abs(rowCounter[row]) == boardSize ||
         Math.abs(columnCounter[col]) == boardSize ||
         Math.abs(diagnoal) == boardSize ||
         Math.abs(antiDiagnol) == boardSize)
        return player;
      return 0;
    }

  public static void main(String[] args) {
    Solution s = new Solution(3);
    s.move(0, 0, 1);
    s.move(0, 2, 2);
    s.move(2, 2, 1);
    s.move(1, 1, 2);
    s.move(2, 0, 1);
    s.move(1, 0, 2);
    System.out.println(s.move(2, 1, 1));
  }
}
