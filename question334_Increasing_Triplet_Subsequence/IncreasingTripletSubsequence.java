package zhang.algorithm.leetcode.question334_Increasing_Triplet_Subsequence;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 16/11/7
 * Time: 下午8:38
 * To change this template use File | Settings | File Templates.
 */
public class IncreasingTripletSubsequence {
    /**
     * O(n) time complexity and O(1) space complexity.
     * 我想半天, 还是没有头绪, 但是当我定下心来慢慢分析时, 我发现我竟然能解决出来了!!
     * 稳定心神, 一个个下标i的分析nums数的可能性, 就会发现规律!
     * <p>
     * 61 / 61 test cases passed.
     * Status: Accepted
     * Runtime: 1 ms, bit 28.03%
     *
     * @param nums
     * @return
     */
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 1) return false;
        int min = nums[0], first = min, second = min;
        int index = 1;
        for (int i = 0; i < nums.length; i++) {
            if (index == 1) {
                if (nums[i] <= first) {
                    first = nums[i];
                    min = first;
                } else {
                    second = nums[i];
                    index++;
                }
            } else {
                if (nums[i] > second) return true;
                else if (nums[i] <= min) {
                    min = nums[i];
                } else {
                    first = min;
                    second = nums[i];
                }
            }
        }
        return false;
    }

    /**
     * Very brilliant idea!
     * 这种方法清晰明了, 但是不方便找出一个可行的三元组解
     * 而我的方法最后可以得到一个三元组解 --> <first, second, nums[i]>
     *
     * @param nums
     * @return
     */
    public boolean increasingTriplet2(int[] nums) {
        int small = Integer.MAX_VALUE, big = small;
        for (int n : nums) {
            if (n > big) return true;
            else if (n <= small) small = n;
            else big = n;
        }
        return false;
    }

    public static void main(String[] args) {
        IncreasingTripletSubsequence test = new IncreasingTripletSubsequence();
        int[] nums = {1, 4, 3};
        System.out.println(test.increasingTriplet(nums));
    }
}
