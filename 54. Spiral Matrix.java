class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int top = 0, bottom = matrix.length - 1, left = 0, right = matrix[0].length - 1, direction = 0;
        LinkedList<Integer> result = new LinkedList<>();
        while(top <= bottom && left <= right) {
              if(direction == 0) {
                for(int index = left; index <= right; index++)
                    result.addLast(matrix[top][index]);
                  top++;
              } else if(direction == 1) {
                for(int index = top; index <= bottom; index++)
                  result.addLast(matrix[index][right]);
                  right--;
              } else if(direction == 2) {
               for(int index = right; index >= left; index--)
                  result.addLast(matrix[bottom][index]);
                  bottom--;
              } else if(direction == 3) {
               for(int index = bottom; index >= top; index--)
                  result.addLast(matrix[index][left]);
                  left++;
              }
             direction = (direction + 1) % 4;
        }  
        return result;
    }
}