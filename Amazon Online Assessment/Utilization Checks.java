import java.io.*;
import java.util.*;

class Solution {
  
private static final int LIMIT = 2 * 100_000_000;
  
public int finalInstances(int instances, List<Integer> averageUtil) {
  for(int index = 0; index < averageUtil.size(); index++) {
    int utilTime = averageUtil.get(index);
    if(utilTime < 25  && instances > 1) {
      instances = (int) Math.ceil(instances/2);
      index += 10;
    }  
    else if(utilTime > 60 && instances < LIMIT) {
       instances *= 2;
       index += 10;
    }  
  }  
  return instances;
}  
  
public static void main(String[] args) {
   Solution s = new Solution();
   System.out.println(s.finalInstances(2, new ArrayList<Integer>(){{
     add(25);
     add(23);
     add(1);
     add(2);
     add(3);
     add(4);
     add(5);
     add(6);
     add(7);
     add(8);
     add(9);
     add(10);
     add(76);
     add(80);
   }}));
  }
}
