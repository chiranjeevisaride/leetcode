class Solution {
    public int minMeetingRooms(int[][] intervals) {
    
    if (intervals.length == 0) {
      return 0;
    }

    // Min heap
    PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> a - b);

    // Sort the intervals by start time
    Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

    // Add the first meeting
    minHeap.add(intervals[0][1]);

    // Iterate over remaining intervals
    for (int i = 1; i < intervals.length; i++) {
 
      int[] currentInv = intervals[i];
      // If the room due to free up the earliest is free, assign that room to this meeting.
      if ( currentInv[0] >= minHeap.peek()) {
        minHeap.poll();
      }

      // If a new room is to be assigned, then also we add to the heap,
      // If an old room is allocated, then also we have to add to the heap with updated end time.
      minHeap.add(currentInv[1]);
    }

    // The size of the heap tells us the minimum rooms required for all the meetings.
    return minHeap.size();
  }
}