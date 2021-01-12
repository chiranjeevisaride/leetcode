import java.io.*;
import java.util.*;

class Solution {
  
  public int[] getTimes(int numCustomers, int[] arrTime, int[] direction) {

  int[] result = new int[numCustomers];

  Map<Integer, List<int[]>> map = new HashMap<Integer, List<int[]>>();

  Queue<int[]> entryQ = new ArrayDeque<int[]>();
  Queue<int[]> exitQ = new ArrayDeque<int[]>();

  int i = 0;

  int turnstileDirection = -1; // default unused-1

  for (int a : arrTime) {

    if (!map.containsKey(a)) {
      map.put(a, new ArrayList<int[]>());
    }

    map.get(a).add(new int[] { i, direction[i] });

    i++;
  }
    
    
 System.out.println(map);   

  i = 0; // used to determine timeStamp, 
  while (numCustomers > 0) {

    if (map.containsKey(i)) {
      List<int[]> customers = map.get(i);

      for (int[] customer : customers) {
        if (customer[1] == 1) {
          exitQ.add(customer);
        } else {
          entryQ.add(customer);
        }
      }
    }

    if (entryQ.isEmpty() && exitQ.isEmpty()) {
      turnstileDirection = -1;
      i++;
      continue;
    }

    int[] current;
    if (!entryQ.isEmpty() && !exitQ.isEmpty()) {

      switch (turnstileDirection) {
      case -1: // unused
        current = exitQ.poll();
        result[current[0]] = i;
        numCustomers--;
        turnstileDirection = 1;
        i++;
        break;

      case 1: // used for exit
        current = exitQ.poll();
        result[current[0]] = i;
        numCustomers--;
        turnstileDirection = 1;
        i++;
        break;

      case 0: // used to entry
        current = entryQ.poll();
        result[current[0]] = i;
        numCustomers--;
        turnstileDirection = 0;
        i++;
        break;

      }
      continue;
    }

    if (!entryQ.isEmpty()) {
      current = entryQ.poll();
      result[current[0]] = i;
      numCustomers--;
      turnstileDirection = 0;
      i++;
      continue;
    }

    if (!exitQ.isEmpty()) {
      current = exitQ.poll();
      result[current[0]] = i;
      numCustomers--;
      turnstileDirection = 1;
      i++;
      continue;
    }
  }

  return result;
}
  
 public static void main(String[] args) {
    Solution s = new Solution();
    int[] result = s.getTimes(4, new int[] { 0, 0, 1, 5 }, new int[] { 0, 1, 1, 0 });
    //int[] result = s.getTimes(5, new int[] { 0, 1, 1, 3, 3 }, new int[] { 0, 1, 0, 0, 1 });
    System.out.println(Arrays.toString(result));
  }
  
}
