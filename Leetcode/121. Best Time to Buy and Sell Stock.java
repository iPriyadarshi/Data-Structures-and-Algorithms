class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int minBP = Integer.MAX_VALUE;
        int profit = 0;
        for (int i = 0; i < n; i++) {
            int sellingPrice = prices[i];
            profit = Math.max(profit, sellingPrice - minBP);
            minBP = Math.min(minBP, sellingPrice);
        }
        return profit;
    }
}
