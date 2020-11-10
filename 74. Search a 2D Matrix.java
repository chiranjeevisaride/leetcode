

// Binary Search  Time = O(lognm) space - O(1)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        if(rows == 0 ) return false;
        int cols = matrix[0].length;
        
        int left = 0, right = rows * cols - 1;
        while(left <= right) {
            int pivot = (left+right)/2;
            int pivotElement = matrix[pivot/cols][pivot%cols];
            if(pivotElement == target) return true;
            else if(pivotElement > target)
                right = pivot - 1;
            else
                left = pivot + 1;
            
        }
        return false;
    }
}