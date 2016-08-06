package zhang.algorithm.leetcode.question344_Reverse_String;

/**
 * Created by IntelliJ IDEA.
 * User: zhang_MacPro
 * Date: 16/8/6
 * Time: 下午1:56
 * To change this template use File | Settings | File Templates.
 */
public class ReverseString {
    /**
     * <strong>result of test:</strong>
     * 476 / 476 test cases passed
     * Status: Accepted
     * Runtime: 3 ms, bit 59.55%
     *
     * @param s
     * @return
     */
    public String reverseString(String s) {
        if (s == null || s.length() == 0) return s;

        char[] c = s.toCharArray();
        int i = 0;
        int j = c.length - 1;
        while (i < j) {
            char temp = c[i];
            c[i++] = c[j];
            c[j--] = temp;
        }
        return String.valueOf(c);
    }

    public static void main(String[] args) {
        ReverseString test = new ReverseString();
        String s = "Hello World!";
        System.out.println(test.reverseString(s));
    }
}
