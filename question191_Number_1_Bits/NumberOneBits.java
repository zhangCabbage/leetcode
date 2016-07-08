package zhang.algorithm.leetcode.question191_Number_1_Bits;

/**
 * Created by IntelliJ IDEA.
 * User: zhang_MacPro
 * Date: 16/7/8
 * Time: 下午9:33
 * To change this template use File | Settings | File Templates.
 */
public class NumberOneBits {
    /**
     * The beautify of programming
     * <p>
     * <strong>result of test:</strong><br/>
     * 600 / 600 test cases passed
     * Status: Accepted
     * Runtime: 2 ms, bit 13.01%
     *
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int num = 0;
        while (n != 0) {
            n &= n - 1;
            num++;
        }
        return num;
    }
}
