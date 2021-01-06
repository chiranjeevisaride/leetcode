class Solution {
    
    List<String> arr;
    String[] result = new String[1];
    
    public int maxLength(List<String> arr) {
        if(arr == null || arr.size() == 0) return 0;
        this.arr = arr;
        result[0] = "";
        dfs(0, new LinkedList<String>(), result);
        return result[0].length();
    }
    
    private void dfs(int currentIndex, LinkedList<String> list, String[] result) {
        if(!list.isEmpty() && list.getLast().length() > result[0].length() && isUnique(list.getLast())) 
                result[0] = list.getLast();
        
        for(int index = currentIndex; index < arr.size(); index++) {
            String temp = "";
            if(!list.isEmpty())
                temp = list.getLast();
            temp += arr.get(index);
            list.add(temp);
            dfs(index+1, list, result);
            list.removeLast();
        }
    }
    
    private boolean isUnique(String str1) {
        int[] map = new int[26];
        for(char c : str1.toCharArray())
            map[c-'a']++;
        for(int i = 0; i < 26; i++)
            if(map[i] > 1) return false;
        return true;
    }
    
}