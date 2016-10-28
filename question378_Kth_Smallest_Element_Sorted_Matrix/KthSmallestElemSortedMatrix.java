package zhang.algorithm.leetcode.question378_Kth_Smallest_Element_Sorted_Matrix;

import java.util.PriorityQueue;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 16/10/28
 * Time: 下午3:54
 * To change this template use File | Settings | File Templates.
 */
public class KthSmallestElemSortedMatrix {
    /**
     * The tag of this problem is Binary Search and Heap
     * <p>
     * 85 / 85 test cases passed
     * Status: Accepted
     * Runtime: 36 - 38 ms, bit 32.8% - 36.20%
     *
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;  //行
        int n = matrix[0].length;  //列

        boolean[][] isUsed = new boolean[m][n];
        PriorityQueue<Point> queue = new PriorityQueue<>();
        queue.add(new Point(0, 0, matrix[0][0]));
        int count = 1;
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            if (count++ == k) return point.val;

            if (point.i != m - 1 && !isUsed[point.i + 1][point.j]) {
                queue.add(new Point(point.i + 1, point.j, matrix[point.i + 1][point.j]));
                isUsed[point.i + 1][point.j] = true;
            }

            if (point.j != n - 1 && !isUsed[point.i][point.j + 1]) {
                queue.add(new Point(point.i, point.j + 1, matrix[point.i][point.j + 1]));
                isUsed[point.i][point.j + 1] = true;
            }
        }

        return 0;
    }

    /**
     * 相似的思想, 改进算法
     * 85 / 85 test cases passed
     * Status: Accepted
     * Runtime: 28 - 31 ms, bit 49.51% - 60.52%
     *
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest2(int[][] matrix, int k) {
        int m = matrix.length;  //行
        int n = matrix[0].length;  //列

        PriorityQueue<Point> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) queue.offer(new Point(0, i, matrix[0][i]));
        for (int i = 0; i < k - 1; i++) {
            Point point = queue.poll();
            if (point.i == m - 1) continue;
            queue.offer(new Point(point.i + 1, point.j, matrix[point.i + 1][point.j]));
        }

        return queue.poll().val;
    }

    class Point implements Comparable<Point> {
        int i;
        int j;
        int val;

        public Point(int i, int j, int value) {
            this.i = i;
            this.j = j;
            this.val = value;
        }

        @Override
        public int compareTo(Point point) {
            return this.val - point.val;
        }
    }

    public static void main(String[] args) {
        KthSmallestElemSortedMatrix test = new KthSmallestElemSortedMatrix();
        int[][] matrix = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        int k = 9;
        System.out.println(test.kthSmallest(matrix, k));
        System.out.println(test.kthSmallest2(matrix, k));

    }


}
