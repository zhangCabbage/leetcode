package zhang.algorithm.leetcode.question189_Rotate_Array;

import zhang.algorithm.modelUtil.Array.ArrayTool;

/**
 * Created by IntelliJ IDEA.
 * User: zhang_MacPro
 * Date: 16/7/8
 * Time: 下午8:59
 * To change this template use File | Settings | File Templates.
 */
public class RotateArray {
    /**
     * Do you have more good idea!!??
     * <p>
     * <strong>result of test:</strong><br/>
     * 33 / 33 test cases passed
     * Status: Accepted
     * Runtime: 1 ms, bit 13.71%
     *
     * @param nums
     * @param k    this problem k must be a positive number.
     */
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        if (k == 0) return;
        int[] temp = new int[k];
        for (int i = 0; i < k; i++) {
            temp[i] = nums[nums.length - k + i];
        }

        for (int i = nums.length - 1; i >= k; i--) {
            nums[i] = nums[i - k];
        }
        for (int i = 0; i < k; i++) {
            nums[i] = temp[i];
        }
    }

    /**
     * 使用系统自带的复制工具, 系统自带的复制工具经过优化,更快
     * <p>
     * <strong>result of test:</strong><br/>
     * 33 / 33 test cases passed
     * Status: Accepted
     * Runtime: 0 ms, bit 96.39%
     *
     * @param nums
     * @param k
     */
    public void rotate2(int[] nums, int k) {
        k = k % nums.length;
        int[] temp = new int[nums.length];
        System.arraycopy(nums, 0, temp, 0, nums.length - k);
        System.arraycopy(nums, nums.length - k, nums, 0, k);
        System.arraycopy(temp, 0, nums, k, nums.length - k);
    }

    /**
     * only O(1) extra space
     * <p>
     * Runtime: 1 ms, bit 13.71%
     *
     * @param nums
     * @param k
     */
    public void rotate3(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        ArrayTool.reverse(nums, 0, n - 1);
        ArrayTool.reverse(nums, 0, k - 1);
        ArrayTool.reverse(nums, k, n - 1);
    }

    public static void main(String[] args) {
        RotateArray test = new RotateArray();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        test.rotate3(nums, k);
        ArrayTool.printArray(nums);
    }
}
