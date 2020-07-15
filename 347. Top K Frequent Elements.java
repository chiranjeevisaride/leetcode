class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(); 
        for(int num : nums) {
              map.put(num, map.getOrDefault(num, 0) + 1); 
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> map.get(a) - map.get(b));

        for(int e : map.keySet()) {
           minHeap.add(e);
           if(minHeap.size() > k) minHeap.poll();
        }

     
        for(int i = 0; i < k; i++) {
            result[i] =  minHeap.poll();
        }  

        return result;
    }
}