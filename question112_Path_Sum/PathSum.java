package zhang.algorithm.leetcode.question112_Path_Sum;

import zhang.algorithm.modelUtil.Tree.TreeNode;

/**
 * Created by zhang_zack on 16/6/20.
 */
public class PathSum {
    /**
     * depth-first-traversal, note that the value of node maybe negative number,
     * so we can not stop program by judge whether sum is zero or not
     * <br/>
     * <strong>result of test:</strong><br/>
     * 114 / 114 test cases passed<br/>
     * Status: Accepted<br/>
     * Runtime: 1 ms<br/>
     *
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && root.val == sum) {
            return true;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
