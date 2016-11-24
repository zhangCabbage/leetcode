package zhang.algorithm.leetcode.question462_Min_Moves_Equal_Array_Elements_II;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 16/11/22
 * Time: 下午8:18
 * To change this template use File | Settings | File Templates.
 * [question]
 * https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/
 * ==>
 * update
 * Date: 16/11/24
 * Time: 下午7:56
 */

public class MinMovesEqualArrayElemsII {
    /**
     * 猜错了,tag竟然不是dp, 而是math
     * 没想出来,最笨的办法
     * 折腾一个小时想出的办法仍是Time Limit Exceeded
     *
     * @param nums
     * @return
     */
    public int minMoves2(int[] nums) {
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        long avg = sum / nums.length;
        while (true) {
            long cur = 0, front = 0, back = 0;
            for (int i = 0; i < nums.length; i++) {
                front += Math.abs(avg - 1 - nums[i]);
                cur += Math.abs(avg - nums[i]);
                back += Math.abs(avg + 1 - nums[i]);
            }

            if (cur <= front && cur <= back) return (int) cur;
            else if (front < back) avg--;
            else if (back < front) avg++;
        }
    }

    /**
     * The discuss answer 1.
     * 29 / 29 test cases passed.
     * Status: Accepted
     * Runtime: 8 ms
     * <p>
     * moves = |k-a1| + |k-a2| + ... + |k-ai| + ... + |k-an|.
     * if bi > k and cj < k
     * so the above formula is equivalent below:
     * moves = (b1-k) + ... + (bj-k) + ... + (k-c1) + ... + (k-cj)
     * 我们求导得:
     * d(moves)/d(k) = Count(c) - Count(b) = 0
     * so when Count(c) = Count(b), the moves is min
     * reference: (https://discuss.leetcode.com/topic/68762/java-solution-with-thinking-process)
     * so we can use QuickSelect O(n) to solve this problem.
     *
     * @param nums
     * @return
     */
    public int minMoves2_2(int[] nums) {
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        int count = 0;
        while (i < j) {
            count += nums[j] - nums[i];
            i++;
            j--;
        }
        return count;
    }

    public static void main(String[] args) {
        MinMovesEqualArrayElemsII test = new MinMovesEqualArrayElemsII();
        int[] nums = {203125577, -349566234, 230332704, 48321315, 66379082, 386516853, 50986744, -250908656, -425653504, -212123143};
        System.out.println(test.minMoves2(nums));
    }
}
