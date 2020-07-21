class Solution {
    public void merge(int[] num1, int m, int[] num2, int n) {
      if(num1 == null || num2 == null) return;
      int[] num1_copy = new int[m];  
      System.arraycopy(num1, 0, num1_copy, 0, m);    
      int left = 0;
      int right = 0;
      int index = 0;  
      while(left < m && right < n) {
          if(num1_copy[left] <= num2[right])
            num1[index++] = num1_copy[left++];
          else
            num1[index++] = num2[right++];  
      }
      
      if(left < m)
          System.arraycopy(num1_copy, left, num1, left + right, m - left);
        
      if(right < n)
         System.arraycopy(num2, right, num1, left + right,  n - right);
        
    }     
}