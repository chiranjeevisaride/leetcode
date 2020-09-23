/*
 * Time - O(V+E) 
 *  Space - O(V)
 */

import java.io.*;
import java.util.*;

class Solution {
  
  Map<Integer, List<Integer>> graph;
  
  Solution() {
     graph = new HashMap<Integer, List<Integer>>();
  }  
  
  public void addVertex(int vertex) {
    List<Integer> list = new ArrayList<Integer>();
    graph.put(vertex, list);
  }  
  
  
  public void addEdge(int source, int dest, boolean bidirectional) {
      graph.get(source).add(dest);
      if(bidirectional) {
         graph.get(dest).add(source);
      }  
  }  
  
  public boolean detectCycle(Map<Integer, List<Integer>> graph) {
    if(graph == null || graph.size() == 0) return false;
     int size_of_graph = graph.size();
     Set<Integer> whiteSet = new HashSet<>();
     Set<Integer> graySet = new HashSet<>();
     Set<Integer> blackSet = new HashSet<>();
     for(int vertex = 0; vertex < size_of_graph; vertex++) {
        if(cycle(graph, vertex, whiteSet, graySet, blackSet))
          return true;
     }  
     return false;
  }
  
  private boolean cycle(Map<Integer, List<Integer>> graph, int vertex, Set<Integer> whiteSet,
                       Set<Integer> graySet, Set<Integer> blackSet) {
        moveVertex(vertex, whiteSet, graySet);
        if(graph.get(vertex) != null) {
            for(int neighbour : graph.get(vertex)) {
                if(graySet.contains(neighbour)) return true;
                if(blackSet.contains(neighbour)) continue;
                if(cycle(graph, neighbour, whiteSet, graySet, blackSet))
                  return true;
            }  
           moveVertex(vertex, graySet, blackSet); 
        }  
        return false;
  }  
  
  private void moveVertex(int vertex, Set<Integer> sourceSet, Set<Integer> destSet) {
     sourceSet.remove(vertex);
     destSet.add(vertex);
  }  
  

  public static void main(String[] args) {
    Solution s = new Solution();
    s.addVertex(0);
    s.addVertex(1);
    s.addVertex(2);
    s.addVertex(3);
    s.addEdge(0, 1, false); 
    s.addEdge(0, 2, false); 
    s.addEdge(1, 2, false); 
    s.addEdge(2, 0, false); 
    s.addEdge(2, 3, false); 
    s.addEdge(3, 3, false);  
    System.out.println(s.detectCycle(s.graph));
  }
  
}
