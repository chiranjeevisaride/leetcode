// Time O(logn) Space O(n)
 Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> count = new HashMap();
        for (String word: words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        List<String> candidates = new ArrayList(count.keySet());
        Collections.sort(candidates, (w1, w2) -> count.get(w1).equals(count.get(w2)) ?
                w1.compareTo(w2) : count.get(w2) - count.get(w1));

        return candidates.subList(0, k);
    }
}


// Using Heap 
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
       List<String> freqWords = new ArrayList<>();
        Map<String, Integer> map = new HashMap<String, Integer>();

        for(String word : words) {
          map.put(word, map.getOrDefault(word, 0) + 1); 
        }  

        PriorityQueue<String> heap = new PriorityQueue<String>((a, b) -> { 
        return map.get(a) !=  map.get(b)) ? map.get(a) - map.get(b) : b.compareTo(a);        
        });

        for(String word : map.keySet()) {
            heap.add(word);
            if(heap.size() > k) heap.poll();
        }  

        for(int i = k; i > 0; i--) {
           freqWords.add(heap.poll());
        }  

        Collections.reverse(freqWords);
        return freqWords;
    }
}