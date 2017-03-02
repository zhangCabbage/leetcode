package zhang.algorithm.leetcode.question496_Next_Greater_ElementI;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 17/2/26
 * Time: 下午9:19
 * To change this template use File | Settings | File Templates.
 */
public class NextGreaterElementI {
    /**
     * 17 / 17 test cases passed.
     * Status: Accepted
     * Runtime: 8 ms, bit 88.30%
     *
     * @param findNums
     * @param nums
     * @return
     */
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        if (nums == null || nums.length < 1) return findNums;

        Map<Integer, Integer> map = new HashMap<>();
        int max = nums[nums.length - 1];
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < max) map.put(nums[i], i);
            else {
                map.put(nums[i], -1);
                max = nums[i];
            }
        }

        for (int i = 0; i < findNums.length; i++) {
            int index = map.get(findNums[i]);
            if (index != -1) {
                for (int j = index; j < nums.length; j++) {
                    if (findNums[i] < nums[j]) {
                        findNums[i] = nums[j];
                        break;
                    }
                }
            } else {
                findNums[i] = index;
            }
        }

        return findNums;
    }


    /**
     * 没有想出最佳解法, 这里用stack确实是很巧妙
     *
     * @param findNums
     * @param nums
     * @return
     */
    public int[] nextGreaterElement2(int[] findNums, int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack();
        //从前到后循环
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && stack.peek() < nums[i])
                map.put(stack.pop(), nums[i]);
            stack.push(nums[i]);
        }

        for (int i = 0; i < findNums.length; i++)
            findNums[i] = map.getOrDefault(findNums[i], -1);

        return findNums;
    }

    /**
     * The same as above, but loop from right to left
     *
     * @param findNums
     * @param nums
     * @return
     */
    public int[] nextGreaterElement3(int[] findNums, int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack();
        //
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i])
                stack.pop();

            if (stack.isEmpty()) map.put(nums[i], -1);
            else map.put(nums[i], stack.peek());

            stack.push(nums[i]);
        }

        for (int i = 0; i < findNums.length; i++)
            findNums[i] = map.get(findNums[i]);

        return findNums;
    }

    public static void main(String[] args) {
        NextGreaterElementI test = new NextGreaterElementI();
        int[] findNums = {1, 3, 5, 2, 4};
        int[] nums = {6, 5, 4, 3, 2, 1, 7};
        System.out.println(Arrays.toString(test.nextGreaterElement(findNums, nums)));
    }
}
