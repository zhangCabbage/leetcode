package zhang.algorithm.leetcode.question504_Base_7;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 17/4/22
 * Time: 下午4:53
 * To change this template use File | Settings | File Templates.
 */
public class Base7 {
    /**
     * 241 / 241 test cases passed.
     * Status: Accepted
     * Runtime: 15 ms, bit 97.67%
     *
     * @param num
     * @return
     */
    public String convertToBase7(int num) {
        int res = 0;
        int radix = 1;
        while (num != 0) {
            res = (num % 7) * radix + res;
            radix *= 10;
            num /= 7;
        }
        return String.valueOf(res);
    }

    public static void main(String[] args) {
        Base7 test = new Base7();
    }
}
