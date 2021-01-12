import java.io.*;
import java.util.*;

/*

Time - O(n)
Space - O(n)

 */

class Solution {
    
  
   public int largestNumXOccoursXTimes(int[] nums) {
     int max = 0;
     Map<Integer, Integer> map = new HashMap<>();
     for(int num : nums) {
        if(map.containsKey(num)) {
          map.put(num, map.get(num) + 1); 
        } else
          map.put(num, 1);
     }  
     
     for(Integer i : map.keySet()) {
        if(i == map.get(i) && max < i)
          max = i;
     }  
     return max;
   }
  
   public static void main(String[] args) {
    Solution s = new Solution(); 
    System.out.println(s.largestNumXOccoursXTimes(new int[]{3,8,2,3,3,2}));
   }
} 
  
 
