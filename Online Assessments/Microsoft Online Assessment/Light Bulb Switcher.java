
import java.io.*;
import java.util.*;

/*
Time - O(n)
Space - O(1)
*/

class Solution {
    
    public int lightBulbSwitcher3(int[] bulbs) {
      int moments = 0, maxLightBulb = 0, lightBulbs= 0;
      for(int bulb : bulbs) {
        maxLightBulb = Math.max(maxLightBulb, bulb);
        lightBulbs++;
        if(lightBulbs == maxLightBulb) moments +=1;
      }  
      return moments;
    }  


    public static void main(String[] args) {
     Solution s = new Solution();
     System.out.println(s.lightBulbSwitcher3(new int[]{2,1,3,5,4}));
    }
}
  

                                 
