class Solution {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        String decodedStr = "";
        for(int indx = 0; indx < s.length(); indx++) {
            if(s.charAt(indx) == ']') {
                
                decodedStr = "";
                while(!stack.isEmpty() && stack.peek() != '[') 
                    decodedStr += stack.pop();
                
                stack.pop();
                int k = 0, base = 1;
                while(!stack.isEmpty() && Character.isDigit(stack.peek())) {
                     k = k + Character.getNumericValue(stack.pop()) * base;
                     base *= 10;
                }
                
                while(k-- > 0) {
                    for(int i = decodedStr.length() - 1; i >=0; i--) 
                        stack.push(decodedStr.charAt(i));  
                }
            } else {
                stack.push(s.charAt(indx));    
            }    
        } 
        decodedStr = "";
        for(int indx = 0; indx < stack.size(); indx++)
            decodedStr+= stack.get(indx);
        
        return decodedStr;
    }
}