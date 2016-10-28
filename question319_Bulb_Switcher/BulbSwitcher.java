package zhang.algorithm.leetcode.question319_Bulb_Switcher;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 16/10/28
 * Time: 下午6:42
 * To change this template use File | Settings | File Templates.
 */
public class BulbSwitcher {
    /**
     * Because of this problem I has been encountered before. So it is easy for me.
     * <p>
     * 35 / 35 test cases passed
     * Status: Accepted
     * Runtime: 0 ms, bit 25.12%
     * <p>
     * Can you solve this problem not use sqrt ?
     * Or in other word, how to implement sqrt !?
     *
     * @param n
     * @return
     */
    public int bulbSwitch(int n) {
        return (int) Math.sqrt(n);
    }

    public static void main(String[] args) {
        BulbSwitcher test = new BulbSwitcher();
    }
}
