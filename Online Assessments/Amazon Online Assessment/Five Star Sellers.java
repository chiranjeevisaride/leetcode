import java.io.*;
import java.util.*;

class Solution {
  
 public int fiveStarReviews(List<List<Integer>> productRatings, int ratingsThreshold) {
   int minReviews = 0;
   PriorityQueue<List<Integer>> maxHeap = new PriorityQueue<>((l1, l2) -> diff(l2) - diff(l1));  
   for(List<Integer> productRating : productRatings)
     maxHeap.add(productRating);
   
   double curRating = 0;
   for(List<Integer> rating : productRatings) 
     curRating += 100.0 * rating.get(0) / rating.get(1);
    
   int size = productRatings.size();
   
   while(curRating  < ratingsThreshold * size) {
     System.out.println(maxHeap);
     minReviews++;
    List<Integer> rating = maxHeap.poll();
    List<Integer> newRating = Arrays.asList(rating.get(0)+1, rating.get(1)+1);
    curRating = curRating - 100.0 * rating.get(0) / rating.get(1) + 
       100.0 * newRating.get(0) / newRating.get(1);
     maxHeap.offer(newRating);
     
   }    
   return minReviews;
 }  
  
  
private int diff(List<Integer> p) {
    double currRating = 100.0 * p.get(0) / p.get(1);
    double newRating = 100.0 * (p.get(0)+1) / (p.get(1)+1);
    return (int)(newRating - currRating);
} 
  
 public static void main(String[] args) {
   Solution s = new Solution();
   List<List<Integer>> ratings = new ArrayList<>(){{
     add(Arrays.asList(4,4));
     add(Arrays.asList(1,2));
     add(Arrays.asList(3,6));
   }};
     
   s.fiveStarReviews(ratings, 77);
  }
}
