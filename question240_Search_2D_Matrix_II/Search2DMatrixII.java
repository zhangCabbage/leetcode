package zhang.algorithm.leetcode.question240_Search_2D_Matrix_II;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 16/11/28
 * Time: 下午9:14
 * To change this template use File | Settings | File Templates.
 * =>
 * https://leetcode.com/problems/search-a-2d-matrix-ii/
 * =>
 * update
 * Date: 16/11/29
 * Time: 下午9:30
 */
public class Search2DMatrixII {
    //------------------------------------------------------------------
    //------------------------------------------------------------------

    /**
     * o(m * log(n)) => 还能否继续优化
     * <p>
     * 127 / 127 test cases passed.
     * Status: Accepted
     * Runtime: 14 ms, bit 47.53%
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        for (int i = 0; i < m; i++) {
            if (binarySearch(matrix[i], target)) return true;
        }
        return false;
    }

    private boolean binarySearch(int[] array, int target) {
        int l = 0, r = array.length - 1;
        while (l <= r) {
            int mid = l + (r - l >> 1);
            if (target > array[mid]) l = mid + 1;
            else if (target < array[mid]) r = mid - 1;
            else return true;
        }
        return false;
    }

    //------------------------------------------------------------------
    //if we look from top-right as root of a tree, this matrix look like a [binary search tree]
    //so we can solve it at O(m+n) time.
    //------------------------------------------------------------------

    /**
     * O(m+n) time complexity
     * reference: https://discuss.leetcode.com/topic/20064/my-concise-o-m-n-java-solution
     * 127 / 127 test cases passed.
     * Status: Accepted
     * Runtime: 14 ms
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix2(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) return false;
        int row = 0;
        int col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (target == matrix[row][col]) return true;
            else if (target > matrix[row][col]) row++;
            else col--;
        }
        return false;
    }

    public static void main(String[] args) {
        Search2DMatrixII test = new Search2DMatrixII();
        int[][] matrix = {{-5}};
        int target = -2;
        System.out.println(test.searchMatrix(matrix, target));
        System.out.println(test.searchMatrix2(matrix, target));
    }
}
