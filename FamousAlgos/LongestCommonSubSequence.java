package FamousAlgos;

public class LongestCommonSubSequence {
    public static void main(String[] args) {
        String X = "abcdgh";
        String Y = "abedfhr";
        System.out.println(LCS(X,Y, X.length(), Y.length()));
    }   
    
    
    public static int LCS(String X, String Y, int n , int m){
        if(n ==0 || m==0) return 0;
        else if(X.charAt(n-1) == Y.charAt(m-1)) return 1 + LCS(X, Y , n-1, m-1);
        else 
         return max(LCS(X, Y , n, m-1), LCS(X, Y , n-1, m));
    }

    public static int max(int  a, int b){
        return  a >= b ? a : b;
    }
}


