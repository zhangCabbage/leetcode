package zhang.algorithm.leetcode.question122_Best_Time_Buy_Sell_Stock_II;

/**
 * Created by zhang_zack on 16/6/23.
 */
public class BestBuySellStockII {
    /**
     * The strategy of this problem is that when I see one is bigger, I sell right now.
     * <p>
     * <strong>result of test:</strong><br/>
     * 198 / 198 test cases passed<br/>
     * Status: Accepted<br/>
     * Runtime: 2 ms, only bit 12.04%. Did not expect such a bad result!<br/>
     * <p>
     * By see the discuss, I found that too many thought like I thought
     * But I can not find about other faster way to deal this problem.
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int profit = 0;
        if (prices.length < 2) return profit;
        int cur = prices[0];
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] > cur) {
                profit += (prices[i] - cur);
            }
            cur = prices[i];
        }

        return profit;
    }

    /**
     * different ideas!
     *
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int len = prices.length;
        if (len < 2) return 0;

        int maxp = 0;
        for (int i = 1; i < len; i++) {
            if (prices[i] > prices[i - 1]) maxp += prices[i] - prices[i - 1];
        }

        return maxp;
    }

    public static void main(String[] args) {
        BestBuySellStockII test = new BestBuySellStockII();
        int[] prices = {1, 2, 4, 6, 4, 5, 7};
        System.out.println(test.maxProfit(prices));
    }
}
