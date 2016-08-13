package zhang.algorithm.leetcode.question268_Missing_Number;

/**
 * Created by IntelliJ IDEA.
 * User: zhang_MacPro
 * Date: 16/8/13
 * Time: 下午5:12
 * To change this template use File | Settings | File Templates.
 */
public class MissingNumber {
    /**
     * use the sum to judge.
     * <p>
     * <strong>result of test:</strong>
     * 121 / 121 test cases passed
     * Status: Accepted
     * Runtime: 1 ms, bit 43.73%
     *
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        long res = 0;
        for (int i = 0; i < nums.length; i++) {
            res += i + 1;
            res -= nums[i];
        }
        return (int) res;
    }

    /**
     * xor method
     * much more better
     *
     * @param nums
     * @return
     */
    public int missingNumber2(int[] nums) {
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            res ^= i;
            res ^= nums[i];
        }
        return res;
    }
}
