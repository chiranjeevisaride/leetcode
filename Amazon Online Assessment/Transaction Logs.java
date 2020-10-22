import java.io.*;
import java.util.*;


class Solution {
  
  public static List<String> getFraudIds(String[] input, int threshold) {
    
    Map<String, Integer> map = new HashMap<>();
    List<String> result = new ArrayList<>();
    
    for(String currentStr : input) {
      String[] parsed = currentStr.split("\\s+"); 
      String str1 = parsed[0];
      String str2 = parsed[1];
      if(!str1.equals(str2)) {
          map.put(str1, map.getOrDefault(str1,0) + 1);
      } 
        map.put(str2, map.getOrDefault(str2,0) + 1);  
    }  
    
    Set<String> keys = map.keySet();
    for(String str : keys) {
      if(map.get(str) >= threshold) result.add(str);
    }  
    return result;
  }  
  
  public static void main(String[] args) {
    String[] input = new String[] { "345366 89921 45", "029323 38239 23", "38239 345366 15", "029323 38239 77",
        "345366 38239 23", "029323 345366 13", "38239 38239 23" };
    System.out.println(getFraudIds(input, 3));
  }
}
