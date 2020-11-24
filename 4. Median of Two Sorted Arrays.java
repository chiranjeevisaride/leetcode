class Solution {
    
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b-a);
    
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1 == null && nums2 == null) return 0.0;
        int[] merged = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, merged, 0, nums1.length); 
        System.arraycopy(nums2, 0, merged, nums1.length, nums2.length); 
        return findMedian(merged);
    }
    
    private double findMedian(int[] arr) {   
        for(int index = 0; index < arr.length; index++) {
            int current = arr[index];
            if(maxHeap.isEmpty() || maxHeap.peek() >= arr[index])
                maxHeap.add(arr[index]);
            else
                minHeap.add(arr[index]);
            
            if(maxHeap.size() > minHeap.size() + 1)
               minHeap.add(maxHeap.poll());
            else if(maxHeap.size() < minHeap.size())
                 maxHeap.add(minHeap.poll());       
        }
    
        System.out.println(maxHeap);
        System.out.println(minHeap);
        if(maxHeap.size() == minHeap.size())
            return ((double) maxHeap.poll() + (double) minHeap.poll()) / 2.0;
        else
            return (double) maxHeap.poll();
            
    }
    
}