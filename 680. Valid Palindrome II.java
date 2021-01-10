class Solution {
    public boolean validPalindrome(String s) {
        if(s == null || s.length() == 0) return false;
        int left = 0, right = s.length() - 1;
        boolean mismatch = false;
        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) {
                mismatch = true;
                break;
            }   
            left++; right--;
        }
        if(!mismatch) return true;
        return isPalindrome(s, left, right - 1) || isPalindrome(s, left + 1, right);
    }
    
    private boolean isPalindrome(String s, int left, int right) {
        while(left < right) {
            if(s.charAt(left) != s.charAt(right))
                return false;
            left++; right--;
        }
        return true;
    }
}