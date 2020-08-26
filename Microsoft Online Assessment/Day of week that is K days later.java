class Solution {
   
    public static String dayOfWeek(String S, int K) {
      var days = List.of("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"); 
      return days.get((days.indexOf(S) + K) % 7);
    }
    
    
    public static void main(String[] args) {
      System.out.println(dayOfWeek("Sat", 23));
    }
    
  }
  