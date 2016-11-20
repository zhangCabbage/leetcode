package zhang.algorithm.leetcode.question452_Min_Arrows_Burst_Balloons;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 16/11/20
 * Time: 下午3:42
 * To change this template use File | Settings | File Templates.
 */
public class MinArrowsBurstBalloons {
    /**
     * 有过使用并查集和线段树的想法, 但是由于范围没有确定, 所以这个想法被我否决了!
     * 之后又错误理解题意, 码了下面的代码
     * <p>
     * 43 / 43 test cases passed.
     * Status: Accepted
     * Runtime: 40-49 ms, bit 93.31%
     *
     * @param points
     * @return
     */
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] point1, int[] point2) {
                if (point1[0] != point2[0]) return point1[0] - point2[0];
                return point1[1] - point2[1];
            }
        });
        int count = 0;
        int max = Integer.MIN_VALUE;
        for (int[] invertal : points) {
            if (max == Integer.MIN_VALUE || invertal[0] > max) {
                max = invertal[1];
                count++;
            } else max = Math.min(max, invertal[1]);
        }

        return count;
    }

    public static void main(String[] args) {
        MinArrowsBurstBalloons test = new MinArrowsBurstBalloons();
        int[][] points = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        System.out.println(test.findMinArrowShots(points));
    }
}
