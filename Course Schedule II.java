class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        Map<Integer, List<Integer>> courses = new HashMap<>();
        Stack<Integer> stack = new Stack<Integer>();
        
        Integer[] vertices = new Integer[numCourses];
        Arrays.fill(vertices, -1);
        
            
        for(int[] prerequisite: prerequisites) {
            List<Integer> preReqCourses = courses.getOrDefault(prerequisite[1], 
                                                               new ArrayList<>());
            preReqCourses.add(prerequisite[0]);
            courses.put(prerequisite[1], preReqCourses);
        }
        
        
        for(int index = 0; index < numCourses; index++) {
            if(vertices[index] != -1)
                continue;
            if(!getCoursesByOrder(vertices, courses, index, stack)) {
                return new int[0];
            }
        }
        
       int[] order = new int[numCourses];
        for(int i = 0; i < numCourses; i++)
            order[i] = stack.pop();
        
        return order;
    }
    
    
    
    
    
    public boolean getCoursesByOrder(Integer[] vertices, Map<Integer, List<Integer>> courses,
                                  int index, Stack stack) {
        if(vertices[index] == 1) return true;
        if(vertices[index] == 0) return false;
        vertices[index] = 0;
        
        List<Integer> neighbours = courses.get(index);
        
        if(neighbours != null) {
           for(int neighbour = 0; neighbour < neighbours.size(); neighbour++) {
                if(!getCoursesByOrder(vertices, courses, 
                                      neighbours.get(neighbour), stack)) {
                    return false;
                }
            }
        }

         vertices[index] = 1;
         stack.push(index);
         return true;
    }
    
    
}