import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/*

["abc", "ca", "ed"]

5 

*/


class Solution {
  
  private int result;
  
  public int maxLength(List<String> input) {
    result = 0;
    if(input == null || input.size() == 0) return result;
    dfs(input, 0, "");
    return result;
  }  
  
  private void dfs(List<String> input, int index, String current) {
    if(isValid(current)) {
      result = Math.max(result, current.length());
    }  
    
    for(int i = index; i < input.size(); i++)
        dfs(input, i + 1, current + input.get(i));
  }  
  
  
  private boolean isValid(String current) {
   Set<Character> set = new HashSet<>(
     current.chars().mapToObj(e -> (char)e).collect(Collectors.toList()));   
    
   return set.size() == current.length() ? true : false; 
  }  
  
  public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxLength(new ArrayList<String>(Arrays.asList("abc","kkk","def","csv"))));
  }
}
