class Solution {
    public int findLongestChain(int[][] pairs) {
        if(pairs == null || pairs[0].length < 1) return 0;
        
        Arrays.sort(pairs, (a,b) -> a[1] - b[1]);
        int counter = 0;
        int previous = Integer.MIN_VALUE;
        
        for(int[] pair: pairs) {
            if(previous < pair[0]) {
                counter++;
                previous = pair[1];
            }        
        }
        
        return counter;
    }
}