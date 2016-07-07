package zhang.algorithm.leetcode.question137_Single_Number_II;

/**
 * Created by IntelliJ IDEA.
 * User: zhang_MacPro
 * Date: 16/7/7
 * Time: 下午2:35
 * To change this template use File | Settings | File Templates.
 */
public class SingleNumberII {
    /**
     *
     * handle bit -- 掩码清零法
     *
     * <strong>result of test:</strong><br/>
     * 11 / 11 test cases passed
     * Status: Accepted
     * Runtime: 2 ms, bit 76.36%
     *
     * 参考:[【Acm之家 - 2014 03-28 LeetCode-Single Number II[位运算]】](http://www.acmerblog.com/leetcode-single-number-ii-5394.html)
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int one = 0;//第 ith 位出现一次的位
        int two = 0;//第 ith 位出现两次的位
        for (int i = 0; i < nums.length; i++) {
            two |= one & nums[i];
            //这里设计的很巧妙!!!!
            //如果one中没有,那么保留原来的two
            //如此正好利用one的逢二为0的特性
            one ^= nums[i];

            int tempThree = one & two;//第 ith 位出现三次的位
            one &= ~tempThree;//只要出现过三次,则清零
            two &= ~tempThree;
        }
        //演绎过程见下流程:
        //1、
        //one -> 101 -> 101
        //two -> 0 -> 0
        //three -> 0
        //
        //2、
        //one -> 0 -> 0
        //two -> 101 -> 101
        //three -> 0
        //
        //3、
        //one -> 101 -> 0
        //two -> 101 -> 0
        //three -> 101

        return one;
    }

    /**
     * 我们可以使用一个24size的数组, 来模拟位的控制运算
     *
     * @param nums
     * @return
     */
    public int singleNumber2(int[] nums) {
        int[] bits = new int[32];
        int result = 0;
        for (int i = 0; i < bits.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if ((nums[j] >> i & 1) != 0) {
                    bits[i]++;
                }
            }
            result |= bits[i] % 3 << i;
        }
        return result;
    }

    public static void main(String[] args) {
        SingleNumberII test = new SingleNumberII();
        int[] nums = {3, 2, 3, 2, 3, 2, 1};
        System.out.println(test.singleNumber(nums));
        System.out.println(test.singleNumber2(nums));
    }
}
