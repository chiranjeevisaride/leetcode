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