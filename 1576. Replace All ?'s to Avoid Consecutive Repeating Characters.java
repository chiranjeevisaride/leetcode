class Solution {
    public String modifyString(String s) {
        if(s == null || s.length() < 1) return s;
        if(s.length() == 1 && s.equals("?")) return "a";
        char[] charArr = s.toCharArray();
        int len = charArr.length;
        for(int index = 0; index < len; index++) {
            char c = charArr[index];
            if(c == '?') {
                if(index == 0) 
                    charArr[index] = getRandomChar(charArr[index + 1], ' ');
                else if(index == len - 1) 
                    charArr[index] = getRandomChar(charArr[index - 1], ' ');
                else    
                charArr[index] = getRandomChar(charArr[index - 1], charArr[index + 1]); 
            }
        }
        return String.valueOf(charArr);
    }
    
    private char getRandomChar(char left, char right) {
        if(left != ' ' && right != ' ') {
            for(char c = 'a'; c <= 'z'; c++) {
               if(left != c && right != c)
                 return c;
            } 
        } else {
            for(char c = 'a'; c <= 'z'; c++) {
               if(left != c)
                 return c;
            } 
        }
        return ' ';    
    }
}