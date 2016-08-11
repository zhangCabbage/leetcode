package zhang.algorithm.leetcode.question263_Ugly_Number;

/**
 * Created by IntelliJ IDEA.
 * User: zhang_MacPro
 * Date: 16/8/11
 * Time: 上午10:33
 * To change this template use File | Settings | File Templates.
 */
public class UglyNumber {
    /**
     * <strong>result of test:</strong><br/>
     * 1012 / 1012 test cases passed
     * Status: Accepted
     * Runtime: 3 ms, bit 3.29%
     *
     * @param num
     * @return
     */
    public boolean isUgly(int num) {
        if (num == 0) return false;
        if (num == 1) return true;
        int[] primes = {2, 3, 5};
        int i = 0;
        while (num != 1 && i < primes.length) {
            while (num % primes[i] == 0) {
                num /= primes[i];
            }
            if (num == 1) return true;
            i++;
        }
        return false;
    }

    /**
     * <strong>result of test:</strong><br/>
     * 1012 / 1012 test cases passed
     * Status: Accepted
     * Runtime: 2 ms, bit 21.36%
     *
     * @param num
     * @return
     */
    public boolean isUgly2(int num) {
        if (num == 0) return false;
        if (num == 1) return true;
        while (num % 2 == 0) num >>= 1;
        while (num % 3 == 0) num /= 3;
        while (num % 5 == 0) num /= 5;
        return num == 1;
    }
}
