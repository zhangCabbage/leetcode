package zhang.algorithm.leetcode.question553_Optimal_Division;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 17/6/6
 * Time: 下午10:29
 * To change this template use File | Settings | File Templates.
 */
public class OptimalDivision {
    /**
     * 参考别人思路:
     * x1/x2/x3...xn  ->  (x1/x2)*Y  -> Y 最大为x3*x4*...*xn
     * <p>
     * 93 / 93 test cases passed.
     * Status: Accepted
     * Runtime: 9 ms, bit 37.21%
     *
     * @param nums
     * @return
     */
    public String optimalDivision(int[] nums) {
        if (nums == null || nums.length < 1) return "";
        if (nums.length == 1) return String.valueOf(nums[0]);
        if (nums.length == 2) return String.valueOf(nums[0]) + "/" + String.valueOf(nums[1]);
        StringBuilder sb = new StringBuilder(2 * nums.length + 1);
        sb.append(nums[0]);
        sb.append("/(");
        sb.append(nums[1]);
        for (int i = 2; i < nums.length; i++) {
            sb.append("/" + nums[i]);
        }
        sb.append(")");

        return sb.toString();
    }

    public static void main(String[] args) {
        OptimalDivision test = new OptimalDivision();

    }
}
