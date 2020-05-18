import java.util.*;
// Time - O(nlogn)  logn to cal sum if digits, Space - O(n)
class Main {
  public static void main(String[] args) {
    Main m = new Main();
    int[] A = new int[]{51, 71, 17,42};
    System.out.println(m.numberWithEqualDigits(A));
  }

  public int numberWithEqualDigits(int[] A){
    int result = -1;
    Map<Integer, Integer> hMap = new HashMap<Integer, Integer>();
    for(int i=0; i< A.length; i++){
      int sum = findSumFromDigit(A[i]);
      if(hMap.containsKey(sum)){
          hMap.put(sum, hMap.get(sum) + A[i]);
          if(result == -1 || hMap.get(sum) > result)
              result = hMap.get(sum);
      }
       else
         hMap.put(sum, A[i]);   
    }
    return result;
  }

  public int findSumFromDigit(int digit){
    int sum = 0;
    digit = Math.abs(digit);
    while(digit !=0){
      sum += (digit%10);
      digit = digit/10;
    }
    return sum;
  }
}