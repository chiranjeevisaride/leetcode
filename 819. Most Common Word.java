class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        HashSet<String> bannedWords = new HashSet<String>();
        for(String word : banned)
             bannedWords.add(word);
    
        HashMap<String, Integer> counter = new HashMap<String, Integer>();
        for(String word : paragraph.replaceAll("[^a-zA-Z]", " ").toLowerCase().split("\\s+")){
            if(!bannedWords.contains(word)){
                counter.put(word, counter.getOrDefault(word, 0) + 1);
            }
                
        }
        
        String result = "";
        for(String key: counter.keySet()){
            if(result == "" || counter.get(key) > counter.get(result))
                result = key;
        }
        
        return result;
    }
}