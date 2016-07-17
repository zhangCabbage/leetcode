package zhang.algorithm.leetcode.question202_Happy_Number;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: zhang_MacPro
 * Date: 16/7/18
 * Time: 上午12:00
 * To change this template use File | Settings | File Templates.
 */
public class HappyNumber {
    /**
     * <strong>result of test:</strong><br/>
     * 401 / 401 test cases passed
     * Status: Accepted
     * Runtime: 8 ms, bit 11.35%
     *
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();

        while (true) {
            int sum = (int) Math.pow(n % 10, 2);
            n /= 10;
            while (n != 0) {
                sum += Math.pow(n % 10, 2);
                n /= 10;
            }
            if (sum == 1) {
                return true;
            }
            if (map.get(sum) == null) {
                map.put(sum, true);
            } else {
                return false;
            }
            n = sum;
        }
    }

    /**
     * <strong>result of test:</strong><br/>
     * 401 / 401 test cases passed
     * Status: Accepted
     * Runtime: 5 ms, bit 53.31%
     * <p>
     * use HashSet method of add
     * if add success return true, or return false.
     *
     * @param n
     * @return
     */
    public boolean isHappy2(int n) {
        Set<Integer> inLoop = new HashSet<Integer>();
        int squareSum, remain;

        while (inLoop.add(n)) {
            squareSum = 0;
            while (n > 0) {
                remain = n % 10;
                squareSum += remain * remain;
                n /= 10;
            }
            if (squareSum == 1)
                return true;
            else
                n = squareSum;

        }
        return false;
    }

    /**
     * this way is very smart!!
     * we can see max the sum of the squares of int digits.
     * Max Integer is 2147483647 --> 260
     * 999999999 --> 810(10个9的平方也才810)
     * 所以用一个1000的数组完全可以容纳下所有的数!!
     * <p>
     * <strong>result of test:</strong><br/>
     * 401 / 401 test cases passed
     * Status: Accepted
     * Runtime: 2 ms, bit 83.23%
     *
     * @param n
     * @return
     */
    public boolean isHappy3(int n) {
        boolean[] exist = new boolean[1000];
        while (true) {
            if (n == 1) return true;
            int m = 0;
            while (n > 0) {
                m += (n % 10) * (n % 10);
                n /= 10;
            }
            n = m;
            if (exist[m] == true) return false;
            exist[m] = true;
        }
    }

    public static void main(String[] args) {
        HappyNumber test = new HappyNumber();
        System.out.println(test.isHappy(7));
    }
}
