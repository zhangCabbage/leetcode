package zhang.algorithm.leetcode.question409_Longest_Palindrome;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 16/10/17
 * Time: 下午8:36
 * To change this template use File | Settings | File Templates.
 */
public class LongestPalindrome {
    /**
     * <strong>result of test:</strong>
     * 95 / 95 test cases passed
     * Status: Accepted
     * Runtime: 12 ms
     *
     * Here if use python, it has own package
     * import collections
     * dict(collection.Counter(s))
     *
     * a -> 97, z -> 122
     * A -> 65, Z -> 90
     *
     * @param s
     * @return
     */
    public int longestPalindrome(String s) {
        int[] map = new int[128];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map[c] = map[c] != 0 ? map[c] + 1 : map[c] - 1;
        }
        int num = 0;
        for (int i = 0; i < map.length; i++) {
            if (map[i] != 0)
                num++;
        }

        return num == 0 ? s.length() : s.length() - num + 1;
    }



    public static void main(String[] args) {
        LongestPalindrome test = new LongestPalindrome();
        String s = "";
        System.out.println(test.longestPalindrome(s));
    }
}
