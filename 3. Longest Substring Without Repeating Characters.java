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

/*
Optimised sliding window 

The above solution requires at most 2n steps. In fact, it could be optimized to require only n steps. Instead of using a set to tell if a character exists or not, we could define a mapping of the characters to its index. Then we can skip the characters immediately when we found a repeated character.

The reason is that if s[j]s[j] have a duplicate in the range [i, j)[i,j) with index j'j 
′
 , we don't need to increase ii little by little. We can skip all the elements in the range [i, j'][i,j 
′
 ] and let ii to be j' + 1j 
′
 +1 directly.

*/

public class Solution {
   public int lengthOfLongestSubstring(String s) {
       if(s == null || s.length() == 0) return 0;
       int len = s.length(), maxLength = 0;
       Map<Character, Integer> map = new HashMap<>();
       for(int endPtr = 0, startPtr = 0; endPtr < len; endPtr++) {
           if(map.containsKey(s.charAt(endPtr))) {
               startPtr = Math.max(map.get(s.charAt(endPtr)), startPtr);
           }   
           maxLength = Math.max(maxLength, endPtr - startPtr + 1);
           map.put(s.charAt(endPtr), endPtr + 1);  
       }
       return maxLength;
   }
}