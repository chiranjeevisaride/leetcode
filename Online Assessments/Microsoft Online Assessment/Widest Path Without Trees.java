import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/*

Give you one sorted array, please put them into n buckets, we need to ensure we get n sub array with approximately equal weights.

Example;

input {1, 2, 3, 4, 5} n = 3

output [[[5],[1,4],[2,3]];

Time - N(nlogn)
Space -O(1)


*/


class Solution {
  
 
  public int widestPath(int[] X, int[] Y) {
    if(X == null || X.length == 0) return 0;
    Arrays.sort(X);
    int max_dist = 0;
    for(int i = 0; i < X.length - 1; i++)
      max_dist = Math.max(max_dist, X[i+1]-X[i]);
    return max_dist;  
  }  
  
  
  public static void main(String[] args) {
     Solution s = new Solution();
     System.out.println(s.widestPath(new int[]{5,5,5,7,7,7}, new int[]{3,4,5,1,3,7}));
  }
  
}
