class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int minBuy = prices[0];
        for (int price : prices) {
            minBuy = Math.min(minBuy, price);
            profit = Math.max(profit, price - minBuy);
        }
        return profit;
    }
}