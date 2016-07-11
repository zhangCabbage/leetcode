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

    public static void main(String[] args) {
        ReverseWordsString test = new ReverseWordsString();
        System.out.println(test.reverseWords("  "));
    }
}
