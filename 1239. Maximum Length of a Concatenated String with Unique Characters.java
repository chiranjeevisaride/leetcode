class Solution {
    public int maxLength(List<String> arr) {
        int[] result = new int[1];
        getMaxLength(0, arr, "", result); 
        return result[0];
    }
    
    public void getMaxLength(int index, List<String> arr, String currentStr, int[] maxLenth) {
        if(index == arr.size() && uniqueCharCount(currentStr) > maxLenth[0]) {
            maxLenth[0] = currentStr.length();
            return;
        }
        if(index == arr.size())
            return;
        
        getMaxLength(index + 1, arr, currentStr + arr.get(index), maxLenth);
        getMaxLength(index + 1, arr, currentStr, maxLenth);
    }
    
    public int uniqueCharCount(String currentStr) {
      int[] count = new int[26];
        for(char c : currentStr.toCharArray()) 
            if(count[ c - 'a']++ > 0) return -1;
           return currentStr.length();
    }
}