class Solution {
    public int[][] kClosest(int[][] points, int K) {
       if(K== 0 || points.length == 0) return points; 
       PriorityQueue<int[]> maxHeap = new PriorityQueue<int[]>(
            (a,b) -> (b[0]*b[0] + b[1]*b[1]) - (a[0]*a[0] + a[1]*a[1]));
        
        for(int[] point : points) {
              maxHeap.add(point);  
              if(maxHeap.size() > K) maxHeap.remove();
        }
        
        int[][] result = new int[K][];
        while(K-- > 0) {
             result[K] = maxHeap.remove();
        }
             
       return result;
    }
    
   
}