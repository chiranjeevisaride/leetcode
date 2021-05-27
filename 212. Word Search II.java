class Solution {
    
    private char[][] board;
    private int[][] directions = {{-1,0}, {1,0}, {0,1}, {0,-1}};
    
    public List<String> findWords(char[][] board, String[] words) {
        List<String> wordList = new ArrayList<>();
        Map<Character, List<int[]>> map = new HashMap<>();
        int rows = board.length, cols = board[0].length;
        this.board = board;
        
        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                char c = board[row][col];
                List<int[]> initials;
                if(map.containsKey(c)) 
                    initials = map.get(c);
                 else
                    initials = new ArrayList<>();
                initials.add(new int[]{row, col});
                map.put(c, initials);
            }
        }
        
        for(String word: words) {
            if(map.containsKey(word.charAt(0))) {
                List<int[]> initials = map.get(word.charAt(0));
                for(int[] initial : initials) {
                    if(searchWord(initial[0], initial[1], word, 0)) {
                        wordList.add(word);
                        break;
                    }
                }
            }
        }
        
        return wordList;
    }
    
    private boolean searchWord(int row, int col, String word, int index) {
        if(index >= word.length()) return true;
        
        if(row < 0 || row >= board.length || col < 0 || col >= board[row].length 
           || board[row][col] == '#' || board[row][col] != word.charAt(index))
            return false;
        
        board[row][col] = '#';
        boolean res = false;
        
        for(int[] direction : directions) {
            res = searchWord(direction[0] + row, direction[1] + col, word, index+1);
            if(res) break;
        }
        board[row][col] = word.charAt(index);
        return res;
    }
}