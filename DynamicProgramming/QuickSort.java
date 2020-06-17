package DynamicProgramming;

import java.util.Arrays;

public class QuickSort {
 
    private int partition(int[] array, int left, int right, int pivot){
        while(left<=right){
            while(array[left] < pivot)
                left++;
            while(array[right] > pivot)
              right--;

              if(left<=right){
                  swap(array, left, right);
                  left++;
                  right--;
              }    
        }
        return left;
    }

    private void sort(int[] array, int left, int right){
        if(left >= right) return;
        int pivot = array[(left + right) / 2];
        int index = partition(array, left, right, pivot);
        sort(array, left, index-1);
        sort(array, index, right);    
    }

    private void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static void main(String[] args) {
        QuickSort qs = new QuickSort();
        int[] A = new int[]{10,5,8,9,3,6,15,12,16, 0};
        qs.sort(A, 0, A.length-1);
        Arrays.stream(A).forEach(System.out::println);
    }
}