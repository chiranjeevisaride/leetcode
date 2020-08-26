public class Solution {
    public static void main(String[] args) {
        System.out.println(largestNumber(268));
        System.out.println(largestNumber(670));
        System.out.println(largestNumber(-1234));
        System.out.println(largestNumber(-999));
        System.out.println(largestNumber(-433));
        System.out.println(largestNumber(-945));
    }
    
    private static int largestNumber(int num) {
       final boolean isNegative = num < 0;
       String resultStr = null;
       String temp = isNegative ? String.valueOf(num*-1) : String.valueOf(num);
       for(int i = 0; i < temp.length(); i++) {
         int n = Integer.parseInt(String.valueOf(temp.charAt(i)));
         if(isNegative ? 5 < n : 5 > n) {
             resultStr = temp.substring(0,i) + "5" + temp.substring(i);
             break;
         } 
       }
      
       if(resultStr == null) 
          resultStr = temp + "5";
      
       return isNegative ? Integer.parseInt(String.valueOf(resultStr)) * -1 :
      Integer.parseInt(String.valueOf(resultStr));
    }
}

