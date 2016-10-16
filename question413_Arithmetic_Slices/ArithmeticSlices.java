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
     * math method to deal with this problem
     * <strong>result of test:</strong>
     * 15 / 15 test cases passed
     * Status: Accepted
     * Runtime: 2 ms
     * <p>
     * why here has the tag of dynamic programming?
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

    /**
     * second method that use the dynamic programing
     * <p>
     * when 1 2 3 --> (1, 2, 3) increment is 3 - 3 + 1 = 1
     * when 1 2 3 4 --> (2, 3, 4), (1, 2, 3,4), increment is 4 - 3 + 1 = 2
     * when 1 2 3 4 5 --> (3, 4, 5), (2, 3, 4, 5), (1, 2, 3, 4, 5), increment is 5 - 3 + 1 = 3.
     * <p>
     * so the first step is to loop and store the length of arithmetic.
     * second loop is to added up all the increments.
     * <p>
     * e.g. [1 2 3 4 0 0 7 8 9]
     * first loop [0 0 3 4 0 0 0 0 3];
     * second loop sum = (3 - 3 + 1) + (4 - 3 + 1) + 0 + 0 + 0 + 0 + (3 - 3 + 1) = 4
     *
     * @param A
     * @return
     */
    public int numberOfArithmeticSlices2(int[] A) {
        int[] count = new int[A.length];
        for (int i = 2; i < A.length; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                if (count[i - 1] == 0)
                    count[i] = 3;
                else
                    count[i] = count[i - 1] + 1;
            }
        }
        int sum = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                sum += (count[i] - 3 + 1);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        ArithmeticSlices test = new ArithmeticSlices();
        int[] A = {1, 2, 3, 4};
        System.out.println(test.numberOfArithmeticSlices(A));
        System.out.println(test.numberOfArithmeticSlices2(A));
    }
}
