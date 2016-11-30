package zhang.algorithm.leetcode.question367_Valid_Perfect_Square;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 16/11/29
 * Time: 下午9:53
 * To change this template use File | Settings | File Templates.
 */
public class ValidPerfectSquare {
    //------------------------------------------------------------------
    //Newton - 牛顿迭代法, Time Complexity is close to constant
    //------------------------------------------------------------------

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
     * 改进我写的导数法, 也就是牛顿迭代法
     * 简洁化代码
     *
     * @param num
     * @return
     */
    public boolean isPerfectSquare1(int num) {
        if (num < 1) return false;
        long t = num / 2;
        while (t * t > num) {
            t = (t + num / t) / 2;
        }
        return t * t == num;
    }

    //------------------------------------------------------------------
    //binary search. Time Complexity O(logN)
    //------------------------------------------------------------------

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

    //------------------------------------------------------------------
    //a square number is 1+3+5+7+... Time Complexity O(sqrt(N))
    //------------------------------------------------------------------

    /**
     * we can see:
     * 1 = 1
     * 4 = 1 + 3
     * 9 = 1 + 3 + 5
     * 16 = 1 + 3 + 5 + 7
     * 25 = 1 + 3 + 5 + 7 + 9
     *
     * @param num
     * @return
     */
    public boolean isPerfectSquare4(int num) {
        if (num < 1) return false;
        for (int i = 1; num > 0; i += 2) num -= i;
        return num == 0;
    }

    public static void main(String[] args) {
        ValidPerfectSquare test = new ValidPerfectSquare();
        int num = 808201;  //899
        System.out.println(test.isPerfectSquare(num));
        System.out.println(test.isPerfectSquare1(num));
        System.out.println(test.isPerfectSquare2(num));
        System.out.println(test.isPerfectSquare3(num));
        System.out.println(test.isPerfectSquare4(num));
    }
}
