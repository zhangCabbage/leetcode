package zhang.algorithm.leetcode.question219_Contains_Duplicate_II;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: zhang_MacPro
 * Date: 16/7/20
 * Time: 下午10:22
 * To change this template use File | Settings | File Templates.
 */
public class ContainsDuplicateII {
    /**
     * <strong>result of test:</strong><br/>
     * 20 / 20 test cases passed
     * Status: Accepted
     * Runtime: 14 ms, bit 13.82%
     * <p>
     * But some times. result is Time Limit Exceeded
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            Integer index = map.get(nums[i]);
            if (index != null && i - index <= k) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }

    /**
     * 使用HashSet, 并用下标指针来维持K窗口
     * <p>
     * <strong>result of test:</strong><br/>
     * 20 / 20 test cases passed
     * Status: Accepted
     * Runtime: 10 ms, bit 75.43%
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();

        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                set.remove(nums[i - k - 1]);
            }
            if (!set.add(nums[i])) {
                return true;
            }
        }

        return false;
    }
}
