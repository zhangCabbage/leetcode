package zhang.algorithm.leetcode.question414_Third_Maximum_Number;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 16/10/20
 * Time: 下午8:50
 * To change this template use File | Settings | File Templates.
 */
public class ThirdMaximumNumber {
    /**
     * 不太会掌握程序细致的控制, 导致这类型一个easy的问题, 我花费很长时间仍是没出来
     * Wrong!
     * 自己把自己弄晕了, 最后逻辑混乱了!
     *
     * @param nums
     * @return
     */
    public int thirdMax(int[] nums) {
        int[] max = new int[3];
        int enough = 0;

        for (int i = 0; i < nums.length; i++) {
            //比较已有max数组
            int j = enough - 1;
            for (; j >= 0; j--) {
                if (nums[i] <= max[j]) break;
            }

            if (j == 2) continue;
            if (j != -1 && nums[i] == max[j]) continue;

            int k = enough == 3 ? enough - 1 : enough++;
            while (k > (j == -1 ? 0 : j)) {
                max[k--] = max[k];
            }
            max[k] = nums[i];
        }
        return enough != 3 ? max[0] : max[2];
    }

    /**
     * 需要选择正确的逻辑方式, 尽量避免复杂的逻辑方式!!
     * <p>
     * 26 / 26 test cases passed
     * Status: Accepted
     * Runtime: 4 ms
     *
     * @param nums
     * @return
     */
    public int thirdMax2(int[] nums) {
        long max, mid, small, count;
        max = mid = small = Long.MIN_VALUE;
        count = 0;

        for (int x : nums) {
            if (x == max || x == mid) continue;
            if (x > max) {
                small = mid;
                mid = max;
                max = x;
                count++;
            } else if (x > mid) {
                small = mid;
                mid = x;
                count++;
            } else if (x >= small) {
                //[1, 2, -2147483648]
                small = x;
                count++;
            }
        }

        return count >= 3 ? (int) small : (int) max;
    }

    public static void main(String[] args) {
        ThirdMaximumNumber test = new ThirdMaximumNumber();
        int[] nums = {1, -2147483648, 2};
        System.out.println(test.thirdMax2(nums));
    }
}
