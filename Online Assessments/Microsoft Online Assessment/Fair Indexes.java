import java.io.*;
import java.util.*;

/*


[4,-1, 0, 3]    [-2, 5, 0, 3]
 6               6               

s1 = 3  
s2 = 3
k = 2,3
 
[2, -2, -3, 3]  [0, 0, 4, -4]
0               0

s1 = 0 
s2 = 0
k = 0


[1, 4, 2, -2, 5]   [7, -2, -2, 2, 5]
10                 10

s1 = 5 
s2 = 5
k = 2,4 
 
Time - O(n)
Space - O(1)

 */

class Solution {
  
  
  public int getFairIndices(int[] A, int[] B) {
    int ASum = 0, BSum = 0, indices = 0;
    int tempA = 0, tempB = 0;
    
    for(int i = 0; i < A.length; i++) {
      ASum += A[i]; 
      BSum += B[i]; 
    }

    for(int i = 0; i < A.length - 1; i++) {
      tempA += A[i]; tempB += B[i];  
      System.out.println("tempA:" + tempA + " tempB:"+tempB);
      if(tempA == tempB && (ASum == 2 * tempA && BSum == 2 * tempB))
        ++indices;
    }  
    
    return indices;
  }  
  
  public static void main(String[] args) {
    Solution s = new Solution(); 
    System.out.println( s.getFairIndices(new int[]{1, 4, 2, -2, 5}, new int[]{7, -2, -2, 2, 5}));
  }
  
}
