class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new LinkedList<>();
        if(digits == null || digits.length() == 0)
            return result;
        Map<Character, char[]> directoryMap = new HashMap<>(){{
             put('1', new char[]{});
             put('2', new char[]{'a', 'b', 'c'});
             put('3', new char[]{'d', 'e', 'f'});
             put('4', new char[]{'g', 'h', 'i'});
             put('5', new char[]{'j', 'k', 'l'});
             put('6', new char[]{'m', 'n', 'o'});
             put('7', new char[]{'p', 'q', 'r', 's'});
             put('8', new char[]{'t', 'u', 'v'});
             put('9', new char[]{'w', 'x', 'y', 'z'});
        }};
       
        StringBuffer sb = new StringBuffer();
        letterCombinationsHelper(digits, directoryMap, sb, result);
        
        return result;
    }
    
    private void letterCombinationsHelper(String digits, Map<Character, char[]> directoryMap, 
                                          StringBuffer sb, List<String> result) {
        if(sb.length() == digits.length()) {
             result.add(sb.toString());
             return;
        }
          
        for(char c : directoryMap.get(digits.charAt(sb.length()))) {
            sb.append(c);
            letterCombinationsHelper(digits, directoryMap, sb, result);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}