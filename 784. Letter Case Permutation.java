// Time - O(N*2N) Space - O(N*2N)
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


class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        if(s == null || s.length() == 0) return result;
        dfs(s, result, 0);
        return result;
    }
    
    private void dfs(String s, List<String> result, int curIndx) {
        result.add(new String(s));
        for(int index = curIndx; index < s.length(); index++) {
            char[] c = s.toCharArray();
            if(Character.isLetter(c[index])) {
                c[index] = Character.isLowerCase(c[index]) ? 
                    Character.toUpperCase(c[index]) : Character.toLowerCase(c[index]);
                 dfs(new String(c), result, index + 1);
            }
        }
    }
}