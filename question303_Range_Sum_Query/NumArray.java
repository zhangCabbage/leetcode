package zhang.algorithm.leetcode.question303_Range_Sum_Query;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 16/9/23
 * Time: 下午9:25
 * To change this template use File | Settings | File Templates.
 */
public class NumArray {
    private long[] sum;

    /**
     * 16 / 16 test cases passed
     * Status: Accepted
     * Runtime: 3 ms, bit 29.01%
     *
     * @param nums
     */
    public NumArray(int[] nums) {
        sum = new long[nums.length];
        long temp = 0;
        for (int i = 0; i < nums.length; i++) {
            temp += nums[i];
            sum[i] = temp;
        }
    }

    public int sumRange(int i, int j) {
        return (int) (sum[j] - ((i == 0) ? 0 : sum[i - 1]));
    }

    public static void main(String[] args) {
    }
}
