class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> result = new ArrayList<>();
        generatePermutations(0, S, result);
        return result;
    }
    
    public void generatePermutations(int index, String str, 
                                     List<String> result) {
        result.add(str);
        for(int i = index; i < str.length(); i++) {
            char[] wordArr = str.toCharArray();
            if(Character.isLetter(wordArr[i])) {
                if(Character.isUpperCase(wordArr[i])) {
                    wordArr[i] = Character.toLowerCase(wordArr[i]);
                    generatePermutations(i+1, String.valueOf(wordArr), result);
                } else {
                    wordArr[i] = Character.toUpperCase(wordArr[i]);
                    generatePermutations(i+1, String.valueOf(wordArr), result);
                }
            } 
        }
    }
}