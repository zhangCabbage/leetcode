package zhang.algorithm.leetcode.question151_Reverse_Words_String;

import java.util.regex.Pattern;

/**
 * Created by IntelliJ IDEA.
 * User: zhang_MacPro
 * Date: 16/7/11
 * Time: 下午7:41
 * To change this template use File | Settings | File Templates.
 */
public class ReverseWordsString {
    /**
     * <strong>result of test:</strong><br/>
     * 22 / 22 test cases passed
     * Status: Accepted
     * Runtime: 12 ms, bit 40.88%
     *
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        //最后的分割符分割的不计，但是前面的分割符计
        Pattern pattern = Pattern.compile(" +");
        String[] strs = pattern.split(s);

        int start = 0;
        int end = strs.length - 1;
        while (start < end) {
            String temp = strs[start];
            strs[start++] = strs[end];
            strs[end--] = temp;
        }

        StringBuffer sb = new StringBuffer();
        if (strs.length > 0) sb.append(strs[0]);
        for (int i = 1; i < strs.length; i++) {
            if (!strs[i].equals("")) {
                sb.append(" ");
                sb.append(strs[i]);
            }
        }

        return sb.toString();
    }

    //--------------------------------------------------------------
    //
    //--------------------------------------------------------------

    /**
     * 他的思路是：
     * zhang-love-gao ==> gao-love-zhang
     * 也就是每个单词分别进行倒置，然后再整体倒置
     * 1、gnahz-evol-oag 分别倒置
     * 2、gao-love-zhang 整体倒置
     * <p>
     * <strong>result of test:</strong><br/>
     * 22 / 22 test cases passed
     * Status: Accepted
     * Runtime: 4 ms, bit 74.48%
     *
     * @param s
     * @return
     */
    public String reverseWords2(String s) {
        char[] chs = s.toCharArray();

        int left = 0, right = chs.length - 1;
        while (left < chs.length && chs[left] == ' ') left++;
        while (right >= 0 && chs[right] == ' ') right--;

        if (left > right) return "";

        int i = left, j = left, next = left;
        while (i <= right && j <= right) {
            while (i <= right && chs[i] == ' ') i++;
            j = i;
            while (j <= right && chs[j] != ' ') j++;
            reverse(chs, i, j - 1);
            if (next < i) {
                for (int w = i; w < j; w++) {
                    chs[next++] = chs[w];
                }
                chs[next++] = ' ';
            } else {
                next = j + 1;
            }
            i = j + 1;
        }
        if (next <= right + 1) right = next - 2;
        reverse(chs, left, right);
        return new String(chs, left, right - left + 1);
    }

    /**
     * 同样的方法，但是代码有优化！！速度提升了不少
     * <strong>result of test:</strong><br/>
     * Runtime: 2-3 ms, bit 99.95-83.61%
     *
     * @param s
     * @return
     */
    public String reverseWords3(String s) {
        if (s == null) return null;

        char[] str = s.toCharArray();
        int start = 0, end = str.length - 1;

        // Trim start of string
        while (start <= end && str[start] == ' ')
            start++;

        // Trim end of string
        while (end >= 0 && str[end] == ' ')
            end--;

        if (start > end)
            return new String("");

        int i = start;
        while (i <= end) {
            if (str[i] != ' ') {
                // case when i points to a start of word -  find the word reverse it
                int j = i + 1;
                while (j <= end && str[j] != ' ')
                    j++;
                reverse(str, i, j - 1);
                i = j;
            } else {
                if (str[i - 1] == ' ') {
                    //case when prev char is also space - shift char to left by 1 and decrease end pointer
                    int j = i;
                    while (j <= end - 1) {
                        str[j] = str[j + 1];
                        j++;
                    }
                    end--;
                } else
                    // case when there is just single space
                    i++;
            }
        }
        //Now that all words are reversed, time to reverse the entire string pointed by start and end - This step reverses the words in string
        reverse(str, start, end);
        // return new string object pointed by start with len = end -start + 1
        return new String(str, start, end - start + 1);
    }

    /**
     * 仿照方法3自己实现
     *
     * @param s
     * @return
     */
    public String reverseWords4(String s) {
        if (s == null) return null;

        char[] str = s.toCharArray();
        int start = 0, end = str.length - 1;

        while (start <= end && str[start] == ' ') start++;
        while (end >= 0 && str[end] == ' ') end--;
        if (end < start) return "";

        int i = start, j;
        while (i <= end) {
            if (str[i] != ' ') {
                j = i;
                while (j <= end && str[j] != ' ')
                    j++;

                reverse(str, i, j - 1);
                i = j + 1;
            } else {
                j = i;
                while (j < end) {
                    str[j] = str[j + 1];
                    j++;
                }
                end--;
            }

        }
        reverse(str, start, end);
        return new String(str, start, end - start + 1);
    }

    private void reverse(char[] chs, int left, int right) {
        for (int wL = left, wR = right; wL < wR; wL++, wR--) {
            char ch = chs[wL];
            chs[wL] = chs[wR];
            chs[wR] = ch;
        }
    }

    public static void main(String[] args) {
        ReverseWordsString test = new ReverseWordsString();
        System.out.println(test.reverseWords("  "));
    }
}
