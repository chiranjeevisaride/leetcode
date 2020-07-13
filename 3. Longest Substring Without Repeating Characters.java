class Solution {
    public int lengthOfLongestSubstring(String s) {
       if(s == null || s.length() == 0) return 0;
        int start = 0, max = Integer.MIN_VALUE;
        for(int end = 1; end <= s.length() && start < end; end++) {
              String substr = s.substring(start, end);
             if(validateSubStr(substr)) {
                if((end - start) > max)  {
                     max = end-start;
                }  
             } else 
                start++; 
        } 

        return max;
    }
 
      public static boolean validateSubStr(String substr) {
        Set<Character> set = new HashSet<>();
        for(char c : substr.toCharArray()) {
          set.add(c);
        }
         return set.size() == substr.length() ? true : false;
      } 
}