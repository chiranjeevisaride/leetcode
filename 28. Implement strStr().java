/*
   Brute Force Solution 
   Time - O(N*M)
   Space - O(1)
*/

class Solution {
    
    public int strStr(String haystack, String needle) {
       if(needle.length() == 0)
         return 0;
     
       if(needle.length() > haystack.length())
         return -1;
     
       for(int i = 0; i < haystack.length(); i++) {
         int j = 0, z = i;
         for(;j < needle.length() && z < haystack.length(); j++, z++) {
           if(haystack.charAt(z) != needle.charAt(j)) break;
         }  
         if(j == needle.length()) return i;
       }  
        return -1; 
     }   
}