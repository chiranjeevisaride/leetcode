class Solution {
    public int lengthOfLongestSubstring(String s) {
       if(s == null || s.length() < 1) return 0; 
       int startPointer = 0;
       int endPointer = 0;
       int maxLength = 0;
       int len = s.length();
       HashSet<Character> set = new HashSet<>();
       while(endPointer < len) {
           char currentChar = s.charAt(endPointer);
           if(!set.contains(currentChar)) {
               set.add(currentChar);
               maxLength = Math.max(maxLength, set.size());
               endPointer++;
           } else {
               set.remove(s.charAt(startPointer));
               startPointer++;
           }   
       } 
        return maxLength;
    }
}