package zhang.algorithm.leetcode.question162_Find_Peak_Element;

/**
 * Created by IntelliJ IDEA.
 * User: zhang_MacPro
 * Date: 16/7/17
 * Time: 上午11:47
 * To change this template use File | Settings | File Templates.
 */
public class FindPeakElement {

    /**
     * But this problem need to make the solution should be in logarithmic complexity.
     * My first way is O(n) complexity.
     * So, How can I do to deal this problem ??
     * <p>
     * 这道题可以类推 question153 和 question154 :
     * 一个有序循环数组, 我们使用【二分查找】找其中的最小值
     * 但是, 我却推导不出来, 不能举一反三, 好嫌弃自己的智商啊!!!哭哭。。。
     * <p>
     * <strong>result of test:</strong><br/>
     * 58 / 58 test cases passed
     * Status: Accepted
     * Runtime: 1 ms, bit 2.07%
     *
     * @param nums
     * @return
     */
    public int findPeakElement(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return i;
            }
        }
        return nums.length - 1;
    }

    /**
     * 采用迭代的方法进行二分查找
     * <p>
     * <strong>result of test:</strong><br/>
     * 58 / 58 test cases passed
     * tatus: Accepted
     * Runtime: 0 ms, bit 36.88%
     *
     * @param nums
     * @return
     */
    public int findPeakElement2(int[] nums) {
        return findPeakElement(nums, 0, nums.length - 1);
    }

    private int findPeakElement(int[] nums, int start, int end) {
        if (start == end) return start;

        int mid = (start + end) >> 1;

        if (nums[mid] > nums[mid + 1]) {
            return findPeakElement(nums, start, mid);
        } else {
            return findPeakElement(nums, mid + 1, end);
        }
    }

    /**
     * 使用非迭代的方法进行二分查找
     * the result is the same as last method.
     *
     * @param nums
     * @return
     */
    public int findPeakElement3(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = (low + high) >> 1;
            if (nums[mid] > nums[mid + 1]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        FindPeakElement test = new FindPeakElement();
        int[] nums = {1, 3, 5, 3, 2, 1};
        System.out.println(test.findPeakElement2(nums));
        System.out.println(test.findPeakElement3(nums));
    }
}
