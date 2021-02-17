class MyCalendar {
    
    TreeMap<Integer, Integer> bookingMap;
    
    public MyCalendar() {
         bookingMap = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        Integer prev = bookingMap.floorKey(start);
        Integer next = bookingMap.ceilingKey(start);
        if((prev == null || start >= bookingMap.get(prev)) && (next == null || end <= next)) {
            bookingMap.put(start, end);
            return true;
        } 
        return false;
        
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */