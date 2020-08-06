class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        if(words == null || words.length < 2 || order == null) return true;
        Map<Character, Integer> map = new HashMap<>();
        int counter = 1;
        for(char c : order.toCharArray())
            map.put(c, counter++);
        System.out.println(map);
        for(int index = 1; index < words.length; index++) {
            if(!isSorted(words[index - 1], words[index], map)) return false;
        }
        return true;
    }
    
    public boolean isSorted(String str1, String str2, Map<Character, Integer> map) {
        int minLen = Math.min(str1.length(), str2.length());
        for(int i = 0; i < minLen; i++) {
           if(map.get(str1.charAt(i)) < map.get(str2.charAt(i))) return true; 
           if(map.get(str1.charAt(i)) > map.get(str2.charAt(i))) return false;
           if(i == minLen - 1 && str1.length() > str2.length()) return false;
      
        }
        return true;
    }
}