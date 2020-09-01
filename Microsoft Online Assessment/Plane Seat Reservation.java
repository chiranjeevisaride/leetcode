import java.io.*;
import java.util.*;

/*

Time - n * r 
where r = size of row which is 10 constant

 */

class Solution {
    
    public int maxNumberOfFamilies(int n, String S) {
        
        if(S == null) return 2*n;
        String[] charArr = S.split(" "); 
    
        int optimal_allocations = 0;
        HashMap<Integer, Set<Integer>> map = 
            new HashMap<Integer, Set<Integer>>();
        
        for (int i = 0; i < charArr.length; i++) {
            int row = Integer.parseInt(String.valueOf(charArr[i].charAt(0)));
            int col =  Integer.parseInt(String.valueOf(charArr[i].charAt(1) - 'A')) + 1;
            if (map.containsKey(row)) {
                Set<Integer> set = map.get(row);
                set.add(col);
            }
            else {
                Set<Integer> set = new HashSet<Integer>();
                set.add(col);
                map.put(row, set);
            }
        }
      
        System.out.println(map);
        
        for(Set<Integer> set : map.values()) {
           int pos1 = 1, pos2 = 1, pos3 = 1;
           for(Integer  seatNo : set) {
               if(seatNo == 2 || seatNo == 3)
                   pos1 = 0;
               if(seatNo == 4 || seatNo == 5) {
                    pos1 = 0;
                    pos2 = 0;
               }
               if(seatNo == 6 || seatNo == 7) {
                    pos2 = 0;
                    pos3 = 0;
               }
               if(seatNo == 8 || seatNo == 9)
                   pos3 = 0;
           }
             optimal_allocations += Math.max(pos1+pos3, pos2);
        }
        
        optimal_allocations += (n - map.size()) * 2;

      return optimal_allocations;
    }
  
   public static void main(String[] args) {
    Solution s = new Solution(); 
    System.out.println( s.maxNumberOfFamilies(2, "1A 2F 1C"));
  }
} 
  
 
