class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        for(int i: nums){
            minHeap.add(i);
            if(minHeap.size() > k)
                minHeap.poll();
        }
        return minHeap.poll();
    }
}