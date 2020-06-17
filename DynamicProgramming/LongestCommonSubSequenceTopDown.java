package DynamicProgramming;

import java.util.Arrays;

public class LongestCommonSubSequenceTopDown {
    public static void main(String[] args) {
        LongestCommonSubSequenceTopDown lcs = new LongestCommonSubSequenceTopDown();
        String s1 = "abcdgh";
        String s2 = "abedfhr";
        char[] X = s1.toCharArray(); 
        char[] Y = s2.toCharArray(); 
        System.out.println(lcs.LCS(X,Y, X.length, Y.length));
    }   

    int LCS(char[] X, char[] Y, int n , int m){
        int[][] L = new int[n+1][m+1];
        for(int i=0; i<= n; i++){
            for(int j=0; j<=m; j++){
                if (i == 0 || j == 0) L[i][j] = 0; 
                 else if (X[i-1] == Y[j-1]) 
                    L[i][j] = L[i-1][j-1] + 1; 
                else
                    L[i][j] = max(L[i-1][j], L[i][j-1]); 
            }
        }
            return L[n][m];
    }

    int max(int a, int b){
        return  a > b ? a: b;
    }
}


