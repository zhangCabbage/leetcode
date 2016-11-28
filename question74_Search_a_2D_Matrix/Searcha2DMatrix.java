package zhang.algorithm.leetcode.question74_Search_a_2D_Matrix;

/**
 * Created by zhang_zack on 16/5/27.
 * <p>
 * 这道题的题意真是TTM难懂了, 不说清楚, 查找target这个数在不在matrix这个矩阵中
 * 同时matrix矩阵有些特殊....
 */
public class Searcha2DMatrix {
    /**
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;//行
        int n = matrix[0].length;//列
        int start = 0;
        int end = m * n - 1;
        int mid;
        while (start <= end) {
            mid = (start + end) / 2;
            int[] position = getPosition(mid, n);
            if (matrix[position[0]][position[1]] == target) {
                return true;
            } else if (matrix[position[0]][position[1]] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }

    /**
     * 看index这个下标对应m*n矩阵中的下标
     *
     * @param index
     * @param n
     * @return
     */
    public int[] getPosition(int index, int n) {
        int[] position = new int[2];
        position[0] = index / n;
        position[1] = index % n;
        return position;
    }
}
