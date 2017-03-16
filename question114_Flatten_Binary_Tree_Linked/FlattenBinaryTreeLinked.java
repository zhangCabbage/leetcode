package zhang.algorithm.leetcode.question114_Flatten_Binary_Tree_Linked;

import zhang.algorithm.modelUtil.Tree.TreeNode;

/**
 * Created by zhang_zack on 16/6/20.
 * <p>
 * Review Timew: 2017-03-15 12:12:27
 */
public class FlattenBinaryTreeLinked {
    /**
     * the demand of this problem is like below:
     * <p>
     * ----1
     * --2   3
     * -----4 5
     * <p>
     * =>
     * <p>
     * ----1
     * -----2
     * ------3
     * -------4
     * --------5
     * <p>
     * nothing to do with the order of the number!
     * <br/>
     * <strong>result of test:</strong><br/>
     * 225 / 225 test cases passed
     * Status: Accepted
     * Runtime: 1 ms, bit 28.47%
     *
     * @param root
     */
    public void flatten(TreeNode root) {
        flattenTree(null, root);
    }

    /**
     * @param tail the tail of previous tree
     * @param next the root of the next tree we want to flatten
     * @return
     */
    private TreeNode flattenTree(TreeNode tail, TreeNode next) {
        if (next == null) {
            return tail;
        }
        if (tail != null) {
            tail.right = next;
            tail.left = null;
        }
        TreeNode temp = next.right;
        return flattenTree(flattenTree(next, next.left), temp);
    }


    /**
     * @param root
     */
    public void flatten2(TreeNode root) {
        if (root == null) return;

        if (root.left != null) {
            TreeNode tmp = root.left;
            while (tmp.right != null) {
                tmp = tmp.right;
            }
            tmp.right = root.right;
            root.right = root.left;
            root.left = null;
        }

        flatten(root.right);
    }
}
