package zhang.algorithm.leetcode.question367_Valid_Perfect_Square;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 16/11/29
 * Time: 下午9:53
 * To change this template use File | Settings | File Templates.
 * TODO, 没有审查
 */
public class ValidPerfectSquare {
    /**
     * 采用导数来进行查找, 比二分查找更快
     * ==>
     * 67 / 67 test cases passed.
     * Status: Accepted
     * Runtime: 0 ms, bit 30.31%
     *
     * @param num
     * @return
     */
    public boolean isPerfectSquare(int num) {
        int pre = num;
        while (true) {
            if (pre == 0) return false;
            int cur = (int) ((1.0 * pre * pre + num) / (2.0 * pre));
            if (cur * cur == num) return true;
            if (cur >= pre) return false;
            pre = cur;
        }
    }

    /**
     * 采用二分法来进行查找
     * ==>
     * 67 / 67 test cases passed.
     * Status: Accepted
     * Runtime: 1 ms, bit 15.18%
     *
     * @param num
     * @return
     */
    public boolean isPerfectSquare2(int num) {
        int l = 1, r = num;
        while (l <= r) {
            int mid = l + (r - l >> 1);
            long tmp = 1L * mid * mid;
            if (tmp < num) l = mid + 1;
            else if (tmp > num) r = mid - 1;
            else return true;
        }
        return false;
    }

    /**
     * 改进上面采用二分查找的代码构造, 避免超出Integer.MAX_VALUE范围
     *
     * @param num
     * @return
     */
    public boolean isPerfectSquare3(int num) {
        int l = 1, r = num;
        while (l < r) {
            int mid = l + (r - l >> 1);
            if (mid < num / mid) l = mid + 1;
            else r = mid;
        }
        return l == (double) num / l;
    }

    public static void main(String[] args) {
        ValidPerfectSquare test = new ValidPerfectSquare();
        int num = 808201;  //899
        System.out.println(test.isPerfectSquare(num));
        System.out.println(test.isPerfectSquare2(num));
        System.out.println(test.isPerfectSquare3(num));
    }
}
