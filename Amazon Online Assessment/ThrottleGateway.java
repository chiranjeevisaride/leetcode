import java.io.*;
import java.util.*;


/*

   1 - 4   4   1
   2 - 3   7   0
   3 - 3   10  0
   4 - 3   13  0
   5 - 3   16  0 
   6 - 3   19  0 
   7 - 4   23  3
   11- 4   27  3


*/

class Solution {
  
  public static final int MAX_PER_SECOND = 3;
  public static final int MAX_TEN_SECONDS = 20;
  public static final int MAX_PER_MINUTE = 60;
  

 public int droppedRequests(int[] requestTime) {
        if (requestTime == null || requestTime.length == 0) {
            return 0;
        }
        int drop = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int lastReqTime = 0;
        for (int i : requestTime) {
            map.put(i, map.getOrDefault(i, 0) + 1);
            lastReqTime = Math.max(lastReqTime, i);
        }
        int[] nums = new int[lastReqTime + 1];
        for (int i = 1; i < nums.length; ++i) {
            int numReqThisSecond = map.getOrDefault(i, 0);
            nums[i] = nums[i - 1] + numReqThisSecond;
            if (numReqThisSecond == 0) {
                continue;
            }
            int toDrop = 0;
            if (numReqThisSecond > MAX_PER_SECOND) {
                toDrop = Math.max(toDrop, numReqThisSecond - MAX_PER_SECOND);
            }

            int timeTenSecondsAgo = Math.max(i - 10, 0);
            int numReqPastTenSecond = nums[i] - nums[timeTenSecondsAgo];
            if (numReqPastTenSecond > MAX_TEN_SECONDS) {
                int numReqExceeded = Math.min(numReqThisSecond, numReqPastTenSecond - MAX_TEN_SECONDS);
                toDrop = Math.max(toDrop, numReqExceeded);
            }

            int timeOneMinuteAgo = Math.max(i - 60, 0);
            int numReqPastMinute = nums[i] - nums[timeOneMinuteAgo];
            if (numReqPastMinute > MAX_PER_MINUTE) {
                int numReqExceeded = Math.min(numReqThisSecond, numReqPastMinute - MAX_PER_MINUTE);
                toDrop = Math.max(toDrop, numReqExceeded);
            }
            drop += toDrop;
        }
        return drop;
    } 
  
  
  
  
  
 public static void main(String[] args) {
   Solution s = new Solution();
   int[] requestTime2 = new int[]
   {1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 7, 11, 11, 11, 11};
    System.out.println(s.droppedRequests(requestTime2));
  }
}
