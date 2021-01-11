
import java.io.*;
import java.util.*;

/*
    
  (1 / 2) + (2 / 3)  = 1
  Numerator/ Demoniinator = 1 = ( 1*2 + 3*2 ) / 9
  
  (X1*Y2 + X2*Y1) / (Y1*Y2)
  
 Time - O(n) 
 Space - O(1)

*/

class Solution {
    
   public int fractionsum(int[]X,int[]Y) {
    int count=0;
    for(int i=0;i<X.length;i++) {
      for(int j=i+1;j<X.length;j++) {
          int res1=((X[i]*Y[j])+(X[j]*Y[i]));
          int res2=(Y[i]*Y[j]);
          if(res1==res2)
          count++;
       }
     }
     return count;
   }
  
    public static void main(String[] args) {
     Solution s = new Solution();
     System.out.println(s.numberOfFractions(new int[]{1,1,2},new int[]{3,2,3}));
     System.out.println(s.numberOfFractions(new int[]{1,1,1},new int[]{2,2,2}));
     System.out.println(s.numberOfFractions(new int[]{1,2,3,1,2,12,8,4},
                                            new int[]{5,10,15,2,4,15,10,5})); 
    }
}
  

  