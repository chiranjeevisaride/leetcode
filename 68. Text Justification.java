class Solution {
    
    int maxWidth;
    String[] words;
    
    public List<String> fullJustify(String[] words, int maxWidth) {
        this.words = words;
        this.maxWidth = maxWidth;
        int i = 0, n = words.length;
        List<String> result = new ArrayList<>();
        while(i < n) {
             int j = i + 1;
             int lineLength = words[i].length();
             while(j < n && (lineLength + words[j].length() + (j - i - 1)) <  maxWidth) {
                lineLength += words[j].length();
                ++j; 
            }
            int numberOfWords = j - i;
            if(numberOfWords == 1 || j >= n)
                 result.add(leftJustify(lineLength, i, j));
            else
              result.add(middleJustify(lineLength, i, j)); 
            i = j;
        }
        return result;
    }
    
    public String middleJustify(int lineLength, int i, int j) {
        int diff = maxWidth - lineLength;
        int spacesNeeded = j - i - 1;
        int spaces = diff / spacesNeeded;
        int extraSpaces = diff % spacesNeeded;
        StringBuilder sb = new StringBuilder(words[i]);
        for(int k = i+1; k < j; k++) {
            int spacesToApply = spaces + (extraSpaces-- > 0 ? 1 : 0);
            sb.append(" ".repeat(spacesToApply) + words[k]);
        }
        return sb.toString();
    }
    
    public String leftJustify(int lineLength, int i, int j) {
        int diff = maxWidth - lineLength;
        int rightSpaces = diff - (j-i-1);
        StringBuilder sb = new StringBuilder(words[i]);
        for(int k = i+1; k < j; k++)
            sb.append(" " + words[k]);
        sb.append(" ".repeat(rightSpaces));
        return sb.toString();
    }
    
}