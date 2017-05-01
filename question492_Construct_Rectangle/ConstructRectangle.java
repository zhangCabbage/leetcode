package zhang.algorithm.leetcode.question492_Construct_Rectangle;

/**
 * Created by IntelliJ IDEA.
 * User: zhang_Lenovo
 * Date: 2017/4/24
 * Time: 22:09
 * To change this template use File | Settings | File Templates.
 */
public class ConstructRectangle {
    /**
     * 50 / 50 test cases passed.
     * Status: Accepted
     * Runtime: 94 ms, bit 23%
     *
     * @param area
     * @return
     */
    public int[] constructRectangle(int area) {
        int sqrt = (int) Math.sqrt(area);
        int[] res = new int[2];
        if (sqrt * sqrt != area) sqrt++;
        for (int i = sqrt; i <= area; i++) {
            if (area % i == 0) {
                res[0] = i;
                res[1] = area / i;
                break;
            }
        }
        return res;
    }

    public int[] constructRectangle2(int area) {
        int sqrt = (int) Math.sqrt(area);
        int[] res = new int[2];
        for (int i = sqrt; i > 0; i--) {
            if (area % i == 0) {
                res[0] = area / i;
                res[1] = i;
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ConstructRectangle test = new ConstructRectangle();

    }
}
