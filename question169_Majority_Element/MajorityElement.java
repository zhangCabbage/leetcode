package zhang.algorithm.leetcode.question169_Majority_Element;

/**
 * Created by IntelliJ IDEA.
 * User: zhang_MacPro
 * Date: 16/7/8
 * Time: 上午10:42
 * To change this template use File | Settings | File Templates.
 */
public class MajorityElement {
    /**
     * The way that solve this problem is in the beautify of programming
     * <p>
     * <strong>result of test:</strong><br/>
     * 42 / 42 test cases passed
     * Status: Accepted
     * Runtime: 2 ms, bit 68.17%
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int elem = 0;
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            if (num == 0) {
                elem = nums[i];
                num = 1;
            } else {
                if (nums[i] == elem) {
                    num++;
                } else {
                    num--;
                }
            }
        }
        return elem;
    }
}
