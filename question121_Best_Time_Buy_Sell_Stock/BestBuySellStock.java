package zhang.algorithm.leetcode.question121_Best_Time_Buy_Sell_Stock;

/**
 * Created by zhang_zack on 16/6/23.
 */
public class BestBuySellStock {
    /**
     * we can easy deal this problem with using dynamic programming.<br/>
     * Without any difficulty<br/>
     * <p>
     * <strong>result of test:</strong><br/>
     * 200 / 200 test cases passed<br/>
     * Status: Accepted<br/>
     * Runtime: 1 ms, 94.59%<br/>
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int profit = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            profit = (prices[i] - min > profit) ? prices[i] - min : profit;
        }
        return profit;
    }

    public static void main(String[] args) {
        BestBuySellStock test = new BestBuySellStock();
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(test.maxProfit(prices));
    }
}
