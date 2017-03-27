package zhang.algorithm.leetcode.question198_House_Robber;

/**
 * Created by IntelliJ IDEA.
 * User: zhang_MacPro
 * Date: 16/7/13
 * Time: 上午10:45
 * To change this template use File | Settings | File Templates.
 * <p>
 * Review Time: 2017-03-25 21:23:10
 */
public class HouseRobber {
    /**
     * use dynamic programming
     * <p>
     * <strong>result of test:</strong><br/>
     * 69 / 69 test cases passed
     * Status: Accepted
     * Runtime: 0 ms, bit 41.05%
     * <p>
     * 通过分析我们可以知道从前往后最后两个其中最大的就是能抢到的最大的钱
     * 而我们从前往后走, 因为相邻两个不能一起走, 所以要么走两步,要么走三步。
     * 不能走四步了,如果走四步,那么完全可以把第二步的也给包含了,这样不是抢更多么?
     * 所以……如下所示
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length < 1) return 0;
        if (nums.length == 1) return nums[0];

        int[] max = new int[nums.length];
        max[0] = nums[0];
        max[1] = nums[1];
        if (nums.length > 2)
            max[2] = nums[0] + nums[2];

        for (int i = 3; i < nums.length; i++) {
            max[i] = Math.max(max[i - 3], max[i - 2]) + nums[i];
        }

        return Math.max(max[nums.length - 2], max[nums.length - 1]);
    }

    /**
     * another dynamic programming method.
     * 递推关系为maxV[i] = max(maxV[i-2]+num[i], maxV[i-1])
     * this way is like more normal and perfect !!
     * <p>
     * And the result is the same as last way !!
     *
     * @param nums
     * @return
     */
    public int rob2(int[] nums) {
        if (nums == null || nums.length < 1) return 0;
        if (nums.length == 1) return nums[0];

        int len = nums.length;
        int[] max = new int[len];

        max[0] = nums[0];
        max[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++) {
            max[i] = Math.max(max[i - 2] + nums[i], max[i - 1]);
        }

        return max[len - 1];
    }

    /**
     * @param nums
     * @return
     */
    public int rob3(int[] nums) {
        if (nums == null || nums.length < 1) return 0;
        int[] res = new int[nums.length];

        for (int i = 0; i < nums.length; i++)
            res[i] = Math.max(i > 0 ? res[i - 1] : 0, (i > 1 ? res[i - 2] : 0) + nums[i]);

        return res[nums.length - 1];
    }


}
