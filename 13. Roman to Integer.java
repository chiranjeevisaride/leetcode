class Solution {
    String s;
    public int romanToInt(String s) {
        int integer = 0;
        this.s = s;
        Map<Character, Integer> map = new HashMap<>() {{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};
        
        for(int indx = 0; indx < s.length(); indx++) {
            if(indx < s.length() - 1 && isSubtraction(indx)) {
               int sum =  map.get(s.charAt(indx + 1)) - map.get(s.charAt(indx));
               integer += sum; 
               indx++;
            } else
                integer += map.get(s.charAt(indx));
        }
        return integer;
    }
    
    
    private boolean isSubtraction(int indx) {
        if((s.charAt(indx + 1) == 'V' || s.charAt(indx + 1) == 'X') && s.charAt(indx) == 'I' || 
           (s.charAt(indx + 1) == 'L' || s.charAt(indx + 1) == 'C') && s.charAt(indx) == 'X' || 
           (s.charAt(indx + 1) == 'D' || s.charAt(indx + 1) == 'M') && s.charAt(indx) == 'C')
        return true;
      return false;  
    }
}