package zhang.algorithm.leetcode.question139_Word_Break;

import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: zhang_MacPro
 * Date: 16/7/10
 * Time: 上午10:26
 * To change this template use File | Settings | File Templates.
 */
public class WordBreak {
    //-----------------------------------------------------------------
    //First Version
    //-----------------------------------------------------------------

    /**
     * 被坑了两次之后我想到用递归的方法, 但是其实也是觉得可能太耗时!
     * 果然 --> Submission Result: Time Limit Exceeded
     * 感觉像是分词一样的功能!!
     *
     * @param s
     * @param wordDict 注意这个wordDict的使用,可以多次使用
     * @return
     */
    public boolean wordBreak(String s, Set<String> wordDict) {
        int start = 0;

        for (int i = 1; i <= s.length(); i++) {
            String subStr = s.substring(start, i);
            if (wordDict.contains(subStr)) {
                boolean result = wordBreak(s.substring(i, s.length()), wordDict);
                if (!result) {
                    continue;
                }
                return result;
            }
        }

        //这一句话还不能删掉
        if (start == s.length()) return true;
        return false;
    }

    //-----------------------------------------------------------------
    //Second Version
    //-----------------------------------------------------------------

    /**
     * 使用贪心的策略进行分词, 但是有错误. 这个时候我大概已经萌生了动态规划的想法去解决这道题
     * 但是, 想了一下发现没有思路。
     *
     * @param s
     * @param wordDict 注意这个wordDict的使用,可以多次使用
     * @return
     */
    public boolean wordBreak2(String s, Set<String> wordDict) {
        int start = 0;
        int next = findFastestIndex(s, 0, wordDict);
        while (next > start) {
            start = next;
            next = findFastestIndex(s, start, wordDict);
        }

        if (start == s.length()) return true;
        return false;
    }

    private int findFastestIndex(String s, int start, Set<String> wordDict) {
        int fastest = start;
        for (int i = start + 1; i <= s.length(); i++) {
            if (wordDict.contains(s.substring(start, i))) {
                fastest = i;
            }
        }
        return fastest;
    }

    //-----------------------------------------------------------------
    //Third Version, 可以对比以下几种动态规划方法的不同,为啥有的快有的慢!!优化策略!!
    //-----------------------------------------------------------------

    /**
     * 此动态规划的写法为: 逐渐的从低到高伸长, 直到有一个使得伸到尾部!!
     * <p>
     * <strong>result of test:</strong><br/>
     * 34 / 34 test cases passed
     * Status: Accepted
     * Runtime: 15 ms, bit 12.59%
     *
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak3(String s, Set<String> wordDict) {
        if (s == null || s.length() < 1 || wordDict == null || wordDict.size() < 1) {
            return false;
        }

        boolean[] match = new boolean[s.length() + 1];
        match[0] = true;

        for (int i = 0; i < s.length(); i++) {
            if (match[i]) {
                for (int len = 1; i + len < s.length() + 1; len++) {
                    if (wordDict.contains(s.substring(i, i + len))) {
                        match[i + len] = true;
                    }
                }
            }

        }

        return match[s.length()];
    }

    /**
     * 此动态规划以大局为考虑,dp[i] = true, 表示 0-i 之间能被成功分词
     * 所以遍历 i 从 1 - n, 此为主线。推荐做法!!
     * <p>
     * <strong>result of test:</strong><br/>
     * 34 / 34 test cases passed
     * Status: Accepted
     * Runtime: 13 ms, bit 27.05%
     *
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak4(String s, Set<String> wordDict) {
        if (s == null || s.length() < 1 || wordDict == null || wordDict.size() < 1) {
            return false;
        }

        boolean[] match = new boolean[s.length() + 1];
        match[0] = true;
        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 0; j < i; j++) {
                if (match[j] && wordDict.contains(s.substring(j, i))) {
                    match[i] = true;
                    break;//只要能找到一种切分,那么就说明能分词到达i, 我们就直接跳出,免去不必要计算
                }
            }
        }

        return match[s.length()];
    }

    /**
     * 对动态规划进一步优化!!相当于套一个分支限界法,来限定循环的上下界
     * DP Bottom-up solution with pruning!
     * <p>
     * <strong>result of test:</strong><br/>
     * 34 / 34 test cases passed
     * Status: Accepted
     * Runtime: 2 ms, bit 93.11%
     *
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak5(String s, Set<String> wordDict) {
        int len = s.length();
        boolean[] match = new boolean[len + 1];
        match[0] = true;

        int minLen = Integer.MAX_VALUE;
        int maxLen = Integer.MIN_VALUE;
        for (String word : wordDict) {
            minLen = Math.min(minLen, word.length());
            maxLen = Math.max(maxLen, word.length());
        }

        for (int i = minLen; i < len + 1; i++) {
            for (int j = i - minLen; j >= 0 && j >= i - maxLen; j--) {
                if (match[j] && wordDict.contains(s.substring(j, i))) {
                    match[i] = true;
                    break;
                }
            }
        }
        return match[len];
    }

    public static void main(String[] args) {
        WordBreak test = new WordBreak();

//        String[] strs = {"aaaa", "aaa"};
        String[] strs = {"a", "b", "bbb", "bbbb"};
//        String s = "aaaaaaa";
        String s = "bb";

    }
}
