class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> anagramIndexses = new ArrayList<Integer>();
        if(s == null || p == null || s.length() < p.length()) return anagramIndexses;
        Map<Character, Integer> pCount = new HashMap<Character, Integer>();
        for(char sChar : s.toCharArray()) 
            pCount.put(sChar,pCount.getOrDefault(sChar,0) + 1);
        int pLength = p.length();
        for(int index = 0; index <= s.length() - pLength; index++) {
            int end = pLength + index;
            String subStr  = s.substring(index, end);
            if(isAnagram(subStr, p))
                anagramIndexses.add(index);
        }
        return anagramIndexses;
    }
    
    public boolean isAnagram(String subStr, String p){
        if(subStr == null || p == null || subStr.length() != p.length()) return false;
        int[] arr = new int[26];
        for(char c : subStr.toCharArray())
            arr[c-'a']++;
        
        for(char c : p.toCharArray()){
           if(arr[c-'a'] == 0)
                return false;
            arr[c-'a']--; 
        }
        
        for(int index : arr)
            if(arr[index] != 0) return false;
            
        return true;
    }
}