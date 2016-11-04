package zhang.algorithm.leetcode.question448_Find_Numbers_Disappeared_in_Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 16/11/4
 * Time: 上午10:55
 * To change this template use File | Settings | File Templates.
 */
public class NumbersDisappearedInArray {
    /**
     * I can not think that use the original nums array to be the flag.
     * First method to mark the num array to be negative.
     * <p>
     * 4 / 4 test cases passed.
     * Status: Accepted
     * Runtime: 1 ms
     *
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int index = nums[i];
            if (nums[Math.abs(index) - 1] > 0)
                nums[Math.abs(index) - 1] = -nums[Math.abs(index) - 1];
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) list.add(i + 1);
        }

        return list;
    }

    /**
     * Second method to mark the num array to be +nums.length
     *
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers2(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            nums[(nums[i] - 1) % n] += n;
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= n) list.add(i + 1);
        }

        return list;
    }

    public static void main(String[] args) {
        NumbersDisappearedInArray test = new NumbersDisappearedInArray();
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(test.findDisappearedNumbers(nums));
    }
}
