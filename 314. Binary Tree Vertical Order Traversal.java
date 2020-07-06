// Approach1: BFS 
// Time - O(nlogn) Space - (n)
class Solution {
    
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Map<Integer, List<Integer>> map = new TreeMap<>();
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));
        while(!queue.isEmpty()) {
            Pair<TreeNode, Integer> currentNode = queue.poll();
            int column = currentNode.getValue();
            root = currentNode.getKey();
            
            map.putIfAbsent(column, new ArrayList<>());
            map.get(column).add(root.val);
            
            if(root.left != null) {
                queue.offer(new Pair(root.left, column-1));
            }
            if(root.right != null) {
                 queue.offer(new Pair(root.right, column+1));
            }
        }
        return new ArrayList<>(map.values());
    }
}


// Approach1: BFS + without sorting
// Time - O(n) Space - O(n)

class Solution {

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        int column = 0;
        queue.offer(new Pair(root, column));
        int maxColumn = 0, minColumn = 0;
        
        while(!queue.isEmpty()) {
            Pair<TreeNode, Integer> currentNode = queue.poll();
            column = currentNode.getValue();
            root = currentNode.getKey();
            
            map.putIfAbsent(column, new ArrayList<>());
            map.get(column).add(root.val);
            
            minColumn = Math.min(minColumn, column);
            maxColumn = Math.max(maxColumn, column);
            
            if(root.left != null) {
                queue.offer(new Pair(root.left, column-1));
            }
            if(root.right != null) {
                queue.offer(new Pair(root.right, column + 1));
            }
        }
        
        for(int i = minColumn; i <= maxColumn; i++) {
            result.add(map.get(i));
        }
        
        return result;
    }
}