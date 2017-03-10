package zhang.algorithm.leetcode.question75_Sort_Colors;

import zhang.algorithm.modelUtil.Array.ArrayTool;

/**
 * Created by zhang_zack on 16/5/27.
 * <p>
 * Review Time: 2017-03-09 19:36:00
 * sortColors2方法好像不怎么好理解
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

    /**
     * 对于sortColors2的逻辑我自己绕了半个多小时, 真是醉了
     * start和i是同一起点, 所以当nums[i] == 0时, 交换后, 需要i和start都加1
     * 而end和i不是一起的, 所以当nums[i] == 2时
     * start最后停留的地方肯定是1
     *
     * @param nums
     */
    public void sortColors3(int[] nums) {
        int start = 0, end = nums.length - 1;
        int i = start;

        while (i <= end) {
            if (nums[i] == 0) {
                ArrayTool.swap(nums, i++, start++);
            } else if (nums[i] == 2) {
                ArrayTool.swap(nums, i, end--);
            } else i++;
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
