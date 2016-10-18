package zhang.algorithm.leetcode.question424_Longest_Repeating_Character_Replacement;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 16/10/18
 * Time: 下午9:41
 * To change this template use File | Settings | File Templates.
 */
public class LongestRepeatingCharacter {
    /**
     * 这道题我完全没有思路, 字符串处理的特殊技巧 --> 滑动窗口!
     * use the sliding window mind!
     * (https://discuss.leetcode.com/topic/63494/java-12-lines-o-n-sliding-window-solution-with-explanation)
     * <p>
     * explain as below
     * Since we are only interested in the longest valid substring, our sliding windows need not shrink
     * even if a window may cover an invalid substring.
     * We either grow the window by appending one char on the right,
     * or shift the whole window to the right by one.
     * And we only grow the window when the count of the new char exceeds the historical max count
     * <p>
     * <p>
     * 37 / 37 test cases passed
     * Status: Accepted
     * Runtime: 21 ms
     *
     * @param s
     * @param k
     * @return
     */
    public int characterReplacement(String s, int k) {
        int start = 0, end = 0;
        int maxCount = 0;  //表示一个窗口内曾经可以重复的最大的字符的个数,不会减少,除非有另外的字符超过它!!
        int[] count = new int[26];
        for (; end < s.length(); end++) {
            maxCount = Math.max(maxCount, ++count[s.charAt(end) - 'A']);
            if (end - start + 1 - maxCount > k) {
                //一个窗口内,除了可重复的最大的字符和其余填充的k个字符, 如果还有别的字符, 那么需要向右移动此窗口
                count[s.charAt(start) - 'A']--;
                start++;
            }
        }
        return end - start;
    }

    public static void main(String[] args) {
        LongestRepeatingCharacter test = new LongestRepeatingCharacter();
        String s = "BBCDEF";
        int k = 2;
        System.out.println(test.characterReplacement(s, k));
    }
}
