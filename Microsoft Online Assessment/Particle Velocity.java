import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/*

 [ 0, 1  2  3  4  5. 6. 7. 8. 9] 
 [-1, 1, 3, 3. 3, 2, 3, 2, 1, 0]
 
  o/p: 5
  
  0. 1. 2  3. 4 
 [1, 1, 1, 1, 1]   o/p: 6
 
 
 Time = O(n)
 Space (1)

DP - top down 

*/


class Solution {
  public int particleVelocity(int[] n) {
    if(n == null || n.length < 3) return -1;
    int velocity = 0;
    int sum = 0, dp = 0;
    for(int i = 2; i < n.length; i++) {
      if(n[i] - n[i-1] == n[i-1] - n[i-2]) {
        ++dp;
        sum += dp;
      }
      else {
        dp = 0;
      }  
    }  
    return sum;
  }   
  
  public static void main(String[] args) {
     Solution s = new Solution();
     System.out.println(s.particleVelocity(new int[]{-1, 1, 3, 3, 3, 2, 3, 2, 1, 0}));
  }
  
}
