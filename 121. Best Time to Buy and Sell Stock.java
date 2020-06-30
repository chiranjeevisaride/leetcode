// Time - O(n) Space - O(1)
class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        return getMaxProfit(prices, 0, Integer.MAX_VALUE, 0);
    }
    
    public int getMaxProfit(int[] prices, int index, int minStockPrice, int maxDiff) {
        if(prices.length == index) {
            return maxDiff;
        }
         int earn =  prices[index] - minStockPrice;
         maxDiff = Math.max(earn, maxDiff);
         minStockPrice = Math.min(minStockPrice, prices[index]);
        return getMaxProfit(prices, ++index, minStockPrice, maxDiff);
    }
}

// Time - O(n) Space - O(1)
class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        return getMaxProfit(prices);
    }
    
    public int getMaxProfit(int[] prices) {
        int minStockPrice = Integer.MAX_VALUE, maxDiff = 0;
        for(int i = 0; i < prices.length; i++) {
            int earn =  prices[i] - minStockPrice;
            maxDiff = Math.max(earn, maxDiff);
            minStockPrice = Math.min(minStockPrice, prices[i]);
        }
        return maxDiff;
    }
}