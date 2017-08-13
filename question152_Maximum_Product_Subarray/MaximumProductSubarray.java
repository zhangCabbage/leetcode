package zhang.algorithm.leetcode.question152_Maximum_Product_Subarray;

/**
 * Created by IntelliJ IDEA.
 * User: zhang_MacPro
 * Date: 16/7/12
 * Time: 下午7:44
 * To change this template use File | Settings | File Templates.
 */
public class MaximumProductSubarray {
    /**
     * use dynamic programming, but my code is not beautiful!!
     * <p>
     * <strong>result of test:</strong><br/>
     * 183 / 183 test cases passed
     * Status: Accepted
     * Runtime: 4 ms, bit 46.06%
     *
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length < 1) return 0;

        int startMin = nums[0];
        int startMax = startMin;
        int max = startMax;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                startMax = Math.max(nums[i], startMax * nums[i]);
                startMin = Math.min(nums[i], startMin * nums[i]);
            } else {
                int temp = startMax;
                startMax = Math.max(nums[i], startMin * nums[i]);
                startMin = Math.min(nums[i], temp * nums[i]);
            }

            //other coding
//            int temp = startMax;
//            startMax = Math.max(Math.max(nums[i], startMax * nums[i]), startMin * nums[i]);
//            startMin = Math.min(Math.min(nums[i], startMin * nums[i]), temp * nums[i]);

            max = Math.max(max, startMax);
        }

        return max;
    }

    /**
     * reference : [【2ms JAVA O(1) space O(n) time solution】](https://discuss.leetcode.com/topic/50905/2ms-java-o-1-space-o-n-time-solution)
     * <p>
     * <strong>result of test:</strong><br/>
     * 183 / 183 test cases passed
     * Status: Accepted
     * Runtime: 2 ms, bit 92.34%
     *
     * 其分析参见为知笔记 - [我的笔记/找工作/leetcode.md]分析
     *
     * @param nums
     * @return
     */
    public int maxProduct2(int[] nums) {
        int len = nums.length;
        if (len == 1) return nums[0];
        int res = 0;
        int maxP = 0, maxN = Integer.MIN_VALUE, minN = 0;
        int tmp = 1, curMax = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                int cur = minN / maxN;
                curMax = maxP > cur ? maxP : cur;
                if (curMax > res) res = curMax;
                tmp = 1;
                maxP = 0;
                maxN = Integer.MIN_VALUE;
                minN = 0;
                continue;
            }
            tmp *= nums[i];
            if (tmp > maxP) {
                maxP = tmp;
            }
            if (tmp < 0 && maxN == Integer.MIN_VALUE) {
                maxN = tmp;
            } else if (tmp < minN) {
                minN = tmp;
            }
        }
        int cur = minN / maxN;
        curMax = maxP > cur ? maxP : cur;
        if (curMax > res) res = curMax;
        return res;
    }

    /**
     * 模仿上一个的思路进行coding
     * 通过分析我们知道:假如共有15个数, 所有数都不为0, 有5个负数, 下标分别是 1、4、7、10、13
     * 那么最大的数要么为 P(0, 12) 或 P(2, 14)
     * <p>
     * P(0, 12)为从前到后最大的正数
     * P(2, 14)为从前到后最大的负数P(0, 14)除以初始的负数乘积P(0, 1)
     * <p>
     * <strong>result of test:</strong><br/>
     * 183 / 183 test cases passed
     * Status: Accepted
     * Runtime: 2 ms, bit 92.34%
     *
     * @param nums
     * @return
     */
    public int maxProduct3(int[] nums) {
        if (nums == null || nums.length < 1) return 0;
        if (nums.length == 1) return nums[0];

        int res = 0; //last max product result
        int initN = Integer.MIN_VALUE; //init negative number product
        int minN = 0; //min negative number product
        int maxP = 0; //max positive number product
        int curMax = 0; //the current max number product result
        int tmp = 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                int cur = minN / initN;
                curMax = maxP > cur ? maxP : cur;
                if (curMax > res) res = curMax;

                initN = Integer.MIN_VALUE;
                minN = 0;
                maxP = 0;
                tmp = 1;
                continue;
            }
            tmp *= nums[i];
            if (tmp > maxP) {
                maxP = tmp;
            } else if (tmp < 0 && initN == Integer.MIN_VALUE) {
                initN = tmp;
            } else if (tmp < minN) {
                minN = tmp;
            }
        }

        int cur = minN / initN;
        curMax = maxP > cur ? maxP : cur;

        return curMax > res ? curMax : res;
    }

    public static void main(String[] args) {
        MaximumProductSubarray test = new MaximumProductSubarray();
        int[] nums = {-2, 0};
        System.out.println(test.maxProduct(nums));
        System.out.println(test.maxProduct2(nums));
        System.out.println(test.maxProduct3(nums));
    }
}
