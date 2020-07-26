//Time O(n)
//Space O(1)
class Solution {
    public int arrangeCoins(int n) {
       if(n <=0) return 0; 
       int i = 0, level = 1;
       while(n > 0){
        n = n - level;
        if(n < 0) break;
        level++;   
        i++;
       }
       return i;
    }
}


// Binary Search
// Time O(logn)
//Space O(1)
class Solution {
    public int arrangeCoins(int n) {
      if(n <= 0) return 0;  
      long left  = 0, right = n;
      while(left <= right) {
        long mid = left + (right - left)/2;
        long coins = mid* (mid+1)/2;
         if(coins == n) return (int)mid;
         else if(coins > n) right = mid -1;
         else 
             left = mid + 1;
      }
        return (int)right;
    }
}