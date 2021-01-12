/*
Items in Containers

Amazon would like to know how much inventory exists in their closed inventory compartments. Given a string s
consisting of items as "*" and closed compartments as an open and close "|", an array of starting indices
startIndices, and an array of ending indices endIndices, determine the number of items in closed compartments
within the substring between the two indices, inclusive.

An item is represented as an asterisk ('*' = ascii decimal 42)
A compartment is represented as a pair of pipes that may or may not have items between them ('|' = ascii decimal 124).

Example

s = '|**|*|*'

startIndices = [1, 1]

endIndices = [5, 6]

The string has a total of 2 closed compartments, one with 2 items and one with 1 item. For the first pair of
indices, (1, 5), the substring is '|**|*'. There are 2 items in a compartment.

For the second pair of indices, (1, 6), the substring is '|**|*|' and there are 2 + 1 = 3 items in compartments.

Both of the answers are returned in an array, [2, 3].

Function Description .

Complete the numberOfItems function in the editor below. The function must return an integer array that contains
the results for each of the startIndices[i] and endIndices[i] pairs.

numberOfItems has three parameters:

s: A string to evaluate

startIndices: An integer array, the starting indices.

endIndices: An integer array, the ending indices.

Constraints

1 ≤ m, n ≤ 105
1 ≤ startIndices[i] ≤ endIndices[i] ≤ n
Each character of s is either '*' or '|'

Input Format For Custom Testing

The first line contains a string, S.
The next line contains an integer, n, the number of elements in startIndices.
Each line i of the n subsequent lines (where 1 ≤ i ≤ n) contains an integer, startIndices[i].
The next line repeats the integer, n, the number of elements in endIndices.
Each line i of the n subsequent lines (where 1 ≤ i ≤ n) contains an integer, endIndices[i].

Sample Case 0
Sample Input For Custom Testing

STDIN Function

*|*| -> s = "*|*|"

1 -> startIndices[] size n = 1
1 -> startIndices = 1
1 -> endIndices[] size n = 1
3 -> endIndices = 3

** Sample Output**
0

Explanation
s = *|*|

n = 1
startIndices = [1]
n = 1
startIndices = [3]

The substring from index = 1 to index = 3 is '|'. There is no compartments in this string.

Sample Case 1
Sample Input For Custom Testing

STDIN Function


*/


import java.io.*;
import java.util.*;


class Solution {
  
  // O(n^2)
  public List<Integer> numberOfItems(String s, List<Integer> startIndices, List<Integer> endIndices) {
    List<Integer> result = new ArrayList<>();
    for(int start = 0, end = 0; start < startIndices.size() && end < endIndices.size(); start++, end++) {
        int tempCount = 0, count = 0;
        boolean compartmentStart = false;
        for(int i = startIndices.get(start) - 1; i < endIndices.get(end); i++) {
          char c = s.charAt(i);
          if(c == '|' && !compartmentStart) {
            compartmentStart = true;
          } else if(c == '|' && compartmentStart) {
            count += tempCount;
            tempCount = 0;
          } else if(c == '*' && compartmentStart) {
                tempCount++;
          }  
        }  
      result.add(count);
    }  
    return result;
  }  

  
 // time complexity is O(n log n + m log n) [n times insertion and m times search] where n = length of String s and m = length of start list.
  public List<Integer> numberOfItems2(String s, List<Integer> startIndices, List<Integer> endIndices) {
    List<Integer> result = new ArrayList<>();
    int count = 0;
    NavigableMap<Integer, Integer> map = new TreeMap<>();
    for(int index = 0; index < s.length(); index++) {
      char c = s.charAt(index);
      if(c == '*') count++;
      else if(c == '|') {
        map.put(index, count);
      } 
    }  
    System.out.println(map);
    
    for(int index = 0; index < startIndices.size(); index++) {
      result.add(size(map,startIndices.get(index) -1 , endIndices.get(index) - 1));
    }  
    return result;
  }
  
  
  private int size(NavigableMap<Integer, Integer> map, int start, int end) {
    if(map.floorKey(end) == null || map.ceilingKey(start) == null) return 0;
    else
    return map.get(map.floorKey(end)) - map.get(map.ceilingKey(start));
  }  
  
  public static void main(String[] args) {
    Solution s = new Solution();
    List<Integer> startIndices = Arrays.asList(1);
    List<Integer> endIndices = Arrays.asList(6);
    System.out.println(s.numberOfItems2("*|*|*|",startIndices, endIndices));
    
    
    startIndices = Arrays.asList(1,1);
    endIndices = Arrays.asList(5,6);
    System.out.println(s.numberOfItems2("|**|*|",startIndices, endIndices));
    
  } 
  
}
