package zhang.algorithm.leetcode.question371_Sum_Two_Integers;

/**
 * Created by IntelliJ IDEA.
 * User: zhang_MacPro
 * Date: 16/7/6
 * Time: 下午10:26
 * To change this template use File | Settings | File Templates.
 */
public class SumTwoIntegers {

    /**
     * <strong>result of test:</strong><br/>
     * 13 / 13 test cases passed
     * Status: Accepted
     * Runtime: 0 ms, bit 6.2%
     * <p>
     * Very nice!!!
     * Review Time: 2017-03-03 12:01:44
     * Can not to think this method!
     *
     * @param a
     * @param b
     * @return
     */
    public int getSum(int a, int b) {
        while ((a & b) != 0) {
            int temp = a ^ b;
            b = (a & b) << 1;
            a = temp;
        }

        return a ^ b;
    }

    public static void main(String[] args) {
        SumTwoIntegers test = new SumTwoIntegers();
        System.out.println(test.getSum(20, 30));
    }
}
