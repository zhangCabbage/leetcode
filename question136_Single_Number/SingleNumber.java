package zhang.algorithm.leetcode.question136_Single_Number;

/**
 * Created by IntelliJ IDEA.
 * User: zhang_MacPro
 * Date: 16/7/5
 * Time: 下午8:56
 * To change this template use File | Settings | File Templates.
 */
public class SingleNumber {
    /**
     * About Bit Manipulation(位操作)
     * 异或 : a⊕b = (¬a ∧ b) ∨ (a ∧¬b)
     *
     * a ⊕ a = 0
     * a ⊕ 0 = a
     *
     * <strong>result of test:</strong><br/>
     * 15 / 15 test cases passed
     * Status: Accepted
     * Runtime: 1 ms, bit 34%
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int elem = 0;
        for(int i=0; i<nums.length; i++){
            elem ^= nums[i];
        }
        return elem;
    }
}
