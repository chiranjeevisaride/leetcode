class Solution {
    public String frequencySort(String s) {
        if(s == null ||  s.length() == 0) return s;
        StringBuilder sortedString = new StringBuilder();
        HashMap<Character, Integer> counter = new HashMap<Character, Integer>();
        for(char c : s.toCharArray())
                counter.put(c, counter.getOrDefault(c, 0) + 1);
            
        PriorityQueue<Character> maxHeap = new PriorityQueue<>
            ((a, b) -> counter.get(b) - counter.get(a));
        
         for(Character c : counter.keySet())
             maxHeap.offer(c);
             
         while(!maxHeap.isEmpty()){
             Character c = maxHeap.poll();
             int charCount = counter.get(c);
             while(charCount -- > 0)
                sortedString.append(c);
         }
        
        return sortedString.toString();
    }
}