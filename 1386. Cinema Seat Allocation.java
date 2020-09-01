class Solution {
    
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        if(reservedSeats.length==0) return 2*n;
        int optimal_allocations = 0;
        HashMap<Integer, Set<Integer>> map = 
            new HashMap<Integer, Set<Integer>>();
        
        for (int i = 0; i < reservedSeats.length; i++) {
            int[] pair = reservedSeats[i];
            int row = pair[0], col = pair[1];
            if (map.containsKey(row)) {
                Set<Integer> set = map.get(row);
                set.add(col);
            }
            else {
                Set<Integer> set = new HashSet<Integer>();
                set.add(col);
                map.put(row, set);
            }
        }
        
        for(Set<Integer> set : map.values()) {
           int pos1 = 1, pos2 = 1, pos3 = 1;
           for(Integer  seatNo : set) {
               if(seatNo == 2 || seatNo == 3)
                   pos1 = 0;
               if(seatNo == 4 || seatNo == 5) {
                    pos1 = 0;
                    pos2 = 0;
               }
               if(seatNo == 6 || seatNo == 7) {
                    pos2 = 0;
                    pos3 = 0;
               }
               if(seatNo == 8 || seatNo == 9)
                   pos3 = 0;
           }
             optimal_allocations += Math.max(pos1+pos3, pos2);
        }
        
        optimal_allocations += (n - map.size()) * 2;
                
        return optimal_allocations;
    }
}