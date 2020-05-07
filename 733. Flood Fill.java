class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image[sr][sc] == newColor) return image;
        return fillImage(image, sr, sc, image[sr][sc], newColor);
    }
    
    public int[][] fillImage(int[][] image, int i, int j, int oldColor, int newColor){
        if(i<0 || i >= image.length || j<0 || j>= image[0].length || image[i][j] != oldColor) return image;
        if(image[i][j] == oldColor) image[i][j] = newColor;
        fillImage(image, i+1, j, oldColor, newColor);
        fillImage(image, i-1, j, oldColor, newColor);
        fillImage(image, i, j+1, oldColor, newColor);
        fillImage(image, i, j-1, oldColor, newColor);
        return image;
    }
}