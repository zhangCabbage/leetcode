package zhang.algorithm.leetcode.question228_Summary_Ranges;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: zhang_MacPro
 * Date: 16/8/13
 * Time: 下午5:24
 * To change this template use File | Settings | File Templates.
 */
public class SummaryRanges {
    /**
     * how to reduce the judge condition?
     * this code every index i need three time judge
     * <p>
     * <strong>result of test:</strong>
     * 27 / 27 test cases passed
     * Status: Accepted
     * Runtime: 1 ms, bit 3.18%
     *
     * @param nums
     * @return
     */
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();

        if (nums == null || nums.length == 0) return res;

        for (int i = 0, start = 0; i < nums.length; i++) {
            if (i == nums.length - 1 || nums[i] < nums[i + 1] - 1) {
                res.add(nums[start] + (i == start ? "" : "->" + nums[i]));
                start = i + 1;
            }
        }

        return res;
    }

    /**
     * this way of loop can avoid many judge
     * the result of this way can be 0ms
     *
     * @param nums
     * @return
     */
    public List<String> summaryRanges2(int[] nums) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            while (i < nums.length - 1 && nums[i + 1] - nums[i] == 1) i++;
            if (a == nums[i]) {
                res.add(a + "");
            } else {
                res.add(a + "->" + nums[i]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SummaryRanges test = new SummaryRanges();
        int[] nums = {0};
        System.out.println(test.summaryRanges(nums));
    }
}
