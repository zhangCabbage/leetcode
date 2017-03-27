package zhang.algorithm.leetcode.question213_House_Robber_II;

/**
 * Created by IntelliJ IDEA.
 * User: zhang_MacPro
 * Date: 16/8/2
 * Time: 下午12:47
 * To change this template use File | Settings | File Templates.
 * <p>
 * Review Time: 2017-03-25 21:40:09
 */
public class HouseRobberII {
    /**
     * <strong>result of test:</strong><br/>
     * 74 / 74 test cases passed
     * Status: Accepted
     * Runtime: 1 ms, bit 3.68%
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length < 1) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        int[] rob1 = new int[nums.length - 1];
        rob1[0] = nums[0];
        rob1[1] = Math.max(nums[0], nums[1]);

        int[] rob2 = new int[nums.length - 1];
        rob2[0] = nums[1];
        rob2[1] = Math.max(nums[1], nums[2]);

        for (int i = 2; i < nums.length - 1; i++) {
            rob1[i] = Math.max(rob1[i - 2] + nums[i], rob1[i - 1]);
            rob2[i] = Math.max(rob2[i - 2] + nums[i + 1], rob2[i - 1]);
        }

        return Math.max(rob1[nums.length - 2], rob2[nums.length - 2]);
    }

    /**
     * 分成两段来解决问题
     *
     * @param nums
     * @return
     */
    public int rob2(int[] nums) {
        if (nums == null || nums.length < 1) return 0;
        if (nums.length == 1) return nums[0];
        int n = nums.length;
        int[] first = new int[n - 1];
        int[] second = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            first[i] = Math.max(i > 0 ? first[i - 1] : 0, (i > 1 ? first[i - 2] : 0) + nums[i]);
            second[i] = Math.max(i > 0 ? second[i - 1] : 0, (i > 1 ? second[i - 2] : 0) + nums[i + 1]);
        }

        return Math.max(first[n - 2], second[n - 2]);
    }

    public static void main(String[] args) {
        HouseRobberII test = new HouseRobberII();
        int[] nums = {1};
        System.out.println(test.rob(nums));
    }
}
