package leetcode;
public class BestTimeBuySell {
    public static void main(String[] args) {
        System.out.println(new BestTimeBuySell().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(new BestTimeBuySell().maxProfit(new int[]{7, 6, 4, 3, 1}));
        System.out.println(new BestTimeBuySell().maxProfitEfficient(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(new BestTimeBuySell().maxProfitEfficient(new int[]{7, 6, 4, 3, 1}));
    }
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int currentProfit = prices[j] - prices[i];
                if (profit < currentProfit) {
                    profit = currentProfit;
                }
            }
        }
        return profit;
    }
    public int maxProfitEfficient(int[] prices) {
        int minPrice = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            profit = Math.max(profit, prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }
        return profit;
    }
}