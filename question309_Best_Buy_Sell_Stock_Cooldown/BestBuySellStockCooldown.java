package zhang.algorithm.leetcode.question309_Best_Buy_Sell_Stock_Cooldown;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 16/11/4
 * Time: 下午8:05
 * To change this template use File | Settings | File Templates.
 */
public class BestBuySellStockCooldown {
    /**
     * The tag of this problem is dynamic programming.
     * 没有想到任何好的解决方案
     * <p>
     * 只考虑买或者休息
     * profit1[i] --> max profit on day i if I sell
     * profit2[i] --> max profit on day i if I do nothing
     * <p>
     * profit1[i+1] means I must sell on day i+1
     * # If I just sold on day i, then I have to buy again on day i and sell on day i+1
     * # If I did nothing on day i, then I have to buy today and sell today on day i+1
     * <p>
     * ==>
     * <p>
     * profit1[i+1] = max(profit1[i] + prices[i+1] - prices[i], profit2[i])
     * profit2[i+1] = max(profit1[i], profit2[i])
     * <p>
     * 212 / 212 test cases passed.
     * Status: Accepted
     * Runtime: 2 ms, bit 36.30%
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int profit1 = 0, profit2 = 0;
        for (int i = 1; i < prices.length; i++) {
            int copy = profit1;
            profit1 = Math.max(profit1 + prices[i] - prices[i - 1], profit2);
            profit2 = Math.max(copy, profit2);
        }
        return Math.max(profit1, profit2);
    }

    /**
     * 采用有限状态机的方式来分析此题, 从而得出动态规划的方法。
     * 三种状态: rest、buy、sell
     * <p>
     * 212 / 212 test cases passed.
     * Status: Accepted
     * Runtime: 2 ms
     *
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int buy = -prices[0], sell = 0, rest = 0;
        for (int i = 1; i < prices.length; i++) {
            int tmp = buy;
            buy = Math.max(rest - prices[i], buy);
            rest = Math.max(rest, sell);
            sell = tmp + prices[i];
        }
        return Math.max(buy, Math.max(sell, rest));
    }


    public static void main(String[] args) {
        BestBuySellStockCooldown test = new BestBuySellStockCooldown();
        int[] prices = {};
        System.out.println(test.maxProfit(prices));
    }
}
