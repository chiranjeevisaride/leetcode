class Solution {
    public int longestPalindrome(String s) {
        int result = 0;
        int[] charCounts = new int[128];
        for(char c : s.toCharArray()) 
            charCounts[c]++;
        
        for(int charCount : charCounts) {
            result += charCount/2 * 2;
            if(result%2 == 0 && charCount%2 == 1)
                result +=1;
        }
            
        return  result;       
    }
}