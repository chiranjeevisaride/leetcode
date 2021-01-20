public class Solution extends Relation {
    public int findCelebrity(int n) {
        if(n < 0) return -1;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i++)
            stack.push(i);
        while(stack.size() > 1) {
            int first = stack.pop();
            int second = stack.pop();
            if(knows(first, second))
                stack.push(second);
             else
               stack.push(first);  
        }
        int celebrity = stack.pop();
        for(int i=0; i< n; i++) {
            if(i == celebrity) continue;
            if(knows(celebrity, i) || !knows(i, celebrity))
                return -1;
        }
       return  celebrity;
    }
}