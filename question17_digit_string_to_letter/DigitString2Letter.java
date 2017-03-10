package zhang.algorithm.leetcode.question17_digit_string_to_letter;

import java.util.ArrayList;
import java.util.List;

public class DigitString2Letter {
    /**
     * 只要含有1或0的非法数字，那么均返回不添加 <br/>
     * 递归AC无压力---> 1ms
     *
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        List<String> lists = new ArrayList<String>();
        if (digits.length() < 1) {
            return lists;
        }
        char[] c = digits.toCharArray();
        listAllString(lists, c, "", c.length);
        return lists;
    }

    private void listAllString(List<String> lists, char[] c, String prefix, int len) {
        if (len == 0) {
            lists.add(prefix);
        } else {
            int cur = c[c.length - len] - '0';
            char[][] wordbook = {{}, {}, {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};
            for (int i = 0; i < wordbook[cur].length; i++) {
                listAllString(lists, c, prefix + wordbook[cur][i], len - 1);
            }
        }
    }

    public static void main(String[] args) {
        DigitString2Letter test = new DigitString2Letter();
        String digits = "";
        System.out.println(test.letterCombinations(digits));
    }
}
