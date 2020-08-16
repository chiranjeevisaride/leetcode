class Solution {
    public boolean isValid(String s) {
        if( s== null || s.length() %2 != 0) return false;
        Stack<Character> stack = new Stack();
        for(char c : s.toCharArray()){
            if(c == '(' || c == '[' || c == '{')
                stack.push(c);
            else if(!stack.isEmpty() && ((c ==')' && stack.peek() == '(') || (c ==']' && stack.peek() == '[') || (c =='}' && stack.peek() == '{')))
                stack.pop();
        }
        return stack.isEmpty();
    }
}


// 2nd Approach

class Solution {
    public boolean isValid(String s) {
        if( s== null || s.length() %2 != 0) return false;
        Stack<Character> stack = new Stack();
        for(char c : s.toCharArray()){
            if(c == '(')
                stack.push(')');
            else if(c == '{')
               stack.push('}');
            else if (c == '[')
               stack.push(']');
            else if(!stack.isEmpty() && stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }