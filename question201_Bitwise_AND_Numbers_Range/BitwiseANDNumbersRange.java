package zhang.algorithm.leetcode.question201_Bitwise_AND_Numbers_Range;

import zhang.algorithm.modelUtil.BitManipultion.BitTool;

/**
 * Created by IntelliJ IDEA.
 * User: zhang_MacPro
 * Date: 16/7/24
 * Time: 下午3:51
 * To change this template use File | Settings | File Templates.
 */
public class BitwiseANDNumbersRange {
    /**
     * first method left and right double pointer to traversal
     * this way is only O(n/2) time complexity.
     * But always Time Limit Exceeded.
     * <p>
     * second method that find the high one bit position to see whether
     * the distance of the min m to the max n is over number of bit position
     * But I always think that below way can be more faster space.
     * I think My way is better than the follow two way, when big data test.
     * But it is not stable.
     * <p>
     * <strong>result of test:</strong><br/>
     * 8266 / 8266 test cases passed
     * Status: Accepted
     * Runtime: 8 - 9 ms, bit 60.88 - 20.61%
     *
     * @param m
     * @param n
     * @return
     */
    public int rangeBitwiseAnd(int m, int n) {
        if (m == n) return m;

        int res = 0;
        int highOneM = res;
        int highOneN = res;

        while (highOneM == highOneN) {
            res |= highOneM;
            highOneM = findHighOne(m);
            highOneN = findHighOne(n);
            m ^= highOneM;
            n ^= highOneN;
        }

        return res;
    }

    private int findHighOne(int num) {
        int pre = 0;
        while (num != 0) {
            pre = num;
            num &= (num - 1);
        }
        return pre;
    }

    /**
     * the result is same as me(9ms bit 20.61%)
     * But the logic is very necessary to know.
     * <p>
     * Nice !!
     *
     * @param m
     * @param n
     * @return
     */
    public int rangeBitwiseAnd2(int m, int n) {
        while (n - 1 >= m) n &= n - 1;
        return n;
    }

    /**
     * If m != n, then n - m >= 1. So the last bit must be 0(think about the bit operation)!!
     * the result is same as me(9ms bit 20.61%)
     * if m != n, it should run the max bit of m and n
     *
     * @param m
     * @param n
     * @return
     */
    public int rangeBitwiseAnd3(int m, int n) {
        int count = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            count++;
        }
        return m << count;
    }

    /**
     * @param m
     * @param n
     * @return
     */
    public int rangeBitwiseAnd4(int m, int n) {
        int res = 0;
        int highM = Integer.highestOneBit(m);
        int highN = Integer.highestOneBit(n);
        if (highM == 0) return res;
        if (highM == highN)
            res = highM | rangeBitwiseAnd4(m ^ highM, n ^ highN);
        return res;
    }

    public static void main(String[] args) {
        BitwiseANDNumbersRange test = new BitwiseANDNumbersRange();
        int m = 600000000;
        int n = 600000000;
        BitTool.showBinary(m);
        BitTool.showBinary(n);
        BitTool.showBinary(test.rangeBitwiseAnd(m, n));
        BitTool.showBinary(test.rangeBitwiseAnd4(m, n));
    }
}
