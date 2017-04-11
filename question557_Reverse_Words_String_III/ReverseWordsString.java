package zhang.algorithm.leetcode.question557_Reverse_Words_String_III;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 17/4/11
 * Time: 上午11:07
 * To change this template use File | Settings | File Templates.
 */
public class ReverseWordsString {
    /**
     * 这道题不难, 但是你却用了差不多半小时时间。
     * 中间很多失误, 又不懂的去绕开复杂逻辑
     *
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        char[] c = s.toCharArray();
        int i = 0;
        boolean flag = true;
        for (int j = 0; j <= c.length; j++) {
            if (j == c.length || c[j] == ' ') {  //注意!
                reverse(c, i, j - 1);
                flag = true;
            } else if (flag) {
                i = j;
                flag = false;
            }
        }

        return String.valueOf(c);
    }

    /**
     * 绕开了需要判断最后一个的状态
     *
     * @param s
     * @return
     */
    public String reverseWords2(String s) {
        char[] c = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (c[i] != ' ') {
                int j = i;
                while (j + 1 < s.length() && c[j + 1] != ' ') j++;
                reverse(c, i, j);
                i = j;
            }
        }
        return String.valueOf(c);
    }

    private void reverse(char[] c, int i, int j) {
        while (i < j) {
            char tmp = c[i];
            c[i] = c[j];
            c[j] = tmp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        ReverseWordsString test = new ReverseWordsString();
        String s = "Let's take LeetCode contest";
        System.out.println(test.reverseWords(s));
    }
}
