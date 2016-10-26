package zhang.algorithm.leetcode.question260_Single_Number_III;

import zhang.algorithm.modelUtil.Array.ArrayTool;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 16/10/26
 * Time: 下午7:14
 * To change this template use File | Settings | File Templates.
 */
public class SingleNumberIII {
    /**
     * 因为前段时间看到过一个面试题解析, 其中层层递进的分析了如何找出仅有的两个唯一数
     *
     * 30 / 30 test cases passed
     * Status: Accepted
     * Runtime: 2 ms, bit 34.88%
     *
     * @param nums
     * @return
     */
    public int[] singleNumber(int[] nums) {
        int[] res = new int[2];

        int xor = 0;
        for (int num : nums) xor ^= num;

        //找到最低位的1
        int count = 31;
        int tmp = xor;
        if ((tmp << 16) != 0) { count -= 16; tmp <<= 16; }
        if ((tmp << 8) != 0) { count -= 8; tmp <<= 8; }
        if ((tmp << 4) != 0) { count -= 4; tmp <<= 4; }
        if ((tmp << 2) != 0) { count -= 2; tmp <<= 2; }
        if ((tmp << 1) != 0) count -= 1;

        //找到第一个数
        tmp = xor;
        for (int num : nums) {
            if((num & (1<<count)) != 0)
                tmp ^= num;
        }
        res[0] = tmp;

        //找到第二个数
        tmp = xor;
        for (int num : nums) {
            if((num & (1<<count)) == 0)
                tmp ^= num;
        }
        res[1] = tmp;

        return res;
    }

    /**
     * 思路你了解,但是以上你的代码还可以继续改进。
     * 关于找到一个数二进制中的最后一位1的方法, 这里我们用到了计算机存储数的方式, 以补码的形式。
     * eg:
     * +6 --> 00000000000000000000000000000110
     * -6 --> 11111111111111111111111111111010
     * 所以, x &= -x 即为最后一位的位置
     *
     * 30 / 30 test cases passed
     * Status: Accepted
     * Runtime: 1 ms, bit 78.66%
     *
     * @param nums
     * @return
     */
    public int[] singleNumber2(int[] nums) {
        int[] res = new int[2];

        int xor = 0;
        for (int num : nums) xor ^= num;

        xor &= -xor; //important!!

        for(int num : nums){
            if((num & xor) == 0){
                res[0] ^= num;
            }else{
                res[1] ^= num;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        SingleNumberIII test = new SingleNumberIII();
        int[] nums = {1, 2, 1, 3, 2, 5};
        ArrayTool.printArray(test.singleNumber(nums));
        ArrayTool.printArray(test.singleNumber2(nums));
    }
}
