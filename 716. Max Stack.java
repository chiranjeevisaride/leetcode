// Two Stack Approach
// Time  of all methods is O(1) expect popMax() is O(n)
// Space O(n)
class MaxStack {

    /** initialize your data structure here. */
    Stack<Integer> stack;
    Stack<Integer> maxStack;
    public MaxStack() {
        stack = new Stack<>();
        maxStack = new Stack<>();
    }
    
    public void push(int x) {
        stack.push(x);
        if(maxStack.isEmpty() || x > maxStack.peek())
            maxStack.push(x);
        else
            maxStack.push(maxStack.peek());
    }
    
    public int pop() {
        maxStack.pop();
        return stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int peekMax() {
        return maxStack.peek();
    }
    
    public int popMax() {
        System.out.println(maxStack);
        int max = peekMax();
        Stack<Integer> buffer = new Stack<>();
        while(max != top()) 
            buffer.push(pop());
        pop();
        while(!buffer.isEmpty())
            push(buffer.pop());
        return max;    
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */