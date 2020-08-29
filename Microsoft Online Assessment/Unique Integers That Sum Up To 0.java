class Solution {
    public int[] sumZero(int n) {
        if(n <= 0) return new int[0];
        int[] res = new int[n];
        int i = n%2==0 ? 0 : 1;
        int start = i, end =  n - 1;
        while(start < end) {
          if(start == 0) {res[start++] = n/2; res[end--] = -n/2; i++;}
          else {
            res[start++] = i;
            res[end--] = -i;
            i++;
          }  
        }  
        return res;
    }
}