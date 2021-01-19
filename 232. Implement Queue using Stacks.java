class MyQueue {

    /** Initialize your data structure here. */
    Stack<Integer> stack1, stack2;
    int size;
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
        size = 0;
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        size++;
        if(empty()) {
            stack2.push(x);
            return;   
        }    
    
        while(!stack2.isEmpty()) {
            stack1.add(stack2.pop());
        }
        stack1.add(x);
        while(!stack1.isEmpty()) {
            stack2.add(stack1.pop());
        }
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(empty()) return -1;
        System.out.println(stack2);
        --size;
        return stack2.pop();
    }
    
    /** Get the front element. */
    public int peek() {
         return stack2.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return size == 0 ? true : false;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */