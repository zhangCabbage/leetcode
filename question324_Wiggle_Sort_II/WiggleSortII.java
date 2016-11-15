package zhang.algorithm.leetcode.question324_Wiggle_Sort_II;

import zhang.algorithm.modelUtil.Array.ArrayTool;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 16/11/15
 * Time: 下午9:05 - 10:44
 * To change this template use File | Settings | File Templates.
 * <p>
 * https://leetcode.com/problems/wiggle-sort-ii/
 */
public class WiggleSortII {
    /**
     * 第一次想到的方法, 虽然时间复杂度和空间复杂度都没有达到标准,但是我尝试这看这个思路对不对
     * Wrong, when input is {4, 5, 5, 6}
     *
     * @param nums
     */
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int[] copy = new int[len];

        for (int i = 0; i < len / 2; i++) copy[i * 2] = nums[i];
        int start = len / 2;
        if (len % 2 != 0) {
            copy[len - 1] = nums[len / 2];
            start++;
        }
        for (int i = 0; i < len / 2; i++) copy[i * 2 + 1] = nums[start + i];

        System.arraycopy(copy, 0, nums, 0, len);
    }

    //----------------------------------------------------------------------------
    //
    //----------------------------------------------------------------------------

    /**
     * 经过考虑后, 给出如下答案, 但是貌似仍然不对。会无限循环
     *
     * @param nums
     */
    public void wiggleSort2(int[] nums) {
        int i = 1;
        while (i < nums.length) {
            if (nums[i] == nums[i - 1]) {
                boolean flag = false;
                int j = i + 1;
                while (true) {
                    if (j == nums.length) {
                        j = 0;
                        flag = true;
                    }
                    if ((i % 2 == 0 && nums[j] < nums[i - 1]) || (i % 2 != 0 && nums[j] > nums[i - 1]))
                        break;
                    j++;
                }
                exchange(nums, i, j);
                if (flag) i = j + 1;
                continue;
            }

            if (i % 2 == 0) {
                if (nums[i] > nums[i - 1]) exchange(nums, i - 1, i);
            } else {
                if (nums[i] < nums[i - 1]) exchange(nums, i - 1, i);
            }
            i++;
        }
    }

    private void exchange(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    //----------------------------------------------------------------------------
    //
    //----------------------------------------------------------------------------


    public static void main(String[] args) {
        WiggleSortII test = new WiggleSortII();
        int[] nums = {2, 3, 3, 2, 2, 2, 1, 1};
        test.wiggleSort2(nums);
        ArrayTool.printArray(nums);
    }
}
