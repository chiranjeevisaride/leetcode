class Solution {
    public boolean isAnagram(String s, String t) {
        if(s == null || t == null || s.length() != t.length()) return false;
        Map<Character, Integer> hMap = new HashMap<Character,Integer>();
        for(char c : s.toCharArray()){
            if(hMap.containsKey(c))
                 hMap.put(c, hMap.get(c)+1);
             else 
                hMap.put(c, 1);
        }
        
        for(char c : t.toCharArray()){
            if(hMap.containsKey(c)){
                int value = hMap.get(c);
                if(value == 1) 
                    hMap.remove(c);
                else
                    hMap.put(c, --value);
                    
            } else 
                hMap.put(c,1);
        }
        
        return hMap.size() == 0 ? true : false;
    }
}

// 2nd method