class Solution {
    public String reverseWords(String s) {
        if(s == null || s.length() == 0) return s;
        Stack<String> stack = new Stack<>();
        for(String str : s.trim().split("\\s+")) {
            if(!str.isEmpty()) {
                stack.push(str);
            }   
        }
        StringBuffer sb = new StringBuffer();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}