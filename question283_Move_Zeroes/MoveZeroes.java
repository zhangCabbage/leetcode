package zhang.algorithm.leetcode.question283_Move_Zeroes;

import zhang.algorithm.modelUtil.Array.ArrayTool;

/**
 * Created by IntelliJ IDEA.
 * User: zhang_MacPro
 * Date: 16/8/12
 * Time: 下午7:52
 * To change this template use File | Settings | File Templates.
 */
public class MoveZeroes {
    /**
     * my thought is use two point, but it use too much judge.
     * <strong>result of test:</strong>
     * 21 / 21 test cases passed
     * Status: Accepted
     * Runtime: 1 ms, bit 24.47%
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int zero = 0;
        int index = 0;
        while (index < nums.length) {
            if (nums[index] != 0) {
                if (index != zero) {
                    nums[zero] = nums[index];
                    nums[index] = 0;
                }
                zero++;
            }
            index++;
        }
    }

    /**
     * <strong>result of test:</strong>
     * 21 / 21 test cases passed
     * Status: Accepted
     * Runtime: 0 ms, bit 87.33%
     *
     * @param nums
     */
    public void moveZeroes2(int[] nums) {
        int zero = 0;
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if (val == 0) {
                zero++;
            } else {
                nums[i] = 0;
                nums[i - zero] = val;
            }
        }
    }

    public static void main(String[] args) {
        MoveZeroes test = new MoveZeroes();
        int[] nums = {0, 1, 0, 3, 12};
        test.moveZeroes2(nums);
        ArrayTool.printArray(nums);
    }
}
