class Solution {
    public int minDeletions(String s) {
        if(s == null || s.length() == 0) return 0;
        
        Map<Character, String> map = new HashMap<>();
        for(char c : s.toCharArray()) {
            if(map.containsKey(c))
                map.put(c, String.valueOf(map.get(c) + c));
            else
                map.put(c, String.valueOf(c));
        }
        
        PriorityQueue<String> minHeap = new PriorityQueue<String>((a,b) -> b.length() - a.length());
        for(String str : map.values()) {
            minHeap.add(str);
        }
        int counter = 0;
        while(!minHeap.isEmpty()) {
            String topString =  minHeap.remove();
            int len = minHeap.isEmpty() ? 0 : minHeap.peek().length();
            if(topString.length() == len) {
                counter += 1;
                if(topString.length() > 1)
                    minHeap.add(topString.substring(0, topString.length() - 1));
            }
        }
        return counter;
    }
}