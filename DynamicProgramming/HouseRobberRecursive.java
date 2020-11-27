import java.io.*;
import java.util.*;

/*
There are ‘n’ houses built in a line. A thief wants to steal maximum possible money from these houses. The only restriction the thief has is that he can’t steal from two consecutive houses, as that would alert the security system. How should the thief maximize his stealing?


{2, 5, 1, 3, 6, 2, 4}




 */

class Solution {
  
  private int houseRobber(int[] houses) {
    if(houses == null || houses.length == 0)
      return 0;
    return houseRobberRec(houses, 0);
  }  
  
  
  private int houseRobberRec(int[] houses, int currentIndex) {
    if(currentIndex >= houses.length) return 0;
    int stealHouse = houses[currentIndex] + houseRobberRec(houses, currentIndex + 2);
    int skipHouse = houseRobberRec(houses, currentIndex + 1);
    return Math.max(stealHouse, skipHouse);
  }  
  
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.houseRobber(new int[]{2, 5, 1, 3, 6, 2, 4}));
  }
}
