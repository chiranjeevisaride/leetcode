class Solution {
    private Map<Character, Integer> tMap;
    public String minWindow(String s, String t) {
        if(s == null || t == null || t.length() > s.length()) return "";
        int windowStart = 0;
        tMap = new HashMap<>();
        for(char c : t.toCharArray()) {
            if(tMap.containsKey(c))
                tMap.put(c, tMap.getOrDefault(c, 0) + 1);
            else
                tMap.put(c, 1);
        }
        String result = "";
        int resultSize = Integer.MAX_VALUE;
        Map<Character, Integer> sMap = new HashMap<>();
        for(int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
                char currentChar = s.charAt(windowEnd);
                if(sMap.containsKey(currentChar))
                    sMap.put(currentChar, sMap.getOrDefault(currentChar, 0) + 1);
                else
                    sMap.put(currentChar, 1);
                while(helper(sMap)) {
                    if((windowEnd - windowStart) + 1 < resultSize) {
                        result = s.substring(windowStart, windowEnd + 1);
                        resultSize = (windowEnd - windowStart) + 1;
                    }
                    char deleteChar = s.charAt(windowStart);
                    if(sMap.get(deleteChar) > 1) 
                        sMap.put(deleteChar , sMap.get(deleteChar) - 1);
                    else
                        sMap.remove(deleteChar);
                    windowStart += 1;   
                }
        }
        return result;
    }
    
    private boolean helper(Map<Character, Integer> sMap) {
        for(Character key : tMap.keySet()) {
            if(!sMap.containsKey(key) || sMap.get(key) < tMap.get(key))
                return false;
        }
        return true;
    }
}