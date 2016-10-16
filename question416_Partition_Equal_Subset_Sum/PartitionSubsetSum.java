package zhang.algorithm.leetcode.question416_Partition_Equal_Subset_Sum;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 16/10/16
 * Time: 下午7:58
 * To change this template use File | Settings | File Templates.
 */
public class PartitionSubsetSum {
    /**
     * 回溯的方法, 第一次用从小到大进行回溯导致超时
     * But the tag of this problem is dynamic programing!!
     * <p>
     * 115 / 115 test cases passed
     * Status: Accepted
     * Runtime: 11 - 12 ms
     *
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) return false;

        Arrays.sort(nums);
        return canPartition(nums, 0, nums.length - 1, sum / 2);
    }

    /**
     * @param nums
     * @param sum
     * @param index
     * @param total
     * @return
     */
    public boolean canPartition(int[] nums, int sum, int index, int total) {
        if (sum == total) return true;
        else {
            for (int i = index; i >= 0; i--) {
                if (nums[i] <= total - sum) {
                    boolean res = canPartition(nums, sum + nums[i], i - 1, total);
                    if (res) return true;
                }
            }
            return false;
        }
    }

    //-----------------------------------------------------------------------
    //Second method -- Dynamic Programming
    //It similar to backpack problem
    //-----------------------------------------------------------------------

    /**
     * 虽然这种方式比回溯更慢,但是很值得学习
     * <p>
     * 115 / 115 test cases passed
     * Status: Accepted
     * Runtime: 26 - 50 ms
     *
     * @param nums
     * @return
     */
    public boolean canPartition2(int[] nums) {
        if (nums == null || nums.length == 0) return false;

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if ((sum & 1) == 1) return false;

        sum >>= 1;
        boolean[] dp = new boolean[sum + 1]; //表示这么大的空间是否填满
        dp[0] = true;
        for (int i = 0; i < nums.length; i++) {
            for (int j = sum; j >= nums[i]; j--) {
                dp[j] = dp[j] || dp[j - nums[i]];
                if (j == sum && dp[sum]) return true;
            }
        }

        return dp[sum];
    }

    public static void main(String[] args) {
        PartitionSubsetSum test = new PartitionSubsetSum();
        int[] nums = {1, 2, 5};
        System.out.println(test.canPartition(nums));
    }
}
