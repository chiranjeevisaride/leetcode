/*

class Solution {
    public List<String> removeComments(String[] source) {
        // Comments       
    }
}


*/


class Solution {
    public List<String> removeComments(String[] source) {
        List<String> result = new ArrayList<>();
        if(source == null || source.length == 0) return result;
        boolean inBlock = false;
        StringBuilder newLine = new StringBuilder();
        for(String line : source) {
            int i = 0;
            char[] chars = line.toCharArray();
            if(!inBlock) newLine = new StringBuilder();
            while(i < line.length()) {
                if(!inBlock && i + 1 < line.length() && chars[i] == '/' && chars[i+1] == '*') {
                    inBlock = true;
                    i++;
                }
                else if(inBlock && i + 1 < line.length() && chars[i] == '*' && chars[i+1] == '/') {
                    inBlock = false;
                    i++;
                }
                else if(!inBlock && i + 1 < line.length() && chars[i] == '/' && chars[i+1] == '/') 
                    break;
                else if(!inBlock) {
                    newLine.append(chars[i]);
                }
                i++;
            }
            if(!inBlock && newLine.length() > 0)
                result.add(newLine.toString());
        }
        return result;
    }
}