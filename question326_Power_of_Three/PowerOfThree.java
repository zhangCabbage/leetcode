package zhang.algorithm.leetcode.question326_Power_of_Three;

/**
 * Created by IntelliJ IDEA.
 * User: zhang_MacPro
 * Date: 16/8/3
 * Time: 上午10:26
 * To change this template use File | Settings | File Templates.
 */
public class PowerOfThree {
    /**
     * this problem ask we to solve it without loops/recursion
     * How to do in this way ??
     * <p>
     * <strong>result of test:</strong><br/>
     * 21038 / 21038 test cases passed
     * Status: Accepted
     * Runtime: 16 - 18 ms, bit 60.90 - 87.73%
     *
     * @param n
     * @return
     */
    public boolean isPowerOfThree(int n) {
        if (n < 1) return false;
        while (n != 1) {
            if (n % 3 == 0) {
                n = n / 3;
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * this way is very cruel!!
     * But it is not very fast, because operator of % in big number is slow.
     * <p>
     * <strong>result of test:</strong><br/>
     * 21038 / 21038 test cases passed
     * Status: Accepted
     * Runtime: 18 ms, bit 60.90%
     *
     * @param n
     * @return
     */
    public boolean isPowerOfThree2(int n) {
        int maxPower3 = 1162261467;
        return n > 0 && maxPower3 % n == 0;
    }

    /**
     * contain the process of compute the max of 3`th power in int。
     * <p>
     * <strong>result of test:</strong><br/>
     * 21038 / 21038 test cases passed
     * Status: Accepted
     * Runtime: 22 ms, bit 14.14%
     *
     * @param n
     * @return
     */
    public boolean isPowerOfThree3(int n) {
        if (n < 1) return false;
        int t = (int) Math.pow(3, (int) (Math.log(Integer.MAX_VALUE) / Math.log(3)));
        return t % n == 0;
    }

    private static int findMaxPower3() {
        for (int i = Integer.MAX_VALUE; i > 0; i--) {
            int temp = i;
            while (temp != 1) {
                if (temp % 3 == 0) temp /= 3;
                else break;
            }
            if (temp == 1) return i;
        }
        return 0;
    }

    public static void main(String[] args) {
        PowerOfThree test = new PowerOfThree();
        test.isPowerOfThree3(27);
    }
}
