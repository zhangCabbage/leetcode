package zhang.algorithm.leetcode.question172_Factorial_Trailing_Zeroes;

/**
 * Created by IntelliJ IDEA.
 * User: zhang_MacPro
 * Date: 16/7/15
 * Time: 下午9:42
 * To change this template use File | Settings | File Templates.
 */
public class FactorialTrailingZeroes {
    /**
     * <strong>result of test:</strong><br/>
     * 502 / 502 test cases passed
     * Status: Accepted
     * Runtime: 2 ms, bit 3.39%
     *
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {
        int result = 0;
        while (n / 5 != 0) {
            result += n / 5;
            n /= 5;
        }
        return result;
    }
}
