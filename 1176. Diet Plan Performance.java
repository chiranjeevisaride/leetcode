// SLiding -Window 
// Time - O(n) Spacie - O(1)

class Solution {
    public static int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
     int totalPoints = 0, windowCal = 0; 
     if(calories == null || calories.length == 0 || k > calories.length) return totalPoints;
     for(int i = 0; i < k; i++) {
       windowCal += calories[i];
     } 
     
     totalPoints = calPoints(windowCal, lower, upper);
     
     for(int i = k; i < calories.length; i++) {
         windowCal += calories[i] - calories[i-k];
         totalPoints += calPoints(windowCal, lower, upper);
     } 
     return totalPoints;
   }  
   
   public static int calPoints(int windowCal, int lower, int upper) {
     if (windowCal < lower) return -1;
     else if(windowCal >= lower && windowCal <= upper) return 0;
     return 1;
   }
 }