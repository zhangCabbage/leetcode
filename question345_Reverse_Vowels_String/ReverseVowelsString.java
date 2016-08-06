package zhang.algorithm.leetcode.question345_Reverse_Vowels_String;

/**
 * Created by IntelliJ IDEA.
 * User: zhang_MacPro
 * Date: 16/8/6
 * Time: 下午2:24
 * To change this template use File | Settings | File Templates.
 */
public class ReverseVowelsString {
    /**
     * <strong>result of test:</strong>
     * 481 / 481 test cases passed
     * Status: Accepted
     * Runtime: 3 ms, bit 99.96%
     *
     * @param s
     * @return
     */
    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) return s;

        char[] c = s.toCharArray();
        char[] map = new char[128];
        char[] vowels = "aeiouAEIOU".toCharArray();
        for (int i = 0; i < vowels.length; i++) {
            map[vowels[i]] = 1;
        }
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            while (i < j && map[c[i]] != 1) i++;
            while (i < j && map[c[j]] != 1) j--;

            if (i < j) {
                char temp = c[i];
                c[i++] = c[j];
                c[j--] = temp;
            }
        }

        return String.valueOf(c);
    }
}
