package zhang.algorithm.leetcode.question209_Minimum_Size_Subarray_Sum;

/**
 * Created by IntelliJ IDEA.
 * User: zhang_MacPro
 * Date: 16/7/31
 * Time: 上午9:21
 * To change this template use File | Settings | File Templates.
 */
public class MinimumSizeSubarraySum {
    //-------------------------------------------------------------------
    //time complexity is O(n)
    //-------------------------------------------------------------------

    /**
     * use two pointers from start to end, we can easy to deal this problem.
     * But the same method, difference people code different
     * you code is a little complexity.
     * <p>
     * Attention please that never construct code too much.
     * <p>
     * <strong>result of test:</strong><br/>
     * 14 / 14 test cases passed
     * Status: Accepted
     * Runtime: 1 ms, bit 17.25%
     *
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen(int s, int[] nums) {
        int start = 0, end = 0;
        int sum = 0;
        int minLen = nums.length;
        while (end <= nums.length) {
            if (sum < s) {
                if (end == nums.length) {
                    minLen = (start == 0) ? 0 : minLen;
                    break;
                }
                sum += nums[end++];
            } else {
                if (end - start < minLen) {
                    minLen = end - start;
                }
                sum -= nums[start++];
            }
        }

        return minLen;
    }

    /**
     * the same result, but this is more better.
     *
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen2(int s, int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int i = 0, j = 0, sum = 0, min = nums.length;

        while (j < nums.length) {
            sum += nums[j++];

            while (sum >= s) {
                min = Math.min(min, j - i);
                sum -= nums[i++];
            }
        }

        return min == nums.length ? 0 : min;
    }

    //-------------------------------------------------------------------
    //two method that time complexity is O(n*logn)
    //-------------------------------------------------------------------

    /**
     * though find window width to find result
     *
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen3(int s, int[] nums) {
        int i = 1, j = nums.length;
        int min = 0;
        while (i <= j) {
            int width = (i + j) >> 1;
            if (windowsExit(width, nums, s)) {
                min = width;
                j = width - 1;
            } else {
                i = width + 1;
            }
        }

        return min;
    }

    private boolean windowsExit(int size, int[] nums, int s) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i >= size) sum -= nums[i - size];
            sum += nums[i];
            if (sum >= s) return true;
        }
        return false;
    }

    /**
     * this is also to find window.
     * But first traversal from 0 to nums.length,
     * second find whether from cur index has min windows that fix condition
     * then compare cur min value to the min value from cur index
     *
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen4(int s, int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int min = Integer.MAX_VALUE;//this place can not be nums.length
        int[] sums = new int[nums.length];
        sums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sums[i] = nums[i] + sums[i - 1];
        }

        for (int i = 0; i < nums.length; i++) {
            int j = findMinWindow(i, sums, s);
            if (j == nums.length) break;
            min = Math.min(j - i + 1, min);
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }

    private int findMinWindow(int start, int[] sums, int s) {
        int i = start, j = sums.length - 1;
        int offset = start == 0 ? 0 : sums[start - 1];
        while (i <= j) {
            int mid = (i + j) >> 1;
            if (sums[mid] - offset >= s) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }

        return i;
    }

    public static void main(String[] args) {
        MinimumSizeSubarraySum test = new MinimumSizeSubarraySum();
        int[] nums = {1, 2, 3, 4, 5};
        int s = 15;
        System.out.println(test.minSubArrayLen4(s, nums));
    }
}
