import java.io.*;
import java.util.*;

/*
   baaabbaabbbbbbb - 3 
   baaaa - 1
   
   Pattern - Math Division 
  
 */

class Solution {
  
  public static int minMoves(String input) {
    if(input == null || input.length() == 0) return 0;
    int minMoves = 0;
    int counter = 1;
    char prev = input.charAt(0);
    for(int i = 1; i < input.length(); i++) {
      if(prev == input.charAt(i)) 
        ++counter;
      else {
          if(counter >= 3) 
            minMoves += (counter/3);
         counter = 1;
         prev =  input.charAt(i);
      }
    }  
    if(counter >= 3)
       minMoves += counter/3;
    return minMoves;
  }  
  
  public static void main(String[] args) {
        test(minMoves("baaaaaa"), 2);
        test(minMoves("baaaab"), 1);
        test(minMoves("baaabbaabbbbbbb"), 3);
        test(minMoves("bbaabbaabbabab"), 0);
  }
  
  private static void test(int actual, int expected) {
        if (actual == expected) {
            System.out.println("PASSED!");
        } else {
            System.out.println(String.format("FAILED! Expected %d, but got: %d", expected, actual));
        }
  } 
}
