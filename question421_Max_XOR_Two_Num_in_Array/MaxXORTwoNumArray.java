package zhang.algorithm.leetcode.question421_Max_XOR_Two_Num_in_Array;

import java.util.HashSet;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 16/11/5
 * Time: 下午4:45
 * To change this template use File | Settings | File Templates.
 */
public class MaxXORTwoNumArray {
    /**
     * (https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/)
     * How should I do to solve this problem?
     * I can not to deal with it.
     * <p>
     * 这道题暴力解法为O(n ^ 2), 显然是不符合要求的, 对于下面这个解法, 我只能呵呵哒, 完全不好理解!
     * 这道题的核心思想是: a ^ b = c, c ^ a = b, c ^ b = a
     * can you understand?
     * <p>
     * 我说一些似是而非的解释....
     * nums中，与mask按位与结果为0的所有数字，记为nums0
     * nums中，与mask按位与结果为1的所有数字，记为nums1
     * =>
     * 如果nums0与nums1其一为空，说明nums中所有数字在该二进制位同0或同1，其异或结果一定为0
     * 如果nums0与nums1均不为空，说明nums中的数字在该位的异或值为1
     * ..
     * 然后把mask向右移一位, 所有num0, num1拿去进行下一位的比较
     * <p>
     * <p>
     * 29 / 29 test cases passed.
     * Status: Accepted
     * Runtime: 96 ms, bit 63.13%
     * <p>
     * Review Time: 2017-03-03 10:37:53
     * 这道题有点类似一个数组中找有没有两个数和为x的
     *
     * @param nums
     * @return
     */
    public int findMaximumXOR(int[] nums) {
        int max = 0, mask = 0;
        for (int i = 30; i >= 0; i--) {
            //从左到右, 只关注最大的
            mask |= (1 << i);
            HashSet<Integer> set = new HashSet<>();
            for (int num : nums) set.add(mask & num);

            int tmp = max | (1 << i);
            for (int prefix : set)
                if (set.contains(tmp ^ prefix)) {  //why? it is very important.
                    //c ^ a ==> wether have a 'b' to make the 'a ^ b' to max
                    max = tmp;
                    break;
                }
        }

        return max;
    }

    /**
     * 还可以使用字典树的形式, 请参见(https://discuss.leetcode.com/topic/63207/java-o-n-solution-using-trie)
     * 但是总体上来说, trie树的方式, 跟O(n^2)的思想差不多, 不过转换成了O(32n)的形式。
     *
     * @param nums
     * @return
     */
    public int findMaximumXOR2(int[] nums) {
        int max = 0, mask = 0;

        return max;
    }

    public static void main(String[] args) {
        MaxXORTwoNumArray test = new MaxXORTwoNumArray();
        int[] nums = {3, 10, 5, 25, 2, 8};
        System.out.println(test.findMaximumXOR(nums));
    }
}
