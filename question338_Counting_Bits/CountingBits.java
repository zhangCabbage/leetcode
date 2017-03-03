package zhang.algorithm.leetcode.question338_Counting_Bits;

import zhang.algorithm.modelUtil.Array.ArrayTool;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 16/10/22
 * Time: 下午8:48
 * To change this template use File | Settings | File Templates.
 */
public class CountingBits {
    /**
     * 15 / 15 test cases passed
     * Status: Accepted
     * Runtime: 4 ms, bit 27.68%
     * 我擦, 我就随便一腿公式, 发现竟然神不知鬼不觉的用了动态规划, 感觉自己好屌的样子。
     * 太TM的侥幸了。我这榆木脑袋
     *
     * @param num
     * @return
     */
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            if (i < 2) res[i] = i;
            else if (i < 4) res[i] = i - 1;
            else res[i] = res[i >> 2] + res[i & 3];
        }

        return res;
    }

    /**
     * 更好的动态规划的方式!!
     * 15 / 15 test cases passed
     * Status: Accepted
     * Runtime: 3 ms, bit 42.6%
     *
     * @param num
     * @return
     */
    public int[] countBits2(int num) {
        int[] res = new int[num + 1];
        res[0] = 0;
        int max = 0;
        for (int i = 1; i <= num; i++) {
            if ((i & (i - 1)) == 0) { // the power of 2
                res[i] = 1;
                max = i;
            } else {
                res[i] = res[max] + res[i - max];
            }
        }

        return res;
    }

    public static void main(String[] args) {
        CountingBits test = new CountingBits();
        int num = 2;
        ArrayTool.printArray(test.countBits(num));
    }
}
