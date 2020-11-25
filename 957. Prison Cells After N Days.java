class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {
       
        int[] firstDay = calculateNextDay(cells);
        N--;
        cells = firstDay;
        int counter = 1;
        while(N > 0) {
          cells = calculateNextDay(cells);
            N--;
            if(isSame(firstDay , cells)) {
                N = N % counter;
            }  
            
           counter++;
        }  
        return cells;
    }
    
    
    private boolean isSame(int[] firstDay, int[] currentDay) {
        for(int index = 0; index < firstDay.length; index++)
          if(firstDay[index] != currentDay[index])
            return false;
      return true;
    }  
  
   private int[] calculateNextDay(int[] cells) {
       int[] temp = new int[cells.length];
       for(int index = 1; index < cells.length -1; index++) {
        if(cells[index-1] != cells[index + 1])
           temp[index] = 0;
         else
           temp[index] = 1;  
       }
       return temp;
   }
}