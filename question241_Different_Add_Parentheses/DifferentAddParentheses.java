package zhang.algorithm.leetcode.question241_Different_Add_Parentheses;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 16/11/1
 * Time: 下午8:26
 * To change this template use File | Settings | File Templates.
 */
public class DifferentAddParentheses {
    /**
     * @param input
     * @return
     */
    public List<Integer> diffWaysToCompute(String input) {
        String[] nums = input.split("\\+|-|\\*|/");
        String[] opers = input.split("\\d+");

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i++) {
            long res = 0;
            int num1 = Integer.parseInt(nums[i]);
            int num2 = Integer.parseInt(nums[i + 1]);
            switch (opers[i + 1]) {
                case "+":
                    res = num1 + num2;
                    break;
                case "-":
                    res = num1 - num2;
                    break;
                case "*":
                    res = num1 * num2;
                    break;
                case "/":
                    res = num1 / num2;
                    break;
            }
            helper(list, nums, opers, i, i + 1, res);
        }

        Collections.sort(list);
        return list;
    }

    private void helper(List<Integer> list, String[] nums, String[] opers, int left, int right, long res) {
        if (right - left == nums.length - 1) list.add((int) res);
        else {
            long tmp = res;
            if (left > 0) {
                switch (opers[left]) {
                    case "+":
                        tmp = Integer.parseInt(nums[left - 1]) + tmp;
                        break;
                    case "-":
                        tmp = Integer.parseInt(nums[left - 1]) - tmp;
                        break;
                    case "*":
                        tmp = Integer.parseInt(nums[left - 1]) * tmp;
                        break;
                    case "/":
                        tmp = Integer.parseInt(nums[left - 1]) / tmp;
                        break;
                }
                helper(list, nums, opers, left - 1, right, tmp);
            }
            tmp = res;
            if (right < nums.length - 1) {
                switch (opers[right + 1]) {
                    case "+":
                        tmp += Integer.parseInt(nums[right + 1]);
                        break;
                    case "-":
                        tmp -= Integer.parseInt(nums[right + 1]);
                        break;
                    case "*":
                        tmp *= Integer.parseInt(nums[right + 1]);
                        break;
                    case "/":
                        tmp /= Integer.parseInt(nums[right + 1]);
                        break;
                }
                helper(list, nums, opers, left, right + 1, tmp);
            }
        }
    }

    public static void main(String[] args) {
        DifferentAddParentheses test = new DifferentAddParentheses();
        String input = "12-1-1";
        System.out.println(test.diffWaysToCompute(input));
    }
}
