class Solution {
  
    Map<Long, Node> map = new HashMap<>();
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length < 1) return 0;
        
        for(int num : nums)
            makeSet(num);
        
        for(long num : map.keySet()) {
            if(map.containsKey(num-1))
                union(num-1, num);
            if(map.containsKey(num+1))
                union(num+1, num);
        }
        
        Map<Long, Integer> counter = new HashMap<>();
        int maxSequence = 0;
        for(long num : map.keySet()) {
            long key = findSet(num);
            counter.put(key, counter.getOrDefault(key, 0) + 1);
            maxSequence = Math.max(counter.get(key), maxSequence);
        }  
        return maxSequence;
    }
    
   class Node {
        long data;
        int rank;
        Node parent;
    }

   public void makeSet(long data) {
       Node node = new Node();
       node.data = data;
       node.rank = 0;
       node.parent = node;
       map.put(data, node);
   }

   public Node findSet(Node node) {
       Node parent = node.parent;
       if(parent == node) return parent;
       node.parent = findSet(parent);
       return node.parent;
   }

   public boolean union(long data1, long data2) {
       Node node1 = map.get(data1);
       Node node2 = map.get(data2);

       Node parent1 = findSet(node1);
       Node parent2 = findSet(node2);

       if(parent1 == parent2) return false;
      
       if(parent1.rank >= parent2.rank) {
            parent1.rank = parent1.rank == parent2.rank ? parent1.rank + 1 : parent1.rank;
            parent2.parent = parent1;
       } else{
            parent1.parent = parent2; 
       }

      return true;
   }

   public long findSet(long data) {
       return findSet(map.get(data)).data;
   }
}

