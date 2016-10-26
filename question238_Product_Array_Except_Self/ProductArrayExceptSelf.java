package zhang.algorithm.leetcode.question238_Product_Array_Except_Self;

import zhang.algorithm.modelUtil.Array.ArrayTool;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 16/10/26
 * Time: 下午7:56
 * To change this template use File | Settings | File Templates.
 */
public class ProductArrayExceptSelf {
    /**
     * 竟然没有想出解决办法!!
     * 这么简单的方法, 为什么你竟然想不出来呢?!
     * <p>
     * 17 / 17 test cases passed
     * Status: Accepted
     * Runtime: 5 ms, bit 1.75%
     *
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, 1);

        int left = 1;
        int right = 1;
        for (int i = 0; i < n; i++) {
            res[i] *= left;
            left *= nums[i];

            res[n - i - 1] *= right;
            right *= nums[n - i - 1];
        }

        return res;
    }

    /**
     * Numbers:     2    3    4     5
     * Lefts:            2  2*3 2*3*4
     * Rights:  3*4*5  4*5    5
     *
     * @param nums
     * @return
     */
    public int[] productExceptSelf2(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }

        for (int i = n - 1; i > 0; i--) {
            res[i] *= res[0];  //attention please!!
            res[0] *= res[i];
        }
//        或者我们可以使用如下形式, 方便理解
//        int right = 1;
//        for (int i = n - 1; i >= 0; i--) {
//            res[i] *= right;
//            right *= res[i];
//        }

        return res;
    }

    public static void main(String[] args) {
        ProductArrayExceptSelf test = new ProductArrayExceptSelf();
        int[] nums = {0, 0};
        ArrayTool.printArray(test.productExceptSelf(nums));
        ArrayTool.printArray(test.productExceptSelf2(nums));
    }
}
