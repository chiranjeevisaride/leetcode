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

DP - Bottom Up

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

// Top - Down
// Time - O(n) Space - O(1)
public class Solution {
  int sum = 0;
  public int numberOfArithmeticSlices(int[] A) {
      slices(A, A.length - 1);
      return sum;
  }
  public int slices(int[] A, int i) {
      if (i < 2)
          return 0;
      int ap = 0;
      if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
          ap = 1 + slices(A, i - 1);
          sum += ap;
      } else
          slices(A, i - 1);
      return ap;
  }
}