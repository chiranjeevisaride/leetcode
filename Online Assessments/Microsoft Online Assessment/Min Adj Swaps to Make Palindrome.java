import java.io.*;
import java.util.*;

/*


0 1 2 3 4
m a m a d


a m m d a

a m m d a

a m d m a


n t i i n

n i t i n



d m m a a

m a d a m


n a h n a h

a n h n h a

a h n n h a


r o t a t o r

o t r t o r a

o t r t a r o

o t r a r t o



a s f l k j



d a m a m

a d m a m

a d m m a

a m d m a



m a m a d

d m m a a 

m d m a a

m d a m a

m d a a m

m a d a m


 */

class Solution {
  
  
  
  private static boolean isPalindrome(char[] arr) {  
    Set<Character> count = new HashSet<>();
    for(char c : arr) {
      if(count.contains(c))
        count.remove(c);
      else
        count.add(c);
    } 
    return count.size() < 2;
  }  
    
  public static int adjacentSwaps(String input) {
    if(input == null || input.length() == 0) return -1;
    char[] charArr = input.toCharArray();
    int totalSwaps = 0;
    if(!isPalindrome(charArr))
      return -1;
    
    int p1 = 0, p2 = input.length() - 1;
    
    while(p2 > p1) {
      if(charArr[p1] != charArr[p2]) {
          int k = p2;
        while(k > p1 && charArr[k] != charArr[p1]) k--;
        if(k == p1) { //When no matching character found
          swap(charArr, p1, p1 + 1);
          totalSwaps++;
       } else { //When Matching character found swap until K reaches p2 position
          while(k < p2) {
            swap(charArr, k, k + 1);
            totalSwaps++;
            k++;
          }
          p1++; p2--;
       }               
     } else {
        p1++; p2--; //When the characters are equal move on
       }
    }
    return totalSwaps;
  }  
  
  private static void swap(char[] charArr, int k, int i) {
        char temp = charArr[k];
        charArr[k] = charArr[i];
        charArr[i] = temp;
  }
  
  public static void main(String[] args) {
      test(adjacentSwaps("dmmaa"), 4);
      test(adjacentSwaps("aabb"), 2);
  }
  
  private static void test(int actual, int expected) {
      if (actual == expected) {
        System.out.println("PASSED!");
      } else {
        System.out.println(String.format("FAILED! Expected %d, but got: %d", expected, actual));
      }
  }
  
}


//2nd Method 

import java.io.*;
import java.util.*;
import java.util.stream.*;


/*

Given a sorted array, create a new array containing squares of all the numbers of the input array in the sorted order.



*/

class Solution {
  
  
  public static int minSwapsToPalindrome(String s) {
    if(s == null || s.length() == 0) return -1;
    char[] arr = s.toCharArray();
    int minSwaps = 0, left = 0, right = s.length() - 1;
    while(left < right) {
      if(arr[left] == arr[right]) {
        left++; right--;
      } else {
        int rightMatch = findMatch(left, right, arr, true);
        if(rightMatch != -1) {
          minSwaps += (right - rightMatch); 
          swaps(arr,rightMatch, right, true);
          continue;
        }
       int leftMatch = findMatch( left, right, arr, false);
        if(leftMatch != -1) {
          minSwaps += (leftMatch - left); 
          swaps(arr,leftMatch, left, false);
          continue;
        }
        return -1;
      }  
    }
    return minSwaps;
  }
  
  private static void swaps(char[] arr, int src, int dest, boolean rightToLeft) {
    if(rightToLeft) {
        while(src < dest) {
        char temp = arr[src+1];
        arr[src+1] = arr[src];
        arr[src++] = temp;
      }
    } else {
        while(src > dest) {
        char temp = arr[src-1];
        arr[src-1] = arr[src];
        arr[src--] = temp;
      }
    }   
  }  
  
  private static int findMatch(int srcIndx, int indx, char[] arr, boolean rightToLeft) {
    if(rightToLeft) {
        while(srcIndx < indx) {
          if(arr[srcIndx] == arr[indx])
            return indx;
          indx--;
        }
    } else {
      while(srcIndx < indx) {
          if(arr[srcIndx] == arr[indx])
            return srcIndx;
          srcIndx++;
        }
    }  
    return -1;
  }  
  
  public static void main(String[] args) {
    System.out.println(minSwapsToPalindrome("mamad"));
    System.out.println(minSwapsToPalindrome("asflkj"));
    System.out.println(minSwapsToPalindrome("aabb"));
    System.out.println(minSwapsToPalindrome("ntiin"));
  }
}
