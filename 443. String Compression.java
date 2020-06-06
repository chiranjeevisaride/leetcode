class Solution {
    public int compress(char[] chars) {
        if(chars == null || chars.length < 1) return 0;
        int index = 0, start = 0, end = 0;
        while(start < chars.length) {
            end = start;
            while(end < chars.length && chars[start] == chars[end]) {
                end++;
            }
            chars[index++] = chars[start];
            if(end-start > 1) {
                String count = end - start + "";
                for(char c : count.toCharArray()) {
                    chars[index++] = c;
                }
            }
            start = end;
        }
        return index;
    }    
}