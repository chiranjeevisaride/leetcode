
public class Solution {
  
    public static void main(String[] args) {
        System.out.println(minMaxK(new int[]{3, 2, -2, 5, -3}));
    }
  
   public static int minMaxK(int[] A) {
      int result = 0;
      if(A == null || A.length == 0) return result; 
      Set<Integer> set = Set.of(Arrays.stream(A).boxed().toArray(Integer[]::new));
      for(int i = 0; i < A.length; i++){
        int value = Math.abs(A[i]);
        if(set.contains(value) && set.contains(-value) && result < value)
          result = value;
      }  
      return result;
   }  
   
}
