class TrieNode implements Comparable<TrieNode> {
    String s;
    int times;
    TrieNode[] children;
    List<TrieNode> hot;
    
    TrieNode() {
        this.children = new TrieNode[128];
        this.hot = new ArrayList<>();
        this.times = 0;
        this.s = null;
    }
    
    public int compareTo(TrieNode o) {
        if(this.times == o.times)
            return this.s.compareTo(o.s);
        return o.times - this.times;
    }
    
    public void update(TrieNode node) {
        if(!hot.contains(node))
            hot.add(node);
        Collections.sort(hot);
        
        if(hot.size() > 3)
            hot.remove(hot.size() - 1);
    }
}


class AutocompleteSystem {
    TrieNode current, root;
    StringBuffer sb;
    
    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode();
        sb = new StringBuffer();
        current = root;
        for(int index = 0; index < times.length; index++) {
            add(sentences[index], times[index]);
        }
    }
       
    public void add(String sentence, int times) {
        TrieNode temp = root;
        List<TrieNode> visited = new ArrayList<>();
        for(char c : sentence.toCharArray()) {
            if(temp.children[c] == null) {
                temp.children[c] = new TrieNode();
            }
            temp = temp.children[c];
            visited.add(temp);
        }
        
        temp.s = sentence;
        temp.times+= times;
        
        for(TrieNode node : visited) {
            node.update(temp);
        }
    }    
      
    public List<String> input(char c) {
        List<String> suggestions = new ArrayList<>(); 
        if(c == '#') {
            add(sb.toString(), 1);
            sb = new StringBuffer();
            current = root;
            return suggestions;
        }
        sb.append(c);
        if(current != null) {
            current = current.children[c];
        }
            
        if(current == null) return suggestions;
        
        for(TrieNode node : current.hot) {
            suggestions.add(node.s);
        }
        return suggestions;
    }
}




/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */