package FamousAlgos;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String X = "abcd";
        String Y = new StringBuffer(X).reverse().toString();
        System.out.println(lcs(X, Y, X.length(), Y.length(), ""));

    }

    
    public static String lcs(String X, String Y, int i, int j, String result) { 
        if (i == 0 || j == 0) 
            return result;
        else if (X.charAt(i - 1) == Y.charAt(j - 1)) 
            result = lcs(X, Y, i - 1, j - 1, X.charAt(i - 1) + result); 
        else 
        result = longestStr(result, longestStr(lcs(X, Y, i, j - 1, ""), lcs(X, Y, i - 1, j, ""))); 
        return result; 
    } 


    public static String longestStr(String string1, String string2) {
        if(!string1.isEmpty() && !string2.isEmpty())
            return string1.length() >= string2.length() ? string1 : string2;
        else if(string1.isEmpty()) return string2;  
        else return string1;    
    }
    
}

