// 1st Solution 
// Time & Space - O(n)
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


// 2nd Solution 
      public class Solution extends Relation {
        public int findCelebrity(int n) {
            if(n < 0) return -1;
            
            Stack<Integer> stack = new Stack<>();
            boolean isCelebrity = true;
            
            for(int col = 0; col < n; col++) {
                isCelebrity = true; 
                for(int row = 0; row < n; row++) {
                    if(col != row && !knows(row,col)) {
                        isCelebrity = false;   
                        break;
                    }
                }
                if(isCelebrity) stack.push(col);
            }
              
            while(!stack.isEmpty()) {
                isCelebrity = true;
                int row = stack.pop();
                for(int col = 0; col < n; col++) {
                   if(col != row && knows(row, col)) {
                        isCelebrity = false;
                        break;
                    } 
                }
                if(isCelebrity) return row; 
            }
        
            return -1;
        }
    }