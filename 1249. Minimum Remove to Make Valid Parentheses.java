class Solution {
    public String minRemoveToMakeValid(String input) {
    if(input == null || input.length() == 0) return null;   
    Set<Integer> indexesToRemove = new HashSet<>();
    Stack<Integer> stack = new Stack<>();
    
    for(int i = 0; i < input.length(); i++) {  
      char currentChar = input.charAt(i);
       if(currentChar == '(')
         stack.push(i);
       else if(currentChar == ')') {
               if(stack.isEmpty())
                 indexesToRemove.add(i);
               else
                 stack.pop();
        }        
    }  
    
    while(!stack.isEmpty()) {
     indexesToRemove.add(stack.pop());
    }  
  
    StringBuffer sb = new StringBuffer();
    for(int index = 0; index < input.length(); index++) {
        if(!indexesToRemove.contains(index))
          sb.append(input.charAt(index));
    }  
    
    return sb.toString();
    }
}