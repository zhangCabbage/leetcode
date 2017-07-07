package zhang.algorithm.leetcode.question233_Number_of_Digit_One;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 17/7/7
 * Time: 下午4:41
 * To change this template use File | Settings | File Templates.
 */
public class NumOfDigitOne {
    /**
     * 递归的方法解决这个问题
     * <p>
     * 40 / 40 test cases passed.
     * Status: Accepted
     * Runtime: 1 ms, bit 3.71%
     *
     * @param n
     * @return
     */
    public int countDigitOne(int n) {
        if (n < 1) return 0;
        if (n < 10) return 1;
        int h = n, p = 0;
        while (h >= 10) {
            h /= 10;
            p++;
        }

        int base = (int) Math.pow(10, p);
        int remain = n % base;
        if (h == 1) {
            return countDigitOne(base - 1) + countDigitOne(remain) + remain + 1;
        } else {
            return countDigitOne(base - 1) * h + base + countDigitOne(remain);
        }
    }

    /**
     * 也可以不使用递归方法, 直接按位计算当前位1出现的次数
     * <p>
     * 40 / 40 test cases passed.
     * Status: Accepted
     * Runtime: 0 ms, bit 14.29%
     *
     * @param n
     * @return
     */
    public int countDigitOne_2(int n) {
        int ones = 0;
        for (long m = 1; m <= n; m *= 10) {
            // prefix = n / m, suffix = n % m
            ones += (n / m + 8) / 10 * m + (n / m % 10 == 1 ? n % m + 1 : 0);
        }
        return ones;
    }

    public static void main(String[] args) {
        NumOfDigitOne test = new NumOfDigitOne();
        System.out.println(test.countDigitOne(10));
    }
}
