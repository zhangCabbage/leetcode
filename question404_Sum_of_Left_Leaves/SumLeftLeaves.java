package zhang.algorithm.leetcode.question404_Sum_of_Left_Leaves;

import zhang.algorithm.modelUtil.Tree.TreeNode;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 16/9/29
 * Time: 下午10:29
 * To change this template use File | Settings | File Templates.
 */
public class SumLeftLeaves {
    /**
     * 102 / 102 test cases passed
     * Status: Accepted
     * Runtime: 8 ms, bit 73.21%
     *
     * @param root
     * @return
     */
    public int sumOfLeftLeaves(TreeNode root) {
        int res = 0;
        if (root != null) {
            if (root.left != null) {
                if (root.left.left == null && root.left.right == null) {
                    res += root.left.val;
                } else {
                    res += sumOfLeftLeaves(root.left);
                }
            }
            res += sumOfLeftLeaves(root.right);
        }
        return res;
    }

    public static void main(String[] args) {
        SumLeftLeaves test = new SumLeftLeaves();
    }
}
