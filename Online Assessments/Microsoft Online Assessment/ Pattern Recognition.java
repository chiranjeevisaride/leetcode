class Solution {
  
    public String patternMatching(String input) {
       if(input == null || input.length() == 0) return "";
       String[] inputs = input.split(";");
       String pattern = inputs[0];
       String[] blobs = inputs[1].split("\\|");
       StringBuffer sb = new StringBuffer();
       int global_counter = 0;
       for(String blob : blobs) {
          int count = 0;
         if(pattern != null && pattern.length() > 0)
             count = patternCount(pattern, blob);
         global_counter += count;
         sb.append(String.valueOf(count + "|"));
       }  
      
      sb.append(global_counter);
      return sb.toString();
    }  
    
    
    private int patternCount(String patter, String blob) {
      int count = 0, last_index = 0;
      while(last_index != -1) {
        last_index = blob.indexOf(patter, last_index);
        if(last_index != -1) {
          last_index += patter.length();
          count += 1;
        }  
          
      }  
      return count;
    }  
    
    public static void main(String[] args) {
      Solution s = new Solution();
      System.out.println(s.patternMatching("bc;bcdefbcbebc|abcdebcfgsdf|cbdbesfbcy|1bcdef23423bc32"));
      System.out.println(s.patternMatching("b;bcdefbcbebc|abcdebcfgsdf|cbdbesfbcy|1bcdef23423bc32"));
      System.out.println(s.patternMatching(";bcdefbcbebc|abcdebcfgsdf|cbdbesfbcy|1bcdef23423bc32"));
    }
    
  }
  