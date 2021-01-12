import java.io.*;
import java.util.*;

/*

ggg
aaa
eee
ff
bb
dd
aa

c = 6

time - O(nlogn)
space - O(n)

 */

class Solution {
  
   
  public static int minCharsToDelete(String input) {
   if(input == null || input.length() == 0) return 0; 
   int counter = 0; 
   Map<Character, String> map = new HashMap<>();
   for(char c: input.toCharArray()) {
     if(map.containsKey(c)) {
        map.put(c, String.valueOf(map.get(c) + c)); 
     } else
       map.put(c,String.valueOf(c));
   }  
    
   System.out.println(map); 
    
   PriorityQueue<String> maxHeap = new PriorityQueue<String>(
     (a,b) -> b.length() - a.length());
    
  for(String value : map.values())
    maxHeap.add(value);
   
  System.out.println(maxHeap); 
    
  while(!maxHeap.isEmpty()) {
   
    String topString = maxHeap.remove();
    int len = maxHeap.isEmpty() ? 0 : maxHeap.peek().length();
    if(topString.length() == len) {
      ++counter;
      if(topString.length() > 1)
        maxHeap.add(topString.substring(0, topString.length()-1));
    }  
  }  
    
   return counter; 
  }  
  
  
  public static void main(String[] args) {
    System.out.println(minCharsToDelete("aabbffddeaee"));
  }
}
