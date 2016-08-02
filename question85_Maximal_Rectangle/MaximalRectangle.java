package zhang.algorithm.leetcode.question85_Maximal_Rectangle;

/**
 * Created by IntelliJ IDEA.
 * User: zhang_MacPro
 * Date: 16/8/2
 * Time: 下午5:09
 * To change this template use File | Settings | File Templates.
 */
public class MaximalRectangle {
    /**
     * when change square to rectangle, it is sure has many things to consider make this problem hard.
     *
     * @param matrix
     * @return
     */
    public int maximalRectangle(char[][] matrix) {
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int tempW = 0;
                int tempH = 0;

                max = Math.max(max, tempH * tempW);
            }
        }
        return max;
    }

    private int canExtend(char[][] matrix, int x, int y, int w, int h) {
        if (w == 0) return matrix[x][y] == '1' ? 3 : 0;
        int res = 0;
        //high
        if (x + h < matrix.length) {
            for (int i = 0; i < w; i++) {
                if (matrix[x + h][y + i] != '1') {
                    res -= 1;
                    break;
                }
            }
            res += 1;
        }
        //width
        if (y + w < matrix[0].length) {
            for (int i = 0; i < h; i++) {
                if (matrix[x + i][y + w] != '1') {
                    res -= 2;
                    break;
                }
            }
            res += 2;
        }
        return res;
    }
}
