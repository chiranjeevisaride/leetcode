import java.io.*;
import java.util.*;


class Solution {
    
    static int WHITE = 1;
    static int GRAY = 2;
    static int BLACK = 3;
    
    Map<Integer, List<Integer>> graph;
    Map<Integer, Integer> color;
    Stack<Integer> stack;
    boolean isPossible;
    
    private void init(int numCourses, int[][] prerequisites) {
        graph = new HashMap<>(numCourses);
        color = new HashMap<>(numCourses);
        stack = new Stack<>();
        isPossible = true;
        
        for(int course = 0; course < numCourses; course++) {
             graph.put(course, new ArrayList<>());
             color.put(course, WHITE);
        }
           
        for(int[] prerequisite : prerequisites) {
            List<Integer> neighbors = graph.getOrDefault(prerequisite[1], new ArrayList<>());
            neighbors.add(prerequisite[0]);
            graph.put(prerequisite[1], neighbors);
        }
    }
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        this.init(numCourses, prerequisites);
           
        for(int course = 0; course < graph.size(); course++) {
            if(color.get(course) == 1)
                dfs(course);
        }
        int[] result;
        if(isPossible) {
            result = new int[stack.size()];
            int index = 0;
            while(!stack.isEmpty()) {
                result[index++] = stack.pop();
            }
        } else
           result = new int[0]; 
        
        return result;
    }
    
    
    private void dfs(int course) {
        color.put(course, GRAY);
        List<Integer> neighbors = graph.get(course);
        for(int index = 0; index < neighbors.size(); index++) {
           Integer currentCourse = neighbors.get(index);  
           if(color.get(currentCourse) == 1) {
               dfs(currentCourse);
           } else if(color.get(currentCourse) == 2)
               isPossible = false;
        }
        color.put(course, BLACK);
        stack.push(course);
    }
}