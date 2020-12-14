import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


class Solution {
  
  public int[] cycleSort(int[] input) {
    if(input == null || input.length == 0) return input;
    int i = 0;
    while(i < input.length) {
     int j = input[i] - 1;
     if(input[j] != input[i]) {
       swap(input, i, j);
     } else
        i++;
    }  
    
   System.out.println(Arrays.stream(input).boxed().collect(Collectors.toList()));
    return input;
  }  
  
  
  private void swap(int[] input, int i, int j) {
    int temp = input[i];
    input[i] = input[j];
    input[j] = temp;
  }  
  public static void main(String[] args) {
    Solution s = new Solution();
    s.cycleSort(new int[]{3, 1, 5, 4, 2});
    s.cycleSort(new int[]{2, 6, 4, 3, 1, 5});
  }
}
