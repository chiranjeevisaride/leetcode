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