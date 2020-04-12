class Solution {
    public boolean isPalindrome(String s) {
        if(s != null && s.length() > 1){
            int left = 0, right = s.length()-1;
            while(left < right) {
                if(Character.isWhitespace(s.charAt(left)) || !Character.isLetterOrDigit(s.charAt(left))){ left++; continue;}
                if(Character.isWhitespace(s.charAt(right)) || !Character.isLetterOrDigit(s.charAt(right))) { right--; continue;}
                if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) return false;
                left++; right--;
            }
        }
        return true;
    }
}