package zhang.algorithm.leetcode.question342_Power_of_Four;

/**
 * Created by IntelliJ IDEA.
 * User: zhang_MacPro
 * Date: 16/8/3
 * Time: 上午10:28
 * To change this template use File | Settings | File Templates.
 */
public class PowerOfFour {
    /**
     * this problem ask we to solve it without loops/recursion
     * How to do in this way ??
     * <p>
     * <strong>result of test:</strong><br/>
     * 1060 / 1060 test cases passed
     * Status: Accepted
     * Runtime: 2 ms, bit 22.67%
     *
     * @param num
     * @return
     */
    public boolean isPowerOfFour(int num) {
        if (num == 0 || num == Integer.MIN_VALUE) return false;
        if ((num & (num - 1)) == 0) {
            int count = 0;
            while (num != 1) {
                num >>= 1;
                count++;
            }
            if (count % 2 == 0) return true;
        }
        return false;
    }

    /**
     * the same result, 2ms
     *
     * @param num
     * @return
     */
    public boolean isPowerOfFour2(int num) {
        return num > 0 && (num & (num - 1)) == 0 && (num - 1) % 3 == 0;
    }

    /**
     * the same result, 2ms
     *
     * @param num
     * @return
     */
    public boolean isPowerOfFour3(int num) {
        if (num < 1) return false;
        int sqrt = (int) Math.sqrt(num);
        return (num & (num - 1)) == 0 && num - sqrt * sqrt == 0;
    }

    /**
     * use the limit of int value to solve this problem is very nice!
     *
     * @param num
     * @return
     */
    public boolean isPowerOfFour4(int num) {
        if (num < 1) return false;
        return (num & (num - 1)) == 0 && (num & 0x55555555) != 0;
    }

    /**
     * the same result, 2ms
     *
     * @param num
     * @return
     */
    public boolean isPowerOfFour5(int num) {
        return num > 0 && (num & (num - 1)) == 0 && Integer.numberOfTrailingZeros(num) % 2 == 0;
    }
}
