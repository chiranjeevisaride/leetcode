class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int minDistance = Integer.MAX_VALUE, l1 = -1, l2 = -1;
        for(int index = 0; index < wordsDict.length; index++) {
            if(word1.equals(wordsDict[index])) l1 = index;
            if(word2.equals(wordsDict[index])) l2 = index;
            
            if(l1 != -1 && l2 != -1) {
                minDistance = Math.min(minDistance, Math.abs(l1-l2));
            }
        }
        
        return minDistance;
    }
}