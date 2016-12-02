package zhang.algorithm.leetcode.question190_Reverse_Bits;

/**
 * Created by IntelliJ IDEA.
 * User: zhang_MacPro
 * Date: 16/7/14
 * Time: 上午10:58
 * To change this template use File | Settings | File Templates.
 */
public class ReverseBits {
    /**
     * the problem is reference the [【LeetCode(190) Reverse Bits】](http://blog.csdn.net/feliciafay/article/details/44536827)
     * use the normal method way that solve the problem reverse int.
     * 注意,Java为有符号数,负数移位的时候需要注意!!
     * 所以此方法移位的时候,会造成错误!!
     *
     * @param n
     * @return
     */
    public int reverseBits(int n) {
        int sum = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            sum = (sum << 1) | ((n & mask) >> i);
            mask <<= 1;
        }
        return sum;
    }

    /**
     * <strong>result of test:</strong><br/>
     * 600 / 600 test cases passed
     * Status: Accepted
     * Runtime: 2 ms, bit 50.87%
     *
     * @param n
     * @return
     */
    public int reverseBits2(int n) {
        int sum = 0;
        for (int i = 0; i < 32; i++) {
            sum = (sum << 1) | (n >> i & 1);
        }
        return sum;
    }

    /**
     * Are you remember that the problem 151 reverse words string.
     * They are have the similar way to solve.You can solve it like merge sort.
     * <p>
     * 0x55555555 = 0101 0101 0101 0101 0101 0101 0101 0101
     * 0xAAAAAAAA = 1010 1010 1010 1010 1010 1010 1010 1010
     * 0x7FFFFFFF = 0111 1111 1111 1111 1111 1111 1111 1111
     * 0x33333333 = 0011 0011 0011 0011 0011 0011 0011 0011
     * 0xCCCCCCCC = 1100 1100 1100 1100 1100 1100 1100 1100
     * 0x3FFFFFFF = 0011 1111 1111 1111 1111 1111 1111 1111
     * <p>
     * but the result is the same as last method.
     *
     * @param n
     * @return
     */
    public int reverseBits3(int n) {
        n = ((n & 0x55555555) << 1) | (((n & 0xAAAAAAAA) >> 1) & 0x7FFFFFFF); //防止负号移位
        n = ((n & 0x33333333) << 2) | (((n & 0xCCCCCCCC) >> 2) & 0x3FFFFFFF);
        n = ((n & 0x0F0F0F0F) << 4) | (((n & 0xF0F0F0F0) >> 4) & 0x0FFFFFFF);
        n = ((n & 0x00FF00FF) << 8) | (((n & 0xFF00FF00) >> 8) & 0x00FFFFFF);
        n = ((n & 0x0000FFFF) << 16) | (((n & 0xFFFF0000) >> 16) & 0x0000FFFF);
        return n;
    }

    public static void main(String[] args) {
//        System.out.println(-1 & 1);//1
        ReverseBits test = new ReverseBits();
        System.out.println(test.reverseBits2(65536));
        System.out.println(test.reverseBits3(65536));
    }
}
