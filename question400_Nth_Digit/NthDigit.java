package zhang.algorithm.leetcode.question400_Nth_Digit;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 16/9/19
 * Time: 下午11:02
 * To change this template use File | Settings | File Templates.
 */
public class NthDigit {
    /**
     * long time to thought, but i still can not has a clear good way to deal with it.
     * 通过转换成string类型来获取结果
     * Worthy of study:
     * 1) the first way use 'n -= 1' to change sum to product, so avoid sum the total
     * 2) parse int to str that make get the index number is more easy.
     * <p>
     * 70 / 70 test cases passed
     * Status: Accepted
     * Runtime: 8 ms, bit 14.15%
     *
     * @param n
     * @return
     */
    public int findNthDigit(int n) {
        n -= 1;
        int first = 1;
        int digits = 1;
        while (n / (9 * first * digits) >= 1) {
            n -= (9 * first * digits);
            first *= 10;
            digits++;
        }
        return (first + n / digits + "").charAt(n % digits) - '0';
    }

    /**
     * the original way the some body's thought, it still good.
     * 1000000000 => 1
     * <p>
     * 70 / 70 test cases passed
     * Status: Accepted
     * Runtime: 6 ms, bit 39.39%
     *
     * @param n
     * @return
     */
    public int findNthDigit2(int n) {
        if (n < 1) return 0;
        if (n < 10) return n;

        int digits = 1;
        long base = 9;  //attention please that base is long type.
        int before = 0;  //before is the count number before target
        while (n > digits * base) {
            before += base;
            n -= base * digits;
            base *= 10;
            digits++;
        }
        int target = before + ((n + digits - 1) / digits);
        int offset = (n % digits == 0) ? 0 : digits - (n % digits);
        while (offset > 0) {
            target /= 10;
            offset--;
        }
        return target % 10;
    }

    public static void main(String[] args) {
        NthDigit test = new NthDigit();
        int n = 1000000000;
        System.out.println(test.findNthDigit(n));
        System.out.println(test.findNthDigit2(n));
    }
}
