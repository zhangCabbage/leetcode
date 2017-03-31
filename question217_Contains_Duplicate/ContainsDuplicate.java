package zhang.algorithm.leetcode.question217_Contains_Duplicate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: zhang_MacPro
 * Date: 16/7/20
 * Time: 下午9:40
 * To change this template use File | Settings | File Templates.
 */
public class ContainsDuplicate {

    /**
     * 考虑到既需要速度快, 又最好尽量少的占用空间, 一个想法是使用位图算法。
     * 但是计算发现-2147483648 - 2147483647 这么多数, 至少需要540MB的空间
     * <p>
     * <strong>result of test:</strong><br/>
     * 16 / 16 test cases passed
     * Status: Accepted
     * Runtime: 17 ms, bit 6.88%
     *
     * @param nums
     * @return
     */
    public boolean containsDuplicate2(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        for (int num : nums) {
            if (map.get(num) != null) {
                return true;
            }
            map.put(num, true);
        }
        return false;
    }

    /**
     * Submission Result: Time Limit Exceeded
     * <p>
     * <strong>result of test:</strong><br/>
     * 16 / 16 test cases passed
     * Status: Accepted
     * Runtime: 10 ms, bit 53%
     *
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param nums
     * @return
     */
    public boolean containsDuplicate3(int[] nums) {
        //Java 8 中的新特性 Stream类型
        return nums.length != Arrays.stream(nums).distinct().count();
    }

    //------------------------------------------------------
    //但是,上面两种方法都会出现间歇性的测试超时
    //觉得是不是平台测试有点什么问题, 不稳定什么的可能。
    //------------------------------------------------------


    public static void main(String[] args) {
        ContainsDuplicate test = new ContainsDuplicate();
        int[] nums = {1, 2, 3, 4, 5, 5};
        System.out.println(test.containsDuplicate(nums));
    }
}
