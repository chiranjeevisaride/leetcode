class Solution {
    public int lengthLongestPath(String input) {
           if(null == input || !input.contains(".")) {
               return 0;
           }
   
           Stack<Integer> stack = new Stack<>();
           String[] splits = input.split("\n");
   
           int maxLen = 0;
           for (String split : splits) {
               maxLen = Math.max(maxLen, operate(split, stack));
           }
   
           return maxLen;
       }
   
   
       private int operate(String str, Stack<Integer> stack) {
           int count = 0;
           while(count < str.length() && str.charAt(count) == '\t') {
               count ++;
           }
   
           while (stack.size() > count) {
               stack.pop();
           }
   
           int fileLen = str.length() - count;
           int lastLen = 0;
           if (!stack.isEmpty()) {
               lastLen = stack.peek();
               fileLen ++;
           }
           if (isFile(str)) {
               return lastLen + fileLen;
           } else {
                stack.push(lastLen + fileLen);
               return 0;
           }
       }
   
       private boolean isFile(String str) {
           return null != str && str.contains(".");
       }
   }