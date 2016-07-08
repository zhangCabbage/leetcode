package zhang.algorithm.leetcode.question229_Majority_Element_II;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: zhang_MacPro
 * Date: 16/7/8
 * Time: 上午10:46
 * To change this template use File | Settings | File Templates.
 */
public class MajorityElementII {
    /**
     * find the number appear more than ⌊ n/3 ⌋ times.
     * The algorithm should run in linear time and in O(1) space!
     * 也就是说此题最好不排序、不用hash, 只能技巧性的遍历下去!
     * 注意题意:此时,顶多有两个满足条件的元素
     * <p>
     * <strong>result of test:</strong><br/>
     * 66 / 66 test cases passed
     * Status: Accepted
     * Runtime: 3 ms, bit 73.85%
     *
     * @param nums
     * @return
     */
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();

        if (nums == null || nums.length < 1) return result;
        if (nums.length == 1) {
            result.add(nums[0]);
            return result;
        }

        int m1 = nums[0];
        int m2 = 0;

        int c1 = 1;
        int c2 = 0;

        int temp = 0;
        for (int i = 1; i < nums.length; i++) {
            temp = nums[i];

            if (temp == m1) c1++;
            else if (temp == m2) c2++;
            else if (c1 == 0) {
                m1 = temp;
                c1 = 1;
            } else if (c2 == 0) {
                m2 = temp;
                c2 = 1;
            } else {
                c1--;
                c2--;
            }

        }

        c1 = 0;
        c2 = 0;

        for (int i = 0; i < nums.length; i++) {
            temp = nums[i];
            if (temp == m1) c1++;
            else if (temp == m2) c2++;
        }

        if (c1 > nums.length / 3) result.add(m1);
        if (c2 > nums.length / 3) result.add(m2);
        return result;
    }
}
