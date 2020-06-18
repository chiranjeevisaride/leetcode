class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
       
        Map<Integer, List<Integer>> graph = new HashMap<>(numCourses);
        Integer[] vertices = new Integer[numCourses];
         
        // initialize all vertices as -1 unvisited
        Arrays.fill(vertices, -1);
        /*
          -1 - unvisited  
           0 - visting inprogress
           1 - visited 
        */
        
        for(int[] prerequisite: prerequisites) {
            List<Integer> neighbours = graph.getOrDefault(prerequisite[1], new ArrayList<>());
            neighbours.add(prerequisite[0]);
            graph.put(prerequisite[1], neighbours);
        }
        
        for(int i = 0; i < numCourses; i++) {
            if(vertices[i] != -1) 
                continue;
            if(!finishPrerequisite(vertices, graph, i))
                return false;
        }
               
        return true;
    }
    
    
    public boolean finishPrerequisite(Integer[] vertices, Map<Integer, List<Integer>> 
                                      graph, int i) {
        if(vertices[i] == 1) return true; // already visited backtrack
        if(vertices[i] == 0) return false; // found loop backtrack
        vertices[i] = 0;
        
        List<Integer> neighbours = graph.get(i);
        if(neighbours == null) {
            vertices[i] = 1;
            return true;
        }
        
        for(int childIndex = 0; childIndex < neighbours.size(); childIndex++) {
           if(!finishPrerequisite(vertices, graph, neighbours.get(childIndex)))
               return false;
        }
        
        vertices[i] = 1; // mark it as visted
        return true;
    }
}