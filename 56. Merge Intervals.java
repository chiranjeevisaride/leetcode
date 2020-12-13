// time - O(nlogn)
// space - O(n)
class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length <= 1) return intervals;  
      
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]); 
        
        List<int[]> intervalList = new ArrayList<int[]>();
        int[] currentInterval = intervals[0];
        intervalList.add(currentInterval);
        
        for(int[] interval : intervals){
            int[] nextInterval = interval;
            if(currentInterval[1] >= nextInterval[0]){
                 currentInterval[1] = Math.max( currentInterval[1], nextInterval[1]);
            } else {
                currentInterval = nextInterval;
                intervalList.add(currentInterval);
            }
        }
      
        return intervalList.toArray(new int[intervalList.size()][0]);
    }
}


// 2nd 
//time - O(nlogn)
//space - O(n)
class Solution {
    public int[][] merge(int[][] intervals) {
        
        if (intervals.length == 0) return intervals;
                
        Arrays.sort(intervals, (int[] n1, int[] n2) -> n1[0]-n2[0]);
        
        int index = 0;
        
        for (int i = 1; i < intervals.length; i++) {
            
            if (intervals[index][1] >= intervals[i][0]) {
                
                if (intervals[index][1] < intervals[i][1])
                intervals[index][1] = intervals[i][1];
            } else {
                
                intervals[++index] = intervals[i];
            }
        }
        
        return Arrays.copyOf(intervals, index+1);
    }
}


class Solution {
    public int[][] merge(int[][] intervals) {
         if(intervals.length < 2) 
          return intervals;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int start = intervals[0][0];
        int end = intervals[0][1];

        List<int[]> list = new LinkedList<>();

        for(int index = 1; index < intervals.length; index++) {
          int[] interval = intervals[index];
          if(end >= interval[0]) {
            end = Integer.max(interval[1], end); 
          } else {
             list.add(new int[]{start, end});
             start = interval[0];
             end = interval[1];
          } 
        }  
        
        list.add(new int[]{start, end});

        int[][] result = new int[list.size()][2];
        int index = 0;
        for(int[] interval : list) {
          result[index++] = interval; 
        }  

        return result;
    }
}