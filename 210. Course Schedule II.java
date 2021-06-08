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

//2nd method

class Solution {
    private Map<Integer, List<Integer>> map = new HashMap<>();
    private static int UNVISITED = 0, VISITING = 1, FINISH_VISITING = 2;
    private boolean hasCycle = false;
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {    
        for(int vertex = 0; vertex < numCourses; vertex++)
            map.putIfAbsent(vertex, new ArrayList<>());
        
        for(int[] prerequisit : prerequisites) {
            List<Integer> neighbours = map.getOrDefault(prerequisit[1], new ArrayList<>());
            neighbours.add(prerequisit[0]);
            map.put(prerequisit[1], neighbours);
        }
        
        Stack<Integer> stack = new Stack<>();
        int[] visited = new int[numCourses];
        
        for(int vertex = 0; vertex < numCourses; vertex++) {
            if(visited[vertex] == UNVISITED) {
                sortUtil(vertex, visited, stack);
            }
            if(hasCycle) return new int[]{};
        }
        int[] result = new int[stack.size()];
        int index = 0;
        while(!stack.isEmpty()) {
            result[index++] = stack.pop();
        }
        return result;
    }
    
    private void sortUtil(int current, int[] visited, Stack<Integer> stack) {
        if(visited[current] == FINISH_VISITING) return;
        if(visited[current] == VISITING)  {
            hasCycle = true;
            return;
        }
        visited[current] = VISITING;  
        for(int vertex : map.getOrDefault(current, new ArrayList<>())) {
            if(visited[vertex] == FINISH_VISITING) continue;
            sortUtil(vertex, visited, stack);
        }
        visited[current] = FINISH_VISITING;
        stack.push(current);
    }
}