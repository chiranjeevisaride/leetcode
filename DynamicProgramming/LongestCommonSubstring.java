package DynamicProgramming;

public class LongestCommonSubstring {
    public static void main(String[] args) {
        String X = "abdgh";
        String Y = "aedghr";
        System.out.println(lcs(X, Y, X.length(), Y.length(), 0));
    }


    public static int lcs(String X, String Y, int i, int j, int count) 
    { 
        if (i == 0 || j == 0) 
            return count;
  
        else if (X.charAt(i - 1) == Y.charAt(j - 1)) 
            count = lcs(X, Y, i - 1, j - 1, count + 1); 
        else 
            count = Math.max(count, Math.max(lcs(X, Y, i, j - 1, 0), lcs(X, Y, i - 1, j, 0))); 
        return count; 
    } 
    

}