package zhang.algorithm.leetcode.question464_Can_I_Win;

import java.util.HashMap;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 16/11/25
 * Time: 下午8:17
 * To change this template use File | Settings | File Templates.
 * <p>
 * 这道题 discuss 中暂时没有 Down-Top dp 算法
 */
public class CanIWin {
    /**
     * I know the tag of this problem is dp. So How to do?
     * Can not re-use integers!
     * if can re-use integer, I can solve it.
     * [Wrong]
     * if desiredTotal = 40, should return false.
     * The thought of mine is Wrong.
     *
     * @param maxChoosableInteger
     * @param desiredTotal
     * @return
     */
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int[] dp = new int[desiredTotal + 1];
        dp[0] = 1 << maxChoosableInteger;
        for (int i = 1; i < dp.length; i++) {
            if (i <= maxChoosableInteger) {
                dp[i] = 1 << (i - 1);
            } else {
                for (int j = 0; j < maxChoosableInteger; j++) {
                    if ((dp[i - j - 1] & (1 << j)) == 0 && dp[i - j - 1] == 0) {
                        dp[i] = dp[i - j - 1] | (1 << j);
                        break;
                    }
                }
            }
        }
        return dp[desiredTotal] != 0;
    }

    //---------------------------------------------------------------------------------
    //Top-down DP
    //跟上一个差不多的, 使用位运算辅助进行动态规划的思想
    //leetcode中大部分的game题目, 都是通过 [递归 + 备忘录] 来模拟 [动态规划] 的方式
    //---------------------------------------------------------------------------------

    /**
     * 52 / 52 test cases passed.
     * Status: Accepted
     * Runtime: 109 ms
     *
     * @param maxChoosableInteger
     * @param desiredTotal
     * @return
     */
    public boolean canIWin2(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal <= 0) return true;
        if (maxChoosableInteger * (maxChoosableInteger + 1) / 2 < desiredTotal) return false;
        return helper(maxChoosableInteger, desiredTotal, 0, new HashMap<>());
    }

    /**
     * @param len
     * @param desiredTotal
     * @param state        已经选中
     * @param map
     * @return
     */
    private boolean helper(int len, int desiredTotal, int state, HashMap<Integer, Boolean> map) {
        Boolean res = map.get(state);
        if (res != null) return res;
        for (int i = 0; i < len; i++) {
            if ((state & (1 << i)) == 0) {
                if (i + 1 >= desiredTotal || !helper(len, desiredTotal - i - 1, state | (1 << i), map)) {
                    map.put(state, true);
                    return true;
                }
            }
        }
        map.put(state, false);
        return false;
    }

    public static void main(String[] args) {
        CanIWin test = new CanIWin();
        int maxChoosableInteger = 10;
        int desiredTotal = 11;
        System.out.println(test.canIWin2(maxChoosableInteger, desiredTotal));
    }
}
