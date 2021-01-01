class MovingAverage {

    int size;
    double total;
    Queue<Integer> queue = new LinkedList<>();
    
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.size = size;
    }
    
    public double next(int val) {
        queue.add(val);
        if(queue.size() > size) {
            total -= queue.poll();
        }
        total += val;
        return total/queue.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */