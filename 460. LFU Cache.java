class ListNode {
    int key, value;
    ListNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class LFUCache {
    LinkedList<ListNode> list;
    int capacity;
    HashMap<Integer, Integer> cntr;
    HashMap<Integer, ListNode> keyMap;
    
    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.cntr = new HashMap<>();
        this.keyMap = new HashMap<>();
        this.list = new LinkedList<>();
    }
    
    public int get(int key) {
          ListNode node = keyMap.get(key);
           if(node != null) {
               list.remove(node);
               list.addFirst(node);
               cntr.put(key, cntr.get(key) + 1); 
               return node.value;
           }
           return -1;
    }
    
    public void put(int key, int value) {
        if(capacity == 0) return;
         ListNode node = keyMap.get(key);
         if(node != null) {
             node.value = value;
             keyMap.put(key, node);
             list.remove(node);
             list.addFirst(node);
             cntr.put(key, cntr.get(key) + 1); 
         } else {
             
             if(list.size() >= capacity) {
                 ListNode deletedNode = null; 
                 int minValue = Integer.MAX_VALUE;
                 for(int indx = 0; indx < list.size(); indx++) {
                     ListNode current = list.get(indx);
                     //System.out.println(current.key + " " + current.value);
                     if(cntr.get(current.key) <= minValue) {
                         minValue = cntr.get(current.key);
                         deletedNode = current;
                     }
                 }
                 list.remove(deletedNode);
                 cntr.remove(deletedNode.key);
                 keyMap.remove(deletedNode.key);
                 //System.out.println("*****");
             }
             ListNode newNode = new ListNode(key, value);
             keyMap.put(key, newNode); 
             cntr.put(key, 1); 
             list.addFirst(newNode);

         }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */