package DataStructures;

import java.util.*;

public class Graph {

    private Map<Integer, List<Integer>> adjVertices;

    public Graph(){
       this.adjVertices = new HashMap<Integer, List<Integer>>();
    }

    public void addVertex(int vertex){
        adjVertices.putIfAbsent(vertex, new ArrayList<Integer>());
    }

    public void addEdge(int src, int dest, boolean bidirection){
        adjVertices.get(src).add(dest);
        if(bidirection){
            adjVertices.get(dest).add(src);
        }
    }

    public String toString(){
        StringBuilder builder = new StringBuilder();
        for(Integer vertex : adjVertices.keySet()){
            builder.append(vertex + ": ");
            for(Integer edge: adjVertices.get(vertex)){
                builder.append(edge + " ");
            }
            builder.append("\n"); 
        }
        return builder.toString();
    }

    public int getVertexCount(){
        System.out.println("The graph has " + adjVertices.size() + " vertices");
        return adjVertices.size();
    }

    public void dfsWithoutRecursion(int start) {
       Stack<Integer> stack = new Stack<Integer>();
       Set<Integer> seen = new HashSet<Integer>(adjVertices.size());
       stack.push(start);
       while(!stack.isEmpty()){
           int current = stack.pop();
           if(!seen.contains(current)){
               seen.add(current);
               visit(current);
           }
           for(int dest: adjVertices.get(current)){
                if(!seen.contains(dest))
                    stack.push(dest);
           }
       }
    }

    public void bfsWithoutRecursion(int start) {
        Queue<Integer> queue = new LinkedList<Integer>();
        Set<Integer> seen = new HashSet<Integer>(adjVertices.size());
        queue.add(start);
        while(!queue.isEmpty()){
            int current = queue.poll();
            if(!seen.contains(current)){
                seen.add(current);
                visit(current);
            }
            for(int dest: adjVertices.get(current)){
                 if(!seen.contains(dest))
                 queue.add(dest);
            }
        }
     }
 



    private void dfsRecursive(int current, Set<Integer> isVisited) {
        isVisited.add(current);
        visit(current);
        for (int dest : adjVertices.get(current)) {
            if (!isVisited.contains(dest))
                dfsRecursive(dest, isVisited);
        }
    }

  
  	private void visit(int value) {
        System.out.print(value + "\n" );        
    }

    public static void main(String[] args) {
        Graph g = new Graph();
        g.addVertex(0);
        g.addVertex(1);
        g.addVertex(2);
        g.addVertex(3);
        g.addVertex(4);
        g.addEdge(0, 1, false); 
        g.addEdge(0, 4, false); 
        g.addEdge(1, 2, false); 
        g.addEdge(1, 3, false); 
        g.addEdge(1, 4, false); 
        g.addEdge(2, 3, false); 
        g.addEdge(3, 4, true); 

         // gives the no of vertices in the graph. 
         //g.getVertexCount(); 

         // print the graph. 
        System.out.println("Graph:\n" + g.toString()); 
        System.out.println("DFS Iterative:");
        g.dfsWithoutRecursion(0);
        System.out.println("DFS Recursive:");
        g.dfsRecursive(0, new HashSet<>(g.getVertexCount()));
        System.out.println("BFS Iterative:");
        g.bfsWithoutRecursion(0);
    }
}