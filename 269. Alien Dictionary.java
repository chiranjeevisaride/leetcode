class Solution {
    
    private static final String WHITE = "-1";
    private static final String GRAY = "0";
    private static final String BLACK = "1";
    boolean isPossible;
    
    public String alienOrder(String[] words) {
        
        if(words == null || words.length == 0) return "";
        Map<Character, Set<Character>> graph = new HashMap<>();
        
        for(String word : words)
        for(Character c : word.toCharArray())
                graph.putIfAbsent(c, new HashSet<>());
        
        for(int index = 1; index < words.length; index++) {
            String word1 = words[index-1];
            String word2 = words[index];
            initGraph(word1, word2, graph);
        }
        
        Stack<Character> stack = new Stack<>();
        System.out.println("Graph:" + graph);
        
        return topologicalSort(graph, stack);
    }
    
    public String topologicalSort(Map<Character, Set<Character>> graph, Stack<Character> stack) {
        
        Map<Character, String> color = new HashMap<>();
        for(Character key : graph.keySet())
             color.put(key, WHITE);
        
        isPossible = true;
        for(Map.Entry<Character, Set<Character>> entry : graph.entrySet()) {
            if(color.get(entry.getKey()) == WHITE) 
                sortUtil(entry.getKey(), color, stack, graph);
        }
        
        System.out.println("Stack: " + stack);
        if(!isPossible || stack.size() != graph.size())
            return "";
        StringBuffer sb = new StringBuffer();
        while(!stack.isEmpty())
            sb.append(stack.pop());
        
        return sb.toString();
    }
    
    public void sortUtil(Character current, Map<Character, String> color, 
                         Stack<Character> stack, Map<Character, Set<Character>> graph) {
        color.put(current, GRAY);
        Set<Character> neibhbors = graph.get(current);
        for(Character neighbour : neibhbors) {
            if(color.get(neighbour) == WHITE)
                sortUtil(neighbour, color, stack, graph);
            else if(color.get(neighbour) == GRAY)
                isPossible = false;
        }
        color.put(current, BLACK);
        stack.push(current);
    }
    
    private void initGraph(String word1, String word2, Map<Character, Set<Character>> graph) {
        int minLen = Math.min(word1.length(), word2.length());
        for(int index = 0; index < minLen; index++) {
            char word1Char = word1.charAt(index);
            char word2Char = word2.charAt(index);
            if(word1Char != word2Char) {
               if(!graph.get(word1Char).contains(word2Char)) 
                    graph.get(word1Char).add(word2Char);
               break;
            }
        }
    }
}