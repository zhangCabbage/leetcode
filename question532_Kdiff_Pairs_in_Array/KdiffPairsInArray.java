package zhang.algorithm.leetcode.question532_Kdiff_Pairs_in_Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 17/4/7
 * Time: 下午5:24
 * To change this template use File | Settings | File Templates.
 */
public class KdiffPairsInArray {
    /**
     * k >= 0
     * 思路不清晰
     * 1) k < 0, return 0
     * 2) k = 0, 如果使用map, 这里需要考虑, map.get(nums[i]) != null 的情况
     * 3) k > 0, 如果使用map, 那么只要 map.get(nums[i]) != null 直接continue
     * <p>
     * 72 / 72 test cases passed.
     * Status: Accepted
     * Runtime: 29 ms, bit 78.83%
     *
     * @param nums
     * @param k
     * @return
     */
    public int findPairs(int[] nums, int k) {
        if (k < 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();  //0表示没使用, 1表示使用过
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            Integer tmp = map.get(nums[i]);
            if (tmp != null && ((k != 0) || (k == 0 && tmp == 1))) continue;

            if (map.containsKey(nums[i] + k)) total++;
            if (k != 0 && map.containsKey(nums[i] - k)) total++;

            if (tmp == null) map.put(nums[i], 0);
            else map.put(nums[i], 1);
        }
        return total;
    }

    /**
     * 如何移动前后指针?
     * 72 / 72 test cases passed.
     * Status: Accepted
     * Runtime: 14 ms, bit 99.46%
     *
     * @param nums
     * @param k
     * @return
     */
    public int findPairs2(int[] nums, int k) {
        if (k < 0) return 0;
        Arrays.sort(nums);
        int ans = 0;

        for (int i = 0, j = 1; j < nums.length; ) {
            if (j <= i || nums[i] + k > nums[j])
                j++;
            else if ((i > 0 && nums[i] == nums[i - 1]) || nums[i] + k < nums[j])
                i++;
            else {
                ans++;
                i++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        KdiffPairsInArray test = new KdiffPairsInArray();
        int[] nums = {1, 2, 3, 4, 5};
        int k = -1;
        System.out.println(test.findPairs(nums, k));
        System.out.println(test.findPairs2(nums, k));
    }
}
