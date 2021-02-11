class MedianFinder {
    
    PriorityQueue<Integer> minHeap, maxHeap;
    
    public MedianFinder() {
        minHeap = new PriorityQueue<>((a,b) -> a-b);
        maxHeap = new PriorityQueue<>((a,b) -> b-a);
    }
    
    public void addNum(int num) {
        if(maxHeap.isEmpty() || maxHeap.peek() >= num) 
            maxHeap.add(num);
        else
            minHeap.add(num);
            
        if(maxHeap.size() > minHeap.size() + 1)
                minHeap.add(maxHeap.poll());
         else if(maxHeap.size() < minHeap.size())
               maxHeap.add(minHeap.poll());   
    }
    
    public double findMedian() {
       return minHeap.size() == maxHeap.size() ? 
             (minHeap.peek() + maxHeap.peek())/2.0 :
             maxHeap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */