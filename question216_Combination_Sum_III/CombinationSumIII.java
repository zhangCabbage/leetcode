package zhang.algorithm.leetcode.question216_Combination_Sum_III;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: zhang_MacPro
 * Date: 16/7/22
 * Time: 下午10:33
 * To change this template use File | Settings | File Templates.
 */
public class CombinationSumIII {
    List<List<Integer>> result = new ArrayList<List<Integer>>();

    /**
     * we can easy to think that recursive can solve this problem.
     * <strong>result of test:</strong><br/>
     * 18 / 18 test cases passed
     * Status: Accepted
     * Runtime: 1 ms, bit 66%
     *
     * @param k
     * @param n
     * @return
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] nums = new int[k];
        combinationSum3(nums, 0, k, n);
        return result;
    }

    /**
     * @param nums the array use to storage the result
     * @param pre  the last number of recursive
     * @param k    the remain num
     * @param n    the remain sum of num
     */
    public void combinationSum3(int[] nums, int pre, int k, int n) {
        //so which situation can be stop ：k = 0 or k > n
//        if (k > n) return; //这个条件包含在下面这个条件中
        //consider that if the sum of pre+1 ... pre+k is also less than n, so it is worry.
        if (k * pre + (k + 1) * k / 2 > n) return;

        if (k == 0) {
            if (n == 0) {
                List<Integer> list = new ArrayList<Integer>();
                for (int i = 0; i < nums.length; i++) {
                    list.add(nums[i]);
                }
                result.add(list);
            }
            return;
        }
        for (int i = pre + 1; i < 10; i++) {
            if (i > n) break;
            nums[nums.length - k] = i;
            combinationSum3(nums, i, k - 1, n - i);
        }

    }

    //--------------------------------------------------------------------------------------------
    // Review Time: 2017-03-06 16:20:35
    // Use the easy method way to deal with this problem.
    //--------------------------------------------------------------------------------------------

    /**
     * 18 / 18 test cases passed.
     * Status: Accepted
     * Runtime: 3 ms, bit 5.46%
     *
     * @param k
     * @param n
     * @return
     */
    public List<List<Integer>> combinationSum3_2(int k, int n) {
        int[] num = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        helper(result, new ArrayList(), num, n, k, 0);
        return result;
    }

    private void helper(List<List<Integer>> list, List<Integer> res, int[] num, int target, int k, int start) {
        if (k == 0 && target == 0) {
            list.add(res);
        } else {
            for (int i = start; i < num.length; i++) {
                if (num[i] > target) break;
                List<Integer> tmp = new ArrayList(res);
                tmp.add(num[i]);
                helper(list, tmp, num, target - num[i], k - 1, i + 1);
            }
        }
    }

    public static void main(String[] args) {
        CombinationSumIII test = new CombinationSumIII();
        int k = 3;
        int n = 9;
        System.out.println(test.combinationSum3(k, n));
        System.out.println(test.combinationSum3_2(k, n));
    }
}
