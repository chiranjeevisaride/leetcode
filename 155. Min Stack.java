// Approach 1 : Min Values or Stack of Values 
// Time O(1) all operations & Space O(n)
// Using List
class MinStack {

    /** initialize your data structure here. */
    List<int[]> stack = null;
    public MinStack() {
        stack = new ArrayList<>();
    }
    
    public void push(int x) {
        
        if(stack.isEmpty()) {
            stack.add(new int[]{x,x});
            return;
        }
        
        int current_min = stack.get(stack.size()-1)[1];
        stack.add(new int[]{x, Integer.min(current_min, x)});
    }
    
    public void pop() {
        if(stack.size() > 0) {
            stack.remove(stack.size()-1);
        }
    }
    
    public int top() {
        return stack.get(stack.size()-1)[0];
    }
    
    public int getMin() {
        retaurn stack.get(stack.size()-1)[1];
    }
}

// Using Stacks 
class MinStack {

    /** initialize your data structure here. */
    Stack<int[]> stack = null;
    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int x) {
        if(stack.isEmpty()) {
            stack.push(new int[]{x,x});
            return;
        }
        int current_min = stack.peek()[1];
        stack.push(new int[]{x, Integer.min(x, current_min)});
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek()[0];
    }
    
    public int getMin() {
        return stack.peek()[1];
    }
}


// Approach 1 : Two Stacks 
// Time O(1) all operations & Space O(n)
class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> stack = null;
    Stack<Integer> minStack = null;
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int x) {
        stack.push(x);
        if(minStack.isEmpty() || x <= minStack.peek()) 
            minStack.push(x);
    }
    
    public void pop() {
        if(!stack.isEmpty() && !minStack.isEmpty()) {
            if(minStack.peek().equals(stack.peek()))
                minStack.pop();
            stack.pop();
        }
    }
    
    public int top() {
         if(!stack.isEmpty())
            return stack.peek();
        return -1;
    }
    
    public int getMin() {
        if(!minStack.isEmpty())
            return minStack.peek();
        return -1;
    }
}