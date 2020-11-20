// Time - O(2^N) * N
// Space - O(2^N) * N
class Solution {
    
    private int[][] graph;
    private List<List<Integer>> result;
    private int end;
    
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        if(graph == null || graph.length == 0) return null;
        int start = 0;
        result = new ArrayList<>();
        end = graph.length - 1;
        this.graph = graph;
        LinkedList<Integer> path = new LinkedList<>();
        path.addLast(start);
        dfs(start, path);
        return result;
    }
    
    
    public void dfs(int start, LinkedList<Integer> path) {
        if(start == end) {
            result.add(new ArrayList<>(path));
            return;
        }
        
        for(int neighbour : graph[start]) {
            path.addLast(neighbour);
            dfs(neighbour, path);
            path.removeLast();
        }
    }
}