package zhang.algorithm.leetcode.question300_Longest_Increasing_Subsequence;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 16/11/8
 * Time: 下午8:21
 * To change this template use File | Settings | File Templates.
 * <p>
 * 16/11/08 20:22
 * 今天状态不好, 但是为了维持github上连击的状态, 我无耻的新建了一个问题文件, 但是并没有做.
 * 16/11/10 20:24
 * 要求时间复杂度能达到 O(n * logN)
 * <p>
 * (https://leetcode.com/problems/longest-increasing-subsequence/)
 * 解释参考:
 * https://segmentfault.com/a/1190000003819886
 */
public class LongestIncreasingSubsequence {
    /**
     * 感觉总是差那么一点就能想出来的感觉, 我都要弃疗了都╭(╯^╰)╮
     * 想了一个小时, 楞是没想出个所以然, 然后弃疗, 看了下这道题的tag => [dynamic programming] or [binary search]
     * <p>
     * 方法1 -- 使用动态规划:
     * 初始化dp[i] = 1，即一个元素的递增序列。 假设以i - 1结尾的subarray里的LIS为dp[i - 1]，
     * 那么我们要求以 i 结尾的subarray里的LIS，dp[i]的时候，要把这个新的元素和之前所有的元素进行比较，
     * 同时逐步比较dp[j] + 1与dp[i]，假如发现更长的序列，我们则更新dp[i] = dp[j] + 1
     * <p>
     * Time Complexity - O(n2)， Space Complexity - O(n)。
     * 24 / 24 test cases passed.
     * Status: Accepted
     * Runtime: 68 ms, bit 6.84%
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length < 0) return 0;
        int maxlen = 0;
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp[j] + 1 > dp[i])
                    dp[i] = dp[j] + 1;
            }
            maxlen = Math.max(maxlen, dp[i]);
        }
        return maxlen;
    }

    /**
     * 方法2 -- 耐心排序法
     * Time Complexity - O(n * logN)， Space Complexity - O(n)。
     * 这道题的思想就是, 从前到后排序。
     * 求最大长度的递增子串, 那么例如: 2、8、3、6、4、5
     * 我们最终是要找 2..3..4..5, 这里需要拿一个数组存放最后此递增子序列
     * 每次新来一个数, 插入已排好的数组中, 如果插入位置跟当前最大递增子串长度相同, 那么最大递增子串长度增1
     * <p>
     * 24 / 24 test cases passed.
     * Status: Accepted
     * Runtime: 2 ms, bit 74.91%
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS2(int[] nums) {
        int maxlen = 0;
        int[] sortNums = new int[nums.length];
        for (int num : nums) {
            int index = binarySearch(sortNums, 0, maxlen - 1, num);
            sortNums[index] = num;
            if (index == maxlen) maxlen++;
        }

        return maxlen;
    }

    private int binarySearch(int[] nums, int left, int right, int x) {
        while (left <= right) {
            int mid = left + (right - left >> 1);
            if (nums[mid] == x) return mid;
            else if (nums[mid] > x) right = mid - 1;
            else left = mid + 1;
        }

        return left;
    }

    /**
     * 将原数组排序后转化为Longest Common Subsequence(LCS)的问题
     * But [Memory Limit Exceeded]
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS3(int[] nums) {
        int maxlen = 0;

        return maxlen;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence test = new LongestIncreasingSubsequence();
        int[] nums = {1, 3, 6, 7, 9, 4, 10, 5, 6};
        System.out.println(test.lengthOfLIS(nums));
    }
}
