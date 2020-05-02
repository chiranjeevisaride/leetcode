
// time O(n) space O(n)
// arrays
class Solution {
    public int firstUniqChar(String s) {
       if(s != null || s.length() > 0) {
        int[] count = new int[26]; 
        Arrays.fill(count, -1);
           
        for(char c : s.toCharArray())
            count[c-'a']++;

        for(char c: s.toCharArray())
            if(count[c-'a'] == 0) return s.indexOf(c);
           
       }
       return -1;
    }
}

// HashMap

class Solution {
    public int firstUniqChar(String s) {
       if(s != null || s.length() > 0) {
        HashMap<Character, Integer> hMap = new HashMap<Character, Integer>();
        for(char c : s.toCharArray())
           hMap.put(c, hMap.getOrDefault(c, 0) + 1);

        for(char c: s.toCharArray())
            if(hMap.get(c) == 1) return s.indexOf(c);
           
       }
       return -1;
    }
}
