class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int rows = matrix.length, cols = matrix[0].length;
        int row = rows-1, col = 0;
        while(row >=0 && row < rows && col >=0 && col < cols) {
            if(matrix[row][col] == target) return true;
            else if(matrix[row][col] > target) {
                row -=1;
             } else if(matrix[row][col] < target)
                col += 1;
        }
        return false;
    }
}



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