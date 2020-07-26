package Graphs;
import java.io.*;
import java.util.*;

class DijstrasShortestPath {
  
     public static void printSolution(int dist[], int V){ 
        System.out.println("Vertex \t\t Distance from Source"); 
        for (int i = 0; i < V; i++) 
          System.out.println(i + " \t\t " + dist[i]); 
      } 
    
    public static int minDistance(Boolean sptSet[], int[] dist, int V){
      int min_value = -1, min = Integer.MAX_VALUE;
      for(int vertex = 0; vertex < V; vertex++){
          if(sptSet[vertex] != true && dist[vertex] <= min) {
            min = dist[vertex];
            min_value = vertex;
          }  
      }  
      return min_value;
    }  

    public static void dijstra(int[][] graph, int source) {
        int V = graph.length;
        int[] dist = new int[V];
        Boolean[] sptSet = new  Boolean[V];
        Arrays.fill(sptSet, false);
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;   
        for(int vertex = 0; vertex < V; vertex++) {
           int u = minDistance(sptSet, dist, V);
           sptSet[u] = true;
           for(int v = 0; v < V; v++) {
              if(!sptSet[v] && dist[u]!= Integer.MAX_VALUE && graph[u][v] != 0 
                 && dist[u] + graph[u][v] < dist[v]) {
                  dist[v] = dist[u] + graph[u][v];
              }    
           }  
        }  
        printSolution(dist, V);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] graph = new int[][]{{0, 10, 20, 0},
        {10, 0, 5, 16},
        {20, 5, 0, 20},
        {0, 16, 20, 0}};
      dijstra(graph, 0);
    }
}