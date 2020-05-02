class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;
        Queue<String> queue = new LinkedList<String>();
        Set<String> seen = new HashSet<String>();
        queue.offer(beginWord);
        int result = 0;
        while(!queue.isEmpty()){
            ++result;
            int size = queue.size();
            for(int i=0; i< size; i++){
               String current = queue.poll();
               if(current.equals(endWord)) return result;
                List<String> children = getChildren(current, wordList);
                for(String child : children) {
                    if(!seen.contains(child)) {
                      queue.offer(child);
                      seen.add(child);
                    }
                 }   
            }
        }
        return 0;
    }
    
    
    public List<String> getChildren(String word, List<String> wordList){
        List<String> res = new ArrayList<>();
        for(String str : wordList){
            int cnt = 0;
            for(int j = 0; j < str.length(); j++){
                if(word.charAt(j) != str.charAt(j)){
                    ++cnt;
                }
            }
            if(cnt == 1)
                res.add(str);
        }
        return res;
    }
    
}