package zhang.algorithm.leetcode.question231_Power_of_Two;

/**
 * Created by IntelliJ IDEA.
 * User: zhang_MacPro
 * Date: 16/8/3
 * Time: 上午9:42
 * To change this template use File | Settings | File Templates.
 */
public class PowerOfTwo {
    /**
     * <strong>result of test:</strong><br/>
     * 1108 / 1108 test cases passed
     * Status: Accepted
     * Runtime: 2 ms, bit 19.75%
     *
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n) {
        if (n < 1) return false;
        return (n & (n - 1)) == 0;
    }
}
