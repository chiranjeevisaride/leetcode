package FamousAlgos;

import java.util.Arrays;

public class LongestCommonSubstringMemoized {
   public static void main(String[] args) {
        String X = "abdgh";
        String Y = "aedghr";
        System.out.println(LCSMemp(X, Y, X.length(), Y.length()));
   }


public static int LCSMemp(String X, String Y, int n, int m) {
    int[][] result = new int[n+1][m+1];
    Arrays.stream(result).forEach(row -> Arrays.fill(row, -1));
    return LCS(result,X, Y, n, m, 0);
}


public static int LCS(int[][] result, String X, String Y, int i, int j, int count) {
    System.out.println("i"+ i + " " + "j" + j);
    if(i == 0 || i == 0) {
        result[i][j] = 0;
        return count;
    }
    else if(result[i][j] != -1) return result[i][j];
    else if(X.charAt(i-1) == X.charAt(j-1)) {
        count = LCS(result, X, Y, i - 1, j - 1, count + 1);  
        result[i][j] = count;
    }
    else {
        count = Integer.max(count, Integer.max(LCS(result, X, Y, i, j - 1, 0), LCS(result, X, Y, i - 1, j, 0)));  
        result[i][j] = count;   
    }

    return result[i][j];
} 

}   