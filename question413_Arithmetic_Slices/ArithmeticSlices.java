package zhang.algorithm.leetcode.question413_Arithmetic_Slices;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 16/10/16
 * Time: 下午2:20
 * To change this template use File | Settings | File Templates.
 */
public class ArithmeticSlices {
    /**
     * 开始没有理解题意
     * 1, 3, 5, 7, 9, 2, 4, 6, 8, 11, 12 => 9
     * 中间需要连续的, 所以1、5、9不算, 这样的话,就简单多了。
     * <p>
     * <strong>result of test:</strong>
     * 15 / 15 test cases passed
     * Status: Accepted
     * Runtime: 2 ms
     *
     * @param A
     * @return
     */
    public int numberOfArithmeticSlices(int[] A) {
        int cur = 0;
        int len = 1;
        int dis = 0;
        int total = 0;
        while (cur < A.length - 1) {
            int tmp = A[cur + 1] - A[cur];
            if (dis != tmp) {
                dis = tmp;
                //calculate the total number of slices
                if (len >= 3) {
                    int n = len - 3 + 1;
                    total += (n + 1) * n / 2;
                }
                len = 1;
            }
            len++;
            cur++;
        }

        if (len >= 3) {
            int n = len - 3 + 1;
            total += (n + 1) * n / 2;
        }
        return total;
    }

    public static void main(String[] args) {
        ArithmeticSlices test = new ArithmeticSlices();
        int[] A = {1, 2, 3, 4};
        System.out.println(test.numberOfArithmeticSlices(A));
    }
}
