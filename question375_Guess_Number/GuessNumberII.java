package zhang.algorithm.leetcode.question375_Guess_Number;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 16/9/16
 * Time: 下午5:13
 * To change this template use File | Settings | File Templates.
 */
public class GuessNumberII {
    /**
     * this is a minimax problem that I have a feeling to use dynamic programming
     * the first way I thought is wrong that is like Over fitting in the Machine learning.
     * the follow discuss is very good.
     * [Discuss]:
     * https://discuss.leetcode.com/topic/53369/how-does-one-think-up-dp-solutions-for-these-types-of-problems
     * and this is a Minimax problem!!
     * <p>
     * 13 / 13 test cases passed
     * Status: Accepted
     * Runtime: 10 ms
     *
     * @param n
     * @return
     */
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 2][n + 2];
        //init
        for (int i = 1; i < n + 2; i++) {
            dp[i][i - 1] = 0;
        }

        for (int l = 1; l <= n - 1; l++) {
            // l is the len, l = 0 can not to calculate
            for (int i = 1; i <= n - l; i++) {
                int j = i + l;
                int min = Integer.MAX_VALUE;
                for (int k = i; k <= j; k++) {
                    min = Math.min(k + Math.max(dp[i][k - 1], dp[k + 1][j]), min);
                }
                dp[i][j] = min;
            }
        }

        return dp[1][n];
    }

    public static void main(String[] args) {
        GuessNumberII test = new GuessNumberII();
        int n = 10;
        System.out.println(test.getMoneyAmount(n));
    }
}
