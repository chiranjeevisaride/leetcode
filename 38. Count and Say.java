class Solution {
    public String countAndSay(int n) {
        if(n <= 0) return "";
        String number = "1";
        while(n-- > 1) {
          number = helper(number);
        }  
        return number; 
    }
    
    
  private static String helper(String str) {
    String result = "";
    int counter = 1, index = 0;
    for(index = 0; index < str.length() - 1; index++) {
      if(str.charAt(index) == str.charAt(index + 1))
        counter++;
      else {
        result += String.valueOf(counter) + str.charAt(index);
        counter = 1;
      }     
    }  
    result += String.valueOf(counter) + str.charAt(index); 
    return result; 
  }  
}