package zhang.algorithm.leetcode.question395_LSubstr_Least_KRepeating_Characters;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 16/10/22
 * Time: 下午5:25
 * To change this template use File | Settings | File Templates.
 */
public class LSubstrLeastKRepeatChar {
    /**
     * 没有思路, 这类String处理的不知道从何下手
     * 最终思考半天, 想到一个最笨的方法 O(n*n)
     * but the result is " Time Limit Exceeded " if str is "aa...aa"
     *
     * @param s 全为小写字母
     * @param k
     * @return
     */
    public int longestSubstring(String s, int k) {
        if (k <= 1) return s.length();
        int max = 0;
        for (int i = 0; i < s.length() - k + 1; i++) {
            int count = 0;
            int[] map = new int[26];
            boolean[] flag = new boolean[26];
            for (int j = i; j < s.length(); j++) {
                int res = ++map[s.charAt(j) - 'a'];
                if (res == 1) count++;
                if (res >= k) {
                    if (!flag[s.charAt(j) - 'a']) {
                        count--;
                        flag[s.charAt(j) - 'a'] = true;
                    }
                    max = count == 0 ? Math.max(max, j - i + 1) : max;
                }
            }
        }
        return max;
    }

    /**
     * use the method of divide and conquer (recursion) to solve this problem.
     * 分治法!! 从中提取从前到后个数count小于k的字符
     * <p>
     * 24 / 24 test cases passed
     * Status: Accepted
     * Runtime: 3 ms, bit 86.72%
     * 关于时间复杂度的分析!!
     *
     * @param s
     * @param k
     * @return
     */
    public int longestSubstring2(String s, int k) {
        char[] str = s.toCharArray();
        return helper(str, 0, str.length, k);
    }

    private int helper(char[] str, int start, int end, int k) {
        if (end - start < k) return 0;
        int[] count = new int[26];
        for (int i = start; i < end; i++) {
            count[str[i] - 'a']++;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 0) continue;
            if (count[i] < k) {
                for (int j = start; j < end; j++) {
                    if (str[j] == 'a' + i) {
                        int l = helper(str, start, j, k);
                        int r = helper(str, j + 1, end, k);
                        return Math.max(l, r);
                    }
                }
            }
        }
        return end - start;
    }

    //--------------------------------------------------------------
    //the same method solution by use python.
    //--------------------------------------------------------------
//    def longestSubstring(self, s, k):
//        for c in set(s):
//            if s.count(c) < k:
//                return max(longestSubstring(t, k) for t in s.split(c))
//        return len(s)


    public static void main(String[] args) {
        LSubstrLeastKRepeatChar test = new LSubstrLeastKRepeatChar();
        String s = "abbbbbbcaa";
        int k = 3;
        System.out.println(test.longestSubstring(s, k));
    }
}
