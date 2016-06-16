package zhang.algorithm.leetcode.question110_Balanced_Binary_Tree;

import zhang.algorithm.modelUtil.Tree.TreeNode;

/**
 * Created by zhang_zack on 16/6/16.
 */
public class BalancedBinaryTree {

    /**
     * <br/>
     * <strong>result of test:</strong><br/>
     * 226 / 226 test cases passed<br/>
     * Status: Accepted<br/>
     * Runtime: 1 ms, bit 80.56%<br/>
     *
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        return treeHeight(root) < 0 ? false : true;
    }

    /**
     * find the depth of child tree
     * -1 mean is not balance
     *
     * @param root
     * @return
     */
    private int treeHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = treeHeight(root.left);
        if (leftDepth < 0) {
            return -1;
        }
        int rightDepth = treeHeight(root.right);
        if (rightDepth < 0 || Math.abs(leftDepth - rightDepth) > 1) {
            return -1;
        }
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
