class Solution {
    
    
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> iternary = new ArrayList<>();
        if(tickets == null || tickets.size() == 0) return iternary;
        Map<String, List<String>> ticketMap = new HashMap<>();
        
        // Step1 : create Adj List
        for(List<String> ticket : tickets) {
            String source = ticket.get(0);
            String dest = ticket.get(1);
             List<String> destList;
            if(ticketMap.containsKey(source)) {
                destList = ticketMap.get(source);
            } else {
                 destList = new LinkedList<>();
            }
             destList.add(dest);
             ticketMap.put(source, destList);
        }
        
        // Step2 : sort Adj List values
        ticketMap.forEach((key, value) -> Collections.sort(value));
        Stack<String> stack = new Stack<>();
        stack.push("JFK");
        
        // Step3 : DFS
        while(!stack.isEmpty()) {
            List<String> destList = ticketMap.get(stack.peek());
            if(destList != null && destList.size() > 0) {
                String nextDest = destList.get(0);
                destList.remove(destList.get(0));
                stack.push(nextDest);
            } else {
                iternary.add(stack.pop());
            }
        }
        Collections.reverse(iternary);
        return iternary;
    }
}