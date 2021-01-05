package Graphs;

import java.util.*;

public class TopologicalSort {

    private int V;
    private List<List<Integer>> adj;

    TopologicalSort(int v) {
        this.V = v;
        adj = new ArrayList<List<Integer>>(v);
        for(int i=0; i < v; i++)
            adj.add(new ArrayList<>());    
    }


    public void addEdge(int v, int w) {
        adj.get(v).add(w);
    }


    public void topologicalSort(){
        Stack<Integer> sorted = new Stack<Integer>();
        boolean[] visited = new boolean[V];
        for(int i=0; i < visited.length; i++)
            visited[i] = false;
         
         for(int vertex = 0; vertex < V; vertex++) {
            if( visited[vertex] == true)
                continue;  
            sortUtil(vertex, visited, sorted);
         }

         System.out.println("Topological Sort " + sorted);
    }

    public void sortUtil(int vertex, boolean[] visited, Stack<Integer> stack) {
        visited[vertex] = true;
        Iterator<Integer> adjacentVertices = adj.get(vertex).iterator();
        while(adjacentVertices.hasNext()) {
            Integer adjVertex = adjacentVertices.next();
            if(!visited[adjVertex]) 
                sortUtil(adjVertex, visited, stack);
        }
        stack.push(vertex);
    }

    

    public static void main(String[] args) {
        TopologicalSort graph = new TopologicalSort(6);
        graph.addEdge(5, 2);  
        graph.addEdge(5, 0);  
        graph.addEdge(4, 0);  
        graph.addEdge(4, 1);  
        graph.addEdge(2, 3);  
        graph.addEdge(3, 1);  
        graph.topologicalSort();
    }
}


// 2nd way

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;



class TopologicalSort {
  
  Map<Integer, List<Integer>> graph;

  public void topologicalSort(int vertices, int[][] edges) {
      graph = new HashMap<>();
      for(int v = 0; v < vertices; v++)
        graph.putIfAbsent(v, new ArrayList<>());
    
      for(int[] edge : edges) {
        List<Integer> neighbours = graph.getOrDefault(edge[0], new ArrayList<Integer>());
        neighbours.add(edge[1]);
        graph.put(edge[0], neighbours); 
      }  
    
      boolean[] visited = new boolean[graph.size()];
      Stack<Integer> stack = new Stack<>();
      
      for(int v = 0; v < graph.size(); v++) {
         if(visited[v] == true) continue;     
          sortUtil(v, visited, stack);
      } 
       
    System.out.println("Topological Sort: ");
    while(!stack.isEmpty())
       System.out.print(stack.pop() + " ");
    System.out.println();
  }  
  
  
  public void sortUtil(int vertex, boolean[] visited, Stack<Integer> stack) {
     visited[vertex] = true;
     List<Integer> neighbours = graph.get(vertex);
     for(Integer neighbour : neighbours) {
        if(!visited[neighbour]) {
          sortUtil(neighbour, visited, stack);
        }  
     }    
     stack.push(vertex);
  }  
  
}  

class Solution {  
  
  public static void main(String[] args) {
    TopologicalSort ts = new TopologicalSort();
    ts.topologicalSort(6, new int[][]{{6,4}, {6,2}, {5,3}, {5,4}, {3,0}, {3,1}, {3,2}, {4,1}});
    ts.topologicalSort(5, new int[][]{{4,2}, {4,3}, {2,0}, {2,1}, {3,1}});
  }
}


