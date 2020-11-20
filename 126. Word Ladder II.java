

import java.io.*;
import java.util.*;


class Solution {
  
  private String end;
  private List<List<String>> result = new ArrayList<>();
  private Map<String, List<String>> graph;
  
  public List<List<String>> wordLatter2(String start, String end, List<String> wordList) {
    if(!wordList.contains(end)) return null;
     graph =  getAdjList(start, end, wordList);
     this.end = end;
     System.out.println(graph);
     LinkedList<String> path = new LinkedList<>();
     path.addLast(start);
     dfs(start, path);
     return result;
  }  
  
  
  private void dfs(String start, LinkedList<String> path) {
     if(start.equalsIgnoreCase(end)) {
       result.add(new ArrayList<>(path));
       return;
     }  
    
     for(String neighbor : graph.get(start)) {
         path.addLast(neighbor); 
         dfs(neighbor, path);
         path.removeLast();
     }  
  }  
  
  
  Map<String, List<String>> getAdjList(String start, String end, List<String> wordList) {
    Queue<String> queue = new LinkedList<>();
    Map<String, Integer> visited = new HashMap<>();
    Map<String, List<String>> adjList = new HashMap<>();
    visited.put(start, 0);
    queue.add(start);
    int level = 0;
    while(!queue.isEmpty()) {
      ++level;
      int size = queue.size();
      for(int index = 0; index < size; index++) {
        String current = queue.poll();
        for(String neighbor : getNeighbors(wordList, current)) {
          if(!visited.containsKey(neighbor)) {
              visited.put(neighbor, level);
               queue.add(neighbor);
               List<String> adjNodes = adjList.getOrDefault(current, new ArrayList<>());
               adjNodes.add(neighbor);
              adjList.putIfAbsent(current, adjNodes);
          } else {
              if(neighbor == end && visited.get(neighbor) > visited.get(current)) {
                queue.add(neighbor);
                List<String> adjNodes = adjList.getOrDefault(current, new ArrayList<>());
                adjNodes.add(neighbor);
                adjList.putIfAbsent(current, adjNodes);
              }  
          }  
        }
      }  
    }  
    return adjList;
  }  
  
  private List<String> getNeighbors(List<String> wordList, String current) {
    List<String> neighbors = new ArrayList<>();
    for(String word : wordList) { 
      int count = 0;
      for(int index = 0; index < word.length(); index++) {
         if(count > 1) break;
         if(current.charAt(index) != word.charAt(index))
          ++count;
      }
      if(count == 1) neighbors.add(word);
    }  
     return neighbors;
  }  
  
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.wordLatter2("hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog")));
  }
  
}
