package zhang.algorithm.leetcode.question153_Find_Minimum_RotatedSortedArray;

/**
 * Created by IntelliJ IDEA.
 * User: zhang_MacPro
 * Date: 16/7/12
 * Time: 下午8:59
 * To change this template use File | Settings | File Templates.
 */
public class MinimumInRotatedSortedArray {
    /**
     * <strong>result of test:</strong><br/>
     * 146 / 146 test cases passed
     * Status: Accepted
     * Runtime: 1 ms, bit 3.29%
     * <p>
     * always think that my code is very ugly and not easy to read!
     *
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        return recursiveFindMin(nums, 0, nums.length - 1);
    }

    private int recursiveFindMin(int[] nums, int left, int right) {
        if (left == right) return nums[left];
        if (left + 1 == right) return Math.min(nums[left], nums[right]);

        int mid = (left + right) >> 1;
        if (nums[left] > nums[mid] || (nums[left] < nums[mid] && nums[mid] < nums[right]))
            return recursiveFindMin(nums, left, mid);
        return recursiveFindMin(nums, mid + 1, right);
    }

    /**
     * 虽然时间结果相同, 但是代码逻辑更加简单,清楚!!
     *
     * @param nums
     * @return
     */
    public int findMin2(int[] nums) {
        return findMin(nums, 0, nums.length - 1);
    }

    private int findMin(int[] nums, int left, int right) {
        if (left == right || nums[left] < nums[right]) return nums[left];

        int mid = (left + right) >> 1;
        if (nums[left] > nums[mid])
            return findMin(nums, left, mid);
        return findMin(nums, mid + 1, right);
    }

    public static void main(String[] args) {
        MinimumInRotatedSortedArray test = new MinimumInRotatedSortedArray();
        int[] nums = {2, 3, 1};
        System.out.println(test.findMin(nums));
    }
}
