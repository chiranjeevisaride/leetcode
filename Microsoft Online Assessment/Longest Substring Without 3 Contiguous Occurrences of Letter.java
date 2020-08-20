import java.io.*;
import java.util.*;

/*
 
 a a b b a a a a a b b
 
 
  
 */

class Solution {
  
  public static String maxContinousString(String input) {
    if(input == null || input.length() < 2) return input;
    String result = "";
    int counter = 1, start = 0;
    int len = input.length();
    for(int i = 1; i < len; i++) {
         if(input.charAt(i-1) == input.charAt(i)) { 
           counter++; 
           if(counter == 3) {
              String temp = input.substring(start, i);
              if(result.length() < temp.length()) {
                result = temp;
                start = i;
              }  
             counter = 1;
           }  
         }
        else {
         counter = 1; 
        }  
    }
    
    String temp = input.substring(start, len);
    if(result.length() < temp.length()) result = temp;
    return result;
  }  
   
  public static void main(String[] args) {
        test(maxContinousString("aabbaaaaabb"), "aabbaa");
        test(maxContinousString("aabbaabbaabbaa"), "aabbaabbaabbaa");
  }
  
  private static void test(String actual, String expected) {
        if (actual.equals(expected)) {
            System.out.println("PASSED!");
        } else {
            System.out.println(String.format("FAILED! Expected %s, but got: %s", expected, actual));
        }
  } 
}
