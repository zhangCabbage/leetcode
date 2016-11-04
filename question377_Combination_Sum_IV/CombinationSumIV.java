package zhang.algorithm.leetcode.question377_Combination_Sum_IV;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 16/10/29
 * Time: 下午2:27
 * To change this template use File | Settings | File Templates.
 */
public class CombinationSumIV {
    /**
     * backtracking
     * This can deal this problem, but [Time Limit Exceeded]
     *
     * @param nums
     * @param target
     * @return
     */
    public int combinationSum4(int[] nums, int target) {
        if (nums.length < 1 || target == 0) return 0;
        Arrays.sort(nums);
        return helper(nums, target);
    }

    private int helper(int[] nums, int target) {
        int count = 0;
        if (target == 0) count = 1;
        if (target >= nums[0]) {
            for (int i = 0; i < nums.length; i++) {
                if (target < nums[i]) break;
                count += helper(nums, target - nums[i]);
            }
        }
        return count;
    }

    //----------------------------------------------------------------------
    //针对动态规划的问题, 如何一步步的深入分析, 最终找到子问题, 并解决?
    //----------------------------------------------------------------------

    /**
     * 1、仍使用递归的方法, 解决此问题, 做进一步改进, 不需要使用排序
     *
     * @param nums
     * @param target
     * @return
     */
    public int combinationSum4_2(int[] nums, int target) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target >= nums[i]) res += combinationSum4_2(nums, target - nums[i]);
        }
        return res;
    }

    //----------------------------------------------------------------------
    //----------------------------------------------------------------------

    /**
     * 2、针对递归中会针对某个值多次计算的问题, 使用备忘录的方式进行存储
     * <p>
     * 17 / 17 test cases passed.
     * Status: Accepted
     * Runtime: 1 ms, bit 93.01%
     *
     * @param nums
     * @param target
     * @return
     */
    public int combinationSum4_3(int[] nums, int target) {
        int[] map = new int[target + 1];
        Arrays.fill(map, -1);  //why use -1, but use 0, because -1 means not use, 0 means can make
        map[0] = 1;
        return helper(nums, target, map);
    }

    private int helper(int[] nums, int target, int[] map) {
        if (map[target] != -1) return map[target];
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target >= nums[i])
                res += helper(nums, target - nums[i], map);
        }

        map[target] = res;
        return res;
    }

    //----------------------------------------------------------------------
    //----------------------------------------------------------------------

    /**
     * 3、动态规划解决当前问题
     * <p>
     * 17 / 17 test cases passed.
     * Status: Accepted
     * Runtime: 6 ms, bit 21.56%
     *
     * @param nums
     * @param target
     * @return
     */
    public int combinationSum4_4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i >= nums[j])
                    dp[i] += dp[i - nums[j]];
            }
        }
        return dp[target];
    }

    //----------------------------------------------------------------------
    //----------------------------------------------------------------------

    /**
     * 4、因为动态规划解决问题, 常见时间复杂度为O(n^2), 这里可以采用排序 nums 来改进动态规划
     * <p>
     * 17 / 17 test cases passed.
     * Status: Accepted
     * Runtime: 4 ms, bit 70.53%
     *
     * @param nums
     * @param target
     * @return
     */
    public int combinationSum4_5(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        Arrays.sort(nums);
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] > i) break;
                else dp[i] += dp[i - nums[j]];
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        CombinationSumIV test = new CombinationSumIV();
        int[] nums = {1, 2, 3};
        int target = 32;
        //the result is 181997601
        System.out.println(test.combinationSum4(nums, target));
    }
}
