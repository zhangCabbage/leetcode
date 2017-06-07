package zhang.algorithm.leetcode.question526_Beautiful_Arrangement;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 17/6/7
 * Time: 上午10:05
 * To change this template use File | Settings | File Templates.
 */
public class BeautifulArrangement {
    /**
     * 15 / 15 test cases passed.
     * Status: Accepted
     * Runtime: 83 ms, bit 76.71%
     *
     * @param N
     * @return
     */
    public int countArrangement(int N) {
        int[] map = new int[N + 1];
        return backtracking(1, map);
    }

    private int backtracking(int n, int[] map) {
        if (n == map.length) return 1;
        int res = 0;

        //乘
        for (int i = 2; n * i < map.length; i++) {
            if (map[n * i] == 0) {
                map[n * i] = 1;
                res += backtracking(n + 1, map);
                map[n * i] = 0;
            }
        }

        //除以 n 次
        for (int i = 1; i <= n; i++) {
            if (n % i == 0 && map[n / i] == 0) {
                map[n / i] = 1;
                res += backtracking(n + 1, map);
                map[n / i] = 0;
            }
        }

        return res;
    }

    //----------------------------------------------------------------------------------------------------
    //code way2
    //----------------------------------------------------------------------------------------------------

    /**
     * 15 / 15 test cases passed.
     * Status: Accepted
     * Runtime: 99 ms, bit 51.14%
     *
     * @param pos
     * @param map
     * @return
     */
    private int backtracking2(int pos, int[] map) {
        if (pos == map.length) return 1;
        int res = 0;

        //乘除在一块
        for (int i = 1; i < map.length; i++) {
            if (map[i] == 0 && (i % pos == 0 || pos % i == 0)) {
                map[i] = 1;
                res += backtracking2(pos + 1, map);
                map[i] = 0;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        BeautifulArrangement test = new BeautifulArrangement();
        for (int i = 1; i < 16; i++) {
            System.out.println(test.countArrangement(i));
        }
    }
}
