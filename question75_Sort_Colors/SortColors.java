package zhang.algorithm.leetcode.question75_Sort_Colors;

import zhang.algorithm.modelUtil.Array.ArrayTool;

/**
 * Created by zhang_zack on 16/5/27.
 */
public class SortColors {
    /**
     * 有局限性的一个算法<br/>
     * <strong>测试结果:</strong><br/>
     * 86 / 86 test cases passed.<br/>
     * Status: Accepted<br/>
     * Runtime: 0 ms,每次运行时间都不确定,这次打败了79.10%<br/>
     *
     * @param nums
     */
    public void sortColors(int[] nums) {
        //这里使用一个有弊端的算法
        int[] number = new int[3];
        for (int num : nums) {
            number[num]++;
        }
        int len = 0;
        int start = 0;
        while (len < 3) {
            for (int i = 0; i < number[len]; i++) {
                nums[i + start] = len;
            }
            start += number[len];
            len++;
        }
    }

    /**
     * 使用前后标记法,two pointers<br/>
     *
     * @param nums
     */
    public void sortColors2(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (i == start) continue;
                ArrayTool.swap(nums, i, start);
                i--;
                start++;
            } else if (nums[i] == 2) {
                if (i >= end) break;  //because if i >= end, there is no use to do something
                ArrayTool.swap(nums, i, end);
                i--;
                end--;
            }
        }
    }

    public static void main(String[] args) {
        SortColors test = new SortColors();
        int[] nums = {0, 1, 2, 0, 1, 2};
        int[] temp = nums;
//        test.sortColors(nums);
//        ZhangUtil.printArray(nums);
        test.sortColors2(temp);
        ArrayTool.printArray(temp);
    }
}
