package zhang.algorithm.leetcode.question221_Maximal_Square;

import zhang.algorithm.modelUtil.Array.ArrayTool;

/**
 * Created by IntelliJ IDEA.
 * User: zhang_MacPro
 * Date: 16/8/2
 * Time: 下午4:01
 * To change this template use File | Settings | File Templates.
 */
public class MaximalSquare {
    /**
     * find the max square
     * 1 0 1 0 0
     * 1 0 1 1 1
     * 1 1 1 1 1
     * 1 0 0 1 0
     * <p>
     * this problem I do not use any algorithm design, only method of violence
     * But this problem is tagged as dynamic programming, so how can I do in this way?
     * question of 85 that Maximal Rectangle is more hard
     * <p>
     * <strong>result of test:</strong><br/>
     * 67 / 67 test cases passed
     * Status: Accepted
     * Runtime: 8 - 10 ms, bit 97.44 - 88.76%
     *
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        int maxLen = 0;
        for (int i = 0; i < matrix.length - maxLen; i++) {
            for (int j = 0; j < matrix[0].length - maxLen; j++) {
                int cur = 0;
                while (canExtend(matrix, i, j, cur)) cur++;
                maxLen = Math.max(maxLen, cur);
            }
        }
        return maxLen * maxLen;
    }

    private boolean canExtend(char[][] matrix, int x, int y, int len) {
        if (len == 0) return matrix[x][y] == '1' ? true : false;
        if (x + len >= matrix.length || y + len >= matrix[0].length) return false;
        for (int i = 0; i <= len; i++) {
            if (matrix[x + len][y + i] != '1') return false;
        }
        for (int i = 0; i <= len; i++) {
            if (matrix[x + i][y + len] != '1') return false;
        }
        return true;
    }

    /**
     * use the method of dynamic programming
     * <p>
     * <strong>result of test:</strong><br/>
     * 67 / 67 test cases passed
     * Status: Accepted
     * Runtime: 12 - 13 ms, bit 80.37%
     *
     * @param matrix
     * @return
     */
    public int maximalSquare2(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;

        int m = matrix.length;
        int n = matrix[0].length;

        int[][] maxdp = new int[m][n];
        int maxlen = 0;

        for (int i = 0; i < m; i++)
            if (matrix[i][0] == '1') {
                maxdp[i][0] = 1;
                maxlen = 1;
            }
        for (int j = 0; j < n; j++)
            if (matrix[0][j] == '1') {
                maxdp[0][j] = 1;
                maxlen = 1;
            }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '1') {
                    int temp = Math.min(Math.min(maxdp[i - 1][j - 1], maxdp[i - 1][j]), maxdp[i][j - 1]);
                    maxdp[i][j] = temp + 1;
                    if (maxdp[i][j] > maxlen) maxlen = maxdp[i][j];
                }
            }
        }

        return maxlen * maxlen;
    }

    public static void main(String[] args) {
        String[] strs = {
                "00010111",
                "01100101",
                "10111101",
                "00010000",
                "00100010",
                "11100111",
                "10011001",
                "01001100",
                "10010000"
        };
        MaximalSquare test = new MaximalSquare();
        System.out.println(test.maximalSquare(ArrayTool.string2Char(strs)));
    }
}
