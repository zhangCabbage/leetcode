package zhang.algorithm.leetcode.question343_Integer_Break;

import zhang.algorithm.modelUtil.ZhangUtil;

/**
 * Created by IntelliJ IDEA.
 * User: zhang_MacPro
 * Date: 16/8/6
 * Time: 下午4:07
 * To change this template use File | Settings | File Templates.
 */
public class IntegerBreak {
    /**
     * the constant number break into several number and find the max multiple of those numbers
     * I think that the numbers should difference the less. so I do like this.
     * although this place it is more faster than dp method
     * but it time complexity is O(n^2)
     * <p>
     * <strong>result of test:</strong>
     * 50 / 50 test cases passed
     * Status: Accepted
     * Runtime: 0 ms, bit 39.81%
     *
     * @param n
     * @return
     */
    public long integerBreak(int n) {
        long maxMult = 1;

        int part = 2;
        while (true) {
            int div = n / part;
            int mod = n % part;
            long multi = 1;
            for (int i = 0; i < mod; i++) {
                multi *= (div + 1);
            }
            for (int i = 0; i < part - mod; i++) {
                multi *= div;
            }
            maxMult = Math.max(multi, maxMult);
            if (div == 1) break;
            part++;
        }
        return maxMult;
    }

    /**
     * use the dp method to solve this problem.
     * the second way is better than first one.
     * one number that > 4 only can break into 2 or 3!
     *
     * @param n
     * @return
     */
    public long integerBreak2(int n) {
        if (n < 4) return n - 1;
        int[] res = new int[n + 1];
        res[2] = 2;
        res[3] = 3;
        for (int i = 4; i <= n; i++) {
            res[i] = Math.max(res[i - 2] * 2, res[i - 3] * 3);
        }

        return res[n];
    }

    /**
     * <strong>result of test:</strong>
     * 50 / 50 test cases passed
     * Status: Accepted
     * Runtime: 1 ms, bit 28.65%
     *
     * @param n
     * @return
     */
    public long integerBreak3(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        if (n == 4) return 4;
        return (long) 3 * (Math.max(n - 3, integerBreak(n - 3)));
    }

    /**
     * why can do like this? 相当于动态规划的进一步优化
     * reference: [【LeetCode 第 343 题 (Integer Break)】](http://blog.csdn.net/liyuanbhu/article/details/51198124)
     * <p>
     * <strong>result of test:</strong>
     * 50 / 50 test cases passed
     * Status: Accepted
     * Runtime: 0 ms
     *
     * @param n
     * @return
     */
    public long integerBreak4(int n) {
        if (n < 4) return n - 1;
        long res = 1;
        while (n > 2) {//看n包含多少个3,把他们相乘,直到n<=2
            res *= 3;
            n -= 3;
        }
        if (n == 1) res = (res / 3) * 4;//除3余1，把其中的一个3加1变为4再相乘
        if (n == 2) res = res * 2;//除3余2,则可直接把2与res相乘

        return res;
    }

    public static void main(String[] args) {
        IntegerBreak test = new IntegerBreak();
        int n = 113; //if n > 115, the result is bigger than long limit
        ZhangUtil.setStartTime();
        System.out.println(test.integerBreak(n));
        System.out.println("方法1 --> " + ZhangUtil.getIntervalTime());

        ZhangUtil.setStartTime();
        System.out.println(test.integerBreak3(n));
        System.out.println("方法2 --> " + ZhangUtil.getIntervalTime());

        ZhangUtil.setStartTime();
        System.out.println(test.integerBreak4(n));
        System.out.println("方法3 --> " + ZhangUtil.getIntervalTime());

//        n = 100000;
//        2145452032
//        方法1 --> 1926ms
//        2127749120
//        方法2 --> 1232ms
    }
}
