package zhang.algorithm.leetcode.question372_Super_Pow;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 16/9/1
 * Time: 下午10:39
 * To change this template use File | Settings | File Templates.
 */
public class SuperPow {

    /**
     * straight and narrow
     * <p>
     * <strong>result of test:</strong>
     * 54 / 54 test cases passed
     * Status: Accepted
     * Runtime: 6 ms, bit 84.70%
     *
     * @param a
     * @param b
     * @return
     */
    public int superPow(int a, int[] b) {
        int res = 1;
        a %= 1337;  //if the a is very big

        for (int i = b.length - 1; i >= 0; i--) {
            for (int j = 0; j < b[i]; j++) {
                res *= a;
                res %= 1337;
            }

            int temp = 0;
            for (int j = 0; j < 3; j++) {
                a *= a;
                a %= 1337;
                if (j == 0) temp = a;
            }
            a = a * temp % 1337;
        }
        return res;
    }

    public static void main(String[] args) {
        SuperPow test = new SuperPow();
        int a = 2147483647;
        int[] b = {2, 0, 0};
        System.out.println(test.superPow(a, b));
    }
}
