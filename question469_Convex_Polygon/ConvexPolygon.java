package zhang.algorithm.leetcode.question469_Convex_Polygon;

import zhang.algorithm.modelUtil.Array.ArrayTool;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 16/12/4
 * Time: 上午10:47
 * To change this template use File | Settings | File Templates.
 */
public class ConvexPolygon {
    /**
     * [Wrong]
     * 注意: points的是顺序的.
     * 使用凸多边形所有的点都在任意一边线的一侧边.
     * This method when points size is 10,000 => Time Limit Exceeded
     *
     * @param points
     * @return
     */
    public boolean isConvex(List<List<Integer>> points) {
        if (points.size() < 3) return false;
        for (int i = 1; i <= points.size(); i++) {
            int x1 = points.get(i - 1).get(0), y1 = points.get(i - 1).get(1);
            int x2 = points.get(i % points.size()).get(0), y2 = points.get(i % points.size()).get(1);
            int flag = 0;
            //i 和 i- 1 两个点
            //x * (y2 - y1) - x1y2 + x2y1 = (x2 - x1) * y
            for (int j = 0; j < points.size(); j++) {
                if (j != i % points.size() && j != i - 1) {
                    int x = points.get(j).get(0);
                    int y = points.get(j).get(1);
                    int tmp = x * (y2 - y1) - x1 * y2 + x2 * y1 - (x2 - x1) * y;
                    if (flag == 0) flag = tmp;
                    if (flag * tmp < 0) return false;
                }
            }
        }
        return true;
    }

    /**
     * @param points
     * @return
     */
    public boolean isConvex2(List<List<Integer>> points) {

        return true;
    }

    /**
     * [[0,0],[1,0],[1,1],[-1,1],[-1,0]]
     *
     * @param args
     */
    public static void main(String[] args) {
        ConvexPolygon test = new ConvexPolygon();
        int[] one = {0, 0};
        List<Integer> point1 = ArrayTool.intToList(one);
        int[] two = {0, 1};
        List<Integer> point2 = ArrayTool.intToList(two);
        int[] three = {1, 1};
        List<Integer> point3 = ArrayTool.intToList(three);
        int[] four = {1, 0};
        List<Integer> point4 = ArrayTool.intToList(four);
        List<List<Integer>> points = new ArrayList<>();
        points.add(point1);
        points.add(point2);
        points.add(point3);
        points.add(point4);

        System.out.println(test.isConvex(points));

    }
}
