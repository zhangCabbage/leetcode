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




    
    public static void main(String[] args) {
        CombinationSumIV test = new CombinationSumIV();
        int[] nums = {1, 2, 3};
        int target = 32;
        System.out.println(test.combinationSum4(nums, target));
    }
}
