package zhang.algorithm.leetcode.question258_Add_Digits;

/**
 * Created by IntelliJ IDEA.
 * User: zhang_MacPro
 * Date: 16/8/11
 * Time: 上午10:14
 * To change this template use File | Settings | File Templates.
 */
public class AddDigits {
    /**
     * <strong>result of test:</strong><br/>
     * 1101 / 1101 test cases passed
     * Status: Accepted
     * Runtime: 2 ms, bit 22.60%
     *
     * @param num
     * @return
     */
    public int addDigits(int num) {
        return num == 0 ? 0 : num % 9 == 0 ? 9 : num % 9;
    }
}
