package FamousAlgos;

import java.util.Arrays;

public class LongestCommonSubSequenceMemoization {
    public static void main(String[] args) {
        String X = "abcdgh";
        String Y = "abedfhr";
        System.out.println(LCSMemo(X,Y, X.length(), Y.length()));
    }   
    
    public static int LCSMemo(String X, String Y, int n , int m) {
        int[][] LCS = new int[n+1][m+1];
        Arrays.stream(LCS).forEach(row -> Arrays.fill(row, -1));
        return LCS(LCS, X, Y, n, m);
    }

    public static int LCS(int[][] LCS, String X, String Y, int i , int j){
        if(i ==0 || j==0) return 0;
        else if (LCS[i][j] != -1) return LCS[i][j];
        else if(X.charAt(i-1) == Y.charAt(j-1)) {
            LCS[i][j]  = 1 + LCS(LCS, X, Y , i-1, j-1);
            return LCS[i][j];
        } 
        else {
            LCS[i][j] = max(LCS(LCS,X, Y , i, j-1), LCS(LCS,X, Y , i-1, j));
            return LCS[i][j];
        }
    }

    public static int max(int a, int b){
        return  a >= b ? a: b;
    }
}


