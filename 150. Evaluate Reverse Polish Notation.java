class Solution {
    public int evalRPN(String[] tokens) {
       Stack<Integer> stack = new Stack<>();
       Set<String> operators = new HashSet<>(){{
         add("+"); 
         add("-"); 
         add("*"); 
         add("/"); 
       }}; 

       for(String token : tokens) {
          if(operators.contains(token)) {
              int operator2 = stack.pop();
              int operator1 = stack.pop();
              stack.push(calculate(token, operator1, operator2));
          } else
              stack.push(Integer.parseInt(token));
       }  
         System.out.println(stack);
       return stack.pop(); 
    }
    
  private int calculate(String token, int operator1, int operator2) {
   switch(token) {
     case "*": 
       return operator1 * operator2;
     case "-":
       return operator1 - operator2;
     case "/":
       return operator1/operator2;
     case "+":
       return operator1 + operator2;
   }  
    return 0;
  } 
}