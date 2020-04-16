package DataStructures;

import java.util.*;


public class GraphMatrix {
    int[][] matrix;
    int vertices;

    GraphMatrix(int vertices){
        this.vertices = vertices;
        this.matrix = new int[vertices][vertices];
    }

    public void addEdge(int source, int destination){
        matrix[source][destination] = 1;
        matrix[destination][source] = 1;
    }

    public void bfsIterative(int[][] matrix, int source){
        int vertices = matrix.length;
        Queue<Integer> queue = new LinkedList<Integer>();
        Set<Integer> seen = new HashSet<Integer>(vertices);
        queue.add(source);
        while(!queue.isEmpty()){
            int current = queue.poll();
            if(!seen.contains(current)){
                seen.add(current);
                System.out.println(current);
            }
            for(int j=0; j< vertices; j++){
                    if(matrix[current][j] == 1 && !seen.contains(j)){
                        queue.add(j);
                    }
            }
        }
    }


    public void dfsIterative(int[][] matrix, int source){
        int vertices = matrix.length;
        Stack<Integer> stack = new Stack<Integer>();
        Set<Integer> seen = new HashSet<Integer>(vertices);
        stack.push(source);
        while(!stack.isEmpty()){
            int current = stack.pop();
            if(!seen.contains(current)){
                seen.add(current);
                System.out.println(current);
            }
            for(int j=0; j< vertices; j++){
                    if(matrix[current][j] == 1 && !seen.contains(j)){
                        stack.push(j);
                    }
            }
        }
    }

    void printGraph(){
        for(int i=0; i< vertices; i++){
            for(int j=0; j< vertices; j++){
                System.out.print(matrix[i][j]);
            }
            System.out.print("\n");  
        }
            
    }

    public static void main(String[] args) {
        GraphMatrix g = new GraphMatrix(4);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(0, 3);
        g.printGraph();
        //g.bfsIterative(g.matrix, 0);
        g.dfsIterative(g.matrix, 0);
    }
}