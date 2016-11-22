package zhang.algorithm.leetcode.question462_Min_Moves_Equal_Array_Elements_II;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 16/11/22
 * Time: 下午8:18
 * To change this template use File | Settings | File Templates.
 * <p>
 * https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/
 */

public class MinMovesEqualArrayElemsII {
    /**
     * 猜错了,tag竟然不是dp, 而是math
     * 没想出来,最笨的办法, 但是Time Limit Exceeded
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

    public static void main(String[] args) {
        MinMovesEqualArrayElemsII test = new MinMovesEqualArrayElemsII();
        int[] nums = {203125577, -349566234, 230332704, 48321315, 66379082, 386516853, 50986744, -250908656, -425653504, -212123143};
        System.out.println(test.minMoves2(nums));
    }
}
