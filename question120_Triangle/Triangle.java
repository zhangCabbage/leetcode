package zhang.algorithm.leetcode.question120_Triangle;

import java.util.Arrays;
import java.util.List;

/**
 * Created by zhang_zack on 16/6/22.
 */
public class Triangle {
    /**
     * 查找最短长度路径,但是使用递归的方法,结果超时
     * <p>
     * Submission Result: Time Limit Exceeded
     *
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        return recursiveFind(triangle, 1, 0, triangle.get(0).get(0));
    }

    private int recursiveFind(List<List<Integer>> triangle, int level, int index, int sum) {
        if (level == triangle.size()) return sum;
        int left = recursiveFind(triangle, level + 1, index, sum + triangle.get(level).get(index));
        int right = recursiveFind(triangle, level + 1, index + 1, sum + triangle.get(level).get(index + 1));
        return left < right ? left : right;
    }

    /**
     * Bonus point:
     * if you are able to do this using only O(n) extra space
     * where n is the total number of rows in the triangle.
     * <p>
     * here I thought that to use the viterbi Algorithm, but it use the extra space is the last row length.
     * so I see hint: Dynamic Programing
     * It's my fault. Because of the special of this list triangle, so it can do like that.
     * <p>
     * And this place viterbi is Dynamic Programing
     * <p>
     * <strong>result of test:</strong><br/>
     * 43 / 43 test cases passed<br/>
     * Status: Accepted<br/>
     * Runtime: 4 ms, bit 68.21%<br/>
     *
     * @param triangle
     * @return
     */
    public int minimumTotal2(List<List<Integer>> triangle) {
        int len = triangle.size();
        if (len == 0) return 0;
        int[] pathSum = new int[len + 1];//start and end index is not to use
        Arrays.fill(pathSum, Integer.MAX_VALUE);
        pathSum[1] = 0;

        for (int i = 1; i <= len; i++) {
            for (int k = i; k > 0; k--) {
                pathSum[k] = Math.min(pathSum[k - 1], pathSum[k]) + triangle.get(i - 1).get(k - 1);
            }
        }

        int min = pathSum[0];
        for (int i = 1; i <= len; i++) {
            if (pathSum[i] < min) {
                min = pathSum[i];
            }
        }
        return min;
    }

}
