package zhang.algorithm.leetcode.question279_Perfect_Squares;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 16/12/1
 * Time: 下午7:45
 * To change this template use File | Settings | File Templates.
 */
public class PerfectSquares {

    //-------------------------------------------------------------------------------------
    //dynamic programming
    //-------------------------------------------------------------------------------------

    /**
     * I have the feel of using dp, but I think a lot time can not to deal with it.
     * Then I see the tag of this problem is [Dynamic programming]、[BFS]、[Math].
     * At the time when I almost want to give up, I deal with it.(8:20pm)
     * <p>
     * 600 / 600 test cases passed.
     * Status: Accepted
     * Runtime: 1499 ms, bit 0.04%(WoCao, 从没有做过这么低的, 吓死宝宝了)
     * <p>
     * 不管我用square这种改进, 还是直接使用
     * int tmp = (int) Math.sqrt(i);
     * if (tmp * tmp == i) dp[i] = 1;
     * 改进效果都不大
     *
     * @param n
     * @return
     */
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        int square = 1;
        for (int i = 1; i < dp.length; i++) {
            if (square == i / square) {
                dp[i] = 1;
                square++;
            } else {
                dp[i] = Integer.MAX_VALUE;
                for (int j = 1; j <= i / 2; j++)
                    dp[i] = Math.min(dp[i], dp[j] + dp[i - j]);
            }
        }

        return dp[n];
    }

    /**
     * 600 / 600 test cases passed.
     * Status: Accepted
     * Runtime: 110 ms, bit 27.05%
     *
     * @param n
     * @return
     */
    public int numSquares2(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
            //For each i, it must be the sum of some number (i - j*j) and a perfect square number (j*j).
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        return dp[n];
    }

    List<Integer> dp = new ArrayList<>();

    /**
     * There are so many "large" test cases,
     * then we can keep data between test cases rather than recomputing from scratch all the time
     * so we can call this dp way is "Static DP"
     * <p>
     * 这里查找用的比插入删除多, 所以用 ArrayList 比 LinkedList 快
     * if use LinkedList Time Limit Exceeded.
     * <p>
     * 600 / 600 test cases passed.
     * Status: Accepted
     * Runtime: 91 ms, bit 43.28%
     *
     * @param n
     * @return
     */
    public int numSquares3(int n) {
        dp.add(0);
        while (dp.size() <= n) {
            int m = dp.size();
            int count = Integer.MAX_VALUE;
            for (int i = 1; i * i <= m; i++) {
                count = Math.min(count, dp.get(m - i * i) + 1);
            }
            dp.add(count);
        }

        return dp.get(n);
    }

    //-------------------------------------------------------------------------------------
    //Mathematical Solution
    //-------------------------------------------------------------------------------------

    /**
     * 这道题告诉我们智商与搬砖的区别。
     * [Lagrange's Four Square theorem] ==> p = a^2 + b^2 + c^2 + d^2, p is natural number.
     * [Legendre's three-square theorem] ==> n = x^2 + y^2 + z^2, only if n is not the form of n = 4^a * (8b + 7)
     * [Fermat's theorem] ==> p = x^2 + y^2, only if p = (4a + 1)
     * =>
     * if n = 4^a * (8b + 7) ==> n = a^2 + b^2 + c^2 + d^2
     * <p>
     * 600 / 600 test cases passed.
     * Status: Accepted
     * Runtime: 3 ms, bit 97.43%
     *
     * @param n
     * @return
     */
    public int numSquares4(int n) {
        if (isSquare(n)) return 1;

        while ((n & 3) == 0) { //n % 4 == 0
            n >>= 2;
        }
        //TODO
        //reference: https://discuss.leetcode.com/topic/23808/o-sqrt-n-in-ruby-c-c/2
        //=> n % 8 == 7, why? I can not get it.
        if ((n & 7) == 7) return 4;

        int sqrt = (int) Math.sqrt(n);
        for (int i = 1; i <= sqrt; i++) {
            if (isSquare(n - i * i)) return 2;
        }

        return 3;
    }

    /**
     * Judge n is a prefect square number.
     *
     * @param n
     * @return
     */
    private boolean isSquare(int n) {
        int tmp = (int) Math.sqrt(n);
        return tmp * tmp == n;
    }

    //-------------------------------------------------------------------------------------
    //Breadth-First Search
    //-------------------------------------------------------------------------------------

    /**
     * TODO
     * https://discuss.leetcode.com/topic/24255/summary-of-4-different-solutions-bfs-dp-static-dp-and-mathematics/2
     *
     * @param n
     * @return
     */
    public int numSquares5(int n) {


        return 0;
    }

    public static void main(String[] args) {
        PerfectSquares test = new PerfectSquares();
        int n = 117;
        System.out.println(test.numSquares(n));
        System.out.println(test.numSquares2(n));
        System.out.println(test.numSquares3(n));
        System.out.println(test.numSquares4(n));
    }
}
