import java.io.*;
import java.util.*;



class MergeSortAlgo {
  
   public static void merge(int[] array, int[] temp, int leftStart, int rightEnd) {
      int leftEnd = (leftStart + rightEnd) / 2;
      int rightStart = leftEnd + 1;
      int size = (rightEnd - leftStart) + 1;
     
      int left = leftStart;
      int right = rightStart;
      int index = leftStart;
      
     while(left <= leftEnd && right <= rightEnd) {
          if(array[left] <= array[right]) 
             temp[index++] = array[left++];
          else
            temp[index++] = array[right++];
     }
     
      //System.arraycopy(array, left, temp, index, leftEnd - left + 1);
      while(left <= leftEnd) 
        temp[index++] = array[left++];
     
    // System.arraycopy(array, right, temp, index, rightEnd - right + 1);
      while(right <= rightEnd) 
        temp[index++] = array[right++];
     
      //System.arraycopy(temp, leftStart, array, leftStart, size); 
     for(int i = leftStart; i < size; i++) {
        array[i] = temp[i];
     } 
     
   }  
  
  
   public static void mergeSort(int[] array, int[] temp, int leftStart, int rightEnd) {
      if(leftStart >= rightEnd) return;
      int middleValue = (leftStart + rightEnd)/2;
      mergeSort(array, temp, leftStart, middleValue);
      mergeSort(array, temp, middleValue + 1, rightEnd);
      merge(array, temp, leftStart, rightEnd);
   }  
  
  public static void main(String[] args) {
    int[] input = {4,3,3,1,2,2};
     mergeSort(input, new int[input.length], 0, input.length - 1);
    for(int i : input) {
        System.out.print( i + " "); 
    }  
  }  
}
  
  
