package zhang.algorithm.leetcode.question454_4sum_II;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: zhang_Lenovo
 * Date: 2017/7/27
 * Time: 21:39
 * To change this template use File | Settings | File Templates.
 */
public class Sum4_II {
    /**
     * 看到discuss中标题O(n^2), 但是没有看别人的代码，突然被想到了可以的解决方案！
     * <p>
     * 48 / 48 test cases passed.
     * Status: Accepted
     * Runtime: 169 ms, bit 79.93%
     *
     * @param A
     * @param B
     * @param C
     * @param D
     * @return
     */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                long sum = -1 * (A[i] + B[j]);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        int total = 0;
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                long sum = C[i] + D[j];
                total += map.getOrDefault(sum, 0);
            }
        }
        return total;
    }

    public static void main(String[] args) {

    }
}
