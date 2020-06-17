class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
       
        List<List<Integer>> graph = new ArrayList<List<Integer>>(numCourses);
        Integer[] vertices = new Integer[numCourses];
        
        // initialize all vertices as -1 unvisited
        Arrays.fill(vertices, -1);
        /*
          -1 - unvisited  
           0 - visting inprogress
           1 - visited 
        */
        
        for(int i = 0; i < numCourses; i++)
            graph.add(i, new ArrayList<>());
        
        for(int[] prerequisite: prerequisites) {
           graph.get(prerequisite[1]).add(prerequisite[0]);
        }
        
        for(int i = 0; i < numCourses; i++) {
            if(vertices[i] != -1) 
                continue;
            if(!finishPrerequisite(vertices, graph, i))
                return false;
        }
               
        return true;
    }
    
    
    public boolean finishPrerequisite(Integer[] vertices, List<List<Integer>> graph, int i) {
        if(vertices[i] == 1) return true; // already visited backtrack
        if(vertices[i] == 0) return false; // found loop backtrack
        vertices[i] = 0;
        
        if(graph.get(i).size() == 0) {
            vertices[i] = 1;
            return true;
        }
        
        for(int childIndex = 0; childIndex < 
            graph.get(i).size(); childIndex++) {
           if(!finishPrerequisite(vertices, graph, graph.get(i).get(childIndex)))
               return false;
        }
        
        vertices[i] = 1; // mark it as visted
        return true;
    }
}