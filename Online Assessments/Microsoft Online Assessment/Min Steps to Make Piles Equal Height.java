import java.io.*;
import java.util.*;

/*

4,5,5,4,2

5,5,4,4,2

2,2,2,2,2

 */

class Solution {
  
  public static int minStepsToMakePilesEqual(int[] piles) {
   if(piles == null || piles.length == 0) return 0;
   piles = Arrays.stream(piles).boxed().sorted((a,b) -> b - a).mapToInt(Integer::intValue).toArray(); 
    
   int steps = 0;
   for(int i = 1; i < piles.length; i++) {
      if(piles[i-1] > piles[i])  steps += i;  
   } 
    return steps;
  } 
   
  public static void main(String[] args) {
      System.out.println(minStepsToMakePilesEqual(new int[]{5,2,1}));
      System.out.println(minStepsToMakePilesEqual(new int[]{4,5,5,4,2}));
  }
  
}
