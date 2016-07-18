package zhang.algorithm.leetcode.question154_Find_Minimum_RotatedSortedArray_II;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: zhang_MacPro
 * Date: 16/7/12
 * Time: 下午9:32
 * To change this template use File | Settings | File Templates.
 */
public class MinimumRotatedSortedArrayII {
    /**
     * But This way is too slow. Time complexity is O(n*logn)
     * <strong>result of test:</strong><br/>
     * 189 / 189 test cases passed
     * Status: Accepted
     * Runtime: 2 ms, bit 1.56%
     *
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        Arrays.sort(nums);
        return nums[0];
    }

    /**
     * Traversal the int array. Time complexity is O(n)
     * <p>
     * <strong>result of test:</strong><br/>
     * 189 / 189 test cases passed
     * Status: Accepted
     * Runtime: 1 ms, bit 4.88%
     *
     * @param nums
     * @return
     */
    public int findMin2(int[] nums) {
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (min > nums[i]) {
                min = nums[i];
            }
        }
        return min;
    }

    /**
     * use the feature that it is a sorted rotate array. so if the pre one is bigger
     * than the next one, so it is the answer.
     * But it is almost the same as the last one.
     *
     * @param nums
     * @return
     */
    public int findMin3(int[] nums) {
        if (nums == null) return 0;
        if (nums.length == 1) return nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                return nums[i];
            }
        }
        return nums[0];
    }

    /**
     * use the way that fast search.
     * I reference other people.
     * 就是由上一题改变部分演变而来的 ! You must to learn versatility。
     * <p>
     * <strong>result of test:</strong><br/>
     * 189 / 189 test cases passed
     * Status: Accepted
     * Runtime: 1 ms, bit 4.88%
     *
     * @param nums
     * @return
     */
    public int findMin4(int[] nums) {
        if (nums == null) return 0;

        int low = 0;
        int high = nums.length - 1;

        while (low < high && nums[low] >= nums[high]) {
            int mid = (low + high) >> 1;
            if (nums[low] > nums[mid]) {
                high = mid;
            } else if (nums[low] == nums[mid]) {
                low++;
            } else {
                low = mid + 1;
            }
        }

        return nums[low];
    }
}
