class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        if(intervals != null || intervals.length > 1)
          Arrays.sort(intervals, (a,b) -> a[0] < b[0] ? -1 : 1);
          for(int index = 0;  index < intervals.length - 1; index++) {
            if(intervals[index][1] > intervals[index + 1][0]) return false;
          }    
       return true;   
    }
}