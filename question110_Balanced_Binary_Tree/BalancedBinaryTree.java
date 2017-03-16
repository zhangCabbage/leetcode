package zhang.algorithm.leetcode.question110_Balanced_Binary_Tree;

import zhang.algorithm.modelUtil.Tree.TreeNode;

/**
 * Created by zhang_zack on 16/6/16.
 * <p>
 * Review Time: 2017-03-14 15:02:05
 * 编程时能简化的步骤要简化, 比如这里的return -1表示不平衡二叉树
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
        if (root == null) return 0;
        int lh = treeHeight(root.left);
        if (lh < 0) return -1;
        int rh = treeHeight(root.right);
        if (rh < 0 || Math.abs(lh - rh) > 1) return -1;
        return Math.max(lh, rh) + 1;
    }
}
