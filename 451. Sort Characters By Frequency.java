class Solution {
    public String frequencySort(String s) {
        if(s == null ||  s.length() == 0) return s;
        StringBuilder sortedString = new StringBuilder();
        HashMap<Character, Integer> charCounter = new HashMap<Character, Integer>();
        for(char c : s.toCharArray())
                charCounter.put(c, charCounter.getOrDefault(c, 0) + 1);
            
        PriorityQueue<Character> maxHeap = new PriorityQueue<>
            ((a, b) -> charCounter.get(b) - charCounter.get(a));
        
         for(Character c : charCounter.keySet())
             maxHeap.offer(c);
             
         while(!maxHeap.isEmpty()){
             Character c = maxHeap.poll();
             int charCount = charCounter.get(c);
             while(charCount -- > 0)
                sortedString.append(c);
         }
        
        return sortedString.toString();
    }
}