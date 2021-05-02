class Solution {
    public int calculate(String s) {
        if(s == null || s.length() == 0) return 0;
        s = s.trim();
        Stack<Integer> stack = new Stack<>();
        int sum = 0, symbol = 1; // 1 for '+', -1 for '-'
        for(int index = 0; index < s.length(); index++) {
           char c = s.charAt(index); 
           if(Character.isSpace(c)) continue;
           else if(Character.isDigit(c)) {
             int num = 0;
             while(index < s.length() && Character.isDigit(s.charAt(index))) {
                num = num * 10 +  (s.charAt(index) - '0');
                index++; 
             }  
              sum = sum + (symbol) * num; 
              index--; 
           } else if(c == '+') {
               symbol = 1;
           } else if(c == '-') {
               symbol = -1;
           } else if(c == '(') {
              stack.push(sum);
              stack.push(symbol);
              sum = 0;
              symbol = 1; 
           } else if(c == ')') {
             sum = stack.pop() * sum;
             sum+= stack.pop();  
           }
        }
        return sum;
    }
}