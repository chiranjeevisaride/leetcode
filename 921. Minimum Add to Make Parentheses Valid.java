class Solution {
    public int minAddToMakeValid(String S) {
        if(S == null || S.length() == 0) return S.length();
        int counter = 0;
        Stack<Character> stack = new Stack<Character>();
        for(char c : S.toCharArray()){
            if(c == '(')
                stack.push(c);
            else if(!stack.isEmpty() && (c == ')' && stack.peek() == '('))
                stack.pop();
            else 
                 counter++;
        }
        return counter += stack.size();       
    }
}