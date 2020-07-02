// Time O(s2* 26)
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        int[] s1Map = new int[26];
        int[] s2Map = new int[26];
        for(int i = 0; i < s1.length(); i++) {
            s1Map[s1.charAt(i)-'a']++;
            s2Map[s2.charAt(i)-'a']++;
        }
        for(int i = 0; i < s2.length() - s1.length(); i++) {
            if(matches(s1Map, s2Map)) 
                return true;
            s2Map[s2.charAt(i)-'a']--;
            s2Map[s2.charAt(i + s1.length()) - 'a']++;
        }
        return matches(s1Map, s2Map);
    }
    
    public boolean matches(int[] s1Map, int[] s2Map) {
        for(int i = 0; i < 26; i++) {
            if(s1Map[i] != s2Map[i])
                return false;
        }
        return true;
    }
}