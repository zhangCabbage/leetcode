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
     * @param nums
     * @return
     */
    public int findPeakElement2(int[] nums) {

        return 0;
    }
}
