import java.io.*;
import java.util.*;

/*

Input: codeList = [[apple, apple], [banana, anything, banana]] shoppingCart = [orange, apple, apple, banana, orange, banana]
Output: 1
Explanation:
codeList contains two groups - [apple, apple] and [banana, anything, banana].
The second group contains 'anything' so any fruit can be ordered in place of 'anything' in the shoppingCart. The customer is a winner as the customer has added fruits in the order of fruits in the groups and the order of groups in the codeList is also maintained in the shoppingCart.

*/

class Solution {
  
   
  public int willWinPrize(String[][] codeList, String[] shoppingCart) {
    if(codeList == null || codeList.length == 0) return 1;
    if(shoppingCart == null || shoppingCart.length == 0) return 0;
    int i = 0, j = 0;;
    while(i < codeList.length && j + codeList[i].length <= shoppingCart.length) {
      boolean match = true;
      for(int k = 0; k < codeList[i].length; k++) {
        if(!codeList[i][k].equals("anything") && codeList[i][k] !=  shoppingCart[j+k]) {
          match = false;
          break;
        } 
      } 
      if(match) {
        j+= codeList[i].length;
        i++;
      } else {
        j++;
      }  
    }
    return i == codeList.length  && j == shoppingCart.length ? 1 : 0;
  }  
  
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.willWinPrize(new String[][]{{"apple", "apple"}, {"banana", "anything", "banana"}}, 
                                      new String[]{
                                        "orange", "apple", "apple", "banana", "orange", "banana"}));
    
    System.out.println(s.willWinPrize(new String[][]{{"apple", "apple"}, {"banana", "orange", "banana"}}, 
                                      new String[]{"banana", "orange", "banana", "apple", "apple"}));
    
    
    System.out.println(s.willWinPrize(new String[][]{{"apple", "apple"}, {"banana", "orange", "banana"}}, 
                                      new String[]{"apple", "banana", "apple", "banana", "orange", "banana"}));
    
    
     System.out.println(s.willWinPrize(new String[][]{{"apple", "apple"}, {"apple", "apple", "banana"}}, 
                                      new String[]{"apple", "apple", "apple", "banana"}));
  } 
  
}
