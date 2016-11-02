package zhang.algorithm.leetcode.question241_Different_Add_Parentheses;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 16/11/1
 * Time: 下午8:26
 * To change this template use File | Settings | File Templates.
 */
public class DifferentAddParentheses {
    /**
     * MDZZ, 今天头有点晕, 竟然写了这么烂的代码, 自己都看不下, 而且还没有AC
     * 我猜这个状态的我, 一定是个智障!!
     * 原题地址:(https://leetcode.com/problems/different-ways-to-add-parentheses/)
     *
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

    //----------------------------------------------------------------------
    //仔细读题, 认真思考
    //----------------------------------------------------------------------
    private Map<String, List<Integer>> map = new HashMap<>();

    /**
     * 25 / 25 test cases passed.
     * Status: Accepted
     * Runtime: 8 - 11 ms, bit 33.01 - 8.52%
     *
     * @param input
     * @return
     */
    public List<Integer> diffWaysToCompute2(String input) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char cur = input.charAt(i);
            if (cur == '+' || cur == '-' || cur == '*') {
                String before = input.substring(0, i);
                String after = input.substring(i + 1);
                List<Integer> l1 = map.getOrDefault(before, diffWaysToCompute2(before));
                List<Integer> l2 = map.getOrDefault(after, diffWaysToCompute2(after));
                for (Integer i1 : l1) {
                    for (Integer i2 : l2) {
                        list.add(cur == '+' ? i1 + i2 : cur == '-' ? i1 - i2 : i1 * i2);
                    }
                }
            }
        }

        if (list.size() == 0) list.add(Integer.parseInt(input));
        map.put(input, list);

        return list;
    }

    public static void main(String[] args) {
        DifferentAddParentheses test = new DifferentAddParentheses();
        String input = "12-1-1";
        System.out.println(test.diffWaysToCompute(input));
    }
}
