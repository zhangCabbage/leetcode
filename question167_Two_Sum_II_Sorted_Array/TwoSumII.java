package zhang.algorithm.leetcode.question167_Two_Sum_II_Sorted_Array;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 16/9/23
 * Time: 下午8:00
 * To change this template use File | Settings | File Templates.
 */
public class TwoSumII {
    /**
     * easy!
     * <p>
     * 15 / 15 test cases passed
     * Status: Accepted
     * Runtime: 1 ms, bit 37.20%
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;
        while (start < end) {
            int temp = numbers[start] + numbers[end];
            if (temp > target) {
                end--;
            } else if (temp < target) {
                start++;
            } else {
                break;
            }
        }
        int[] res = new int[2];
        res[0] = start + 1;
        res[1] = end + 1;
        return res;
    }

    public static void main(String[] args) {
        TwoSumII test = new TwoSumII();
    }
}
