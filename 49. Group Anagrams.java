// Time & Space = O(NKlogK)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> groupedAnagrams = new ArrayList<>();
        if(strs == null || strs.length < 1) return groupedAnagrams;
		Map<String, List<String>> map = new HashMap<>();
		for(String word : strs){
			char[] characters = word.toCharArray();
			Arrays.sort(characters);
			String sortedString = new String(characters);
			if(!map.containsKey(sortedString)) {
					map.put(sortedString, new ArrayList<String>());
			}
			 map.get(sortedString).add(word);
		}
		groupedAnagrams.addAll(map.values());
    return groupedAnagrams;
    }
}

// Time & Space = O(NK)

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs) {
            String key = getKey(str);
            if(!map.containsKey(key))
                map.put(key, new ArrayList<>());
             map.get(key).add(str);
         }
       
        return new ArrayList<>(map.values());
    }
    
    private String getKey(String str) {
        int[] map = new int[26];
        for(char c : str.toCharArray()) {
           map[c-'a']++;
        }
        
        StringBuilder sb = new StringBuilder("");
        for(int index = 0; index < 26; index++) {
            sb.append(map[index]);
            sb.append("#");
        }
        return sb.toString();
    }
}