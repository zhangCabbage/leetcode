package zhang.algorithm.leetcode.question242_Valid_Anagram;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: zhang_MacPro
 * Date: 16/8/24
 * Time: 下午9:58
 * To change this template use File | Settings | File Templates.
 */
public class ValidAnagram {
    /**
     * but when s and t is len to 50000, it will beyond the bounds of long
     * and result is wrong.
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        int[] map = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};

        int one = 1, two = 1;
        if (s.length() != t.length()) return false;

        for (char c : s.toCharArray()) {
            one *= map[c - 'a'];
        }
        for (char c : t.toCharArray()) {
            two *= map[c - 'a'];
        }
        return one == two;
    }

    /**
     * <strong>result of test:</strong>
     * 34 / 34 test cases passed
     * Status: Accepted
     * Runtime: 10 ms, 32.91%
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] x = s.toCharArray();
        char[] y = t.toCharArray();
        Arrays.sort(x);
        Arrays.sort(y);
        for (int i = 0; i < s.length(); i++) {
            if (x[i] != y[i])
                return false;
        }
        return true;
    }

    /**
     * <strong>result of test:</strong>
     * 34 / 34 test cases passed
     * Status: Accepted
     * Runtime: 9 ms, bit 37.63%
     * 此方法同后面的是一样的道理, 但是后者却快的多
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram3(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] map = new int[26];

        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - 'a']++;
            map[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < map.length; i++) {
            if (map[i] != 0)
                return false;
        }
        return true;
    }

    /**
     *
     * <strong>result of test:</strong>
     * 34 / 34 test cases passed
     * Status: Accepted
     * Runtime: 4 ms, bit 91%
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram4(String s, String t) {

        int[] map = new int[26];

        for (char c : s.toCharArray()) {
            int n = c - 'a';
            map[n]++;
        }

        for (char c : t.toCharArray()) {
            int n = c - 'a';
            map[n]--;
            if (map[n] < 0)
                return false;
        }

        for (int n : map)
            if (n > 0)
                return false;

        return true;

    }

    public static void main(String[] args) {
        ValidAnagram test = new ValidAnagram();
        String s = "acd";
        String t = "dac";
        System.out.println(test.isAnagram(s, t));
        System.out.println(test.isAnagram2(s, t));
    }
}
