package zhang.algorithm.leetcode.question530_Minimum_Absolute_Difference_BST;

import zhang.algorithm.modelUtil.Tree.BinarySearchTree;
import zhang.algorithm.modelUtil.Tree.TreeNode;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 17/4/22
 * Time: 下午5:06
 * To change this template use File | Settings | File Templates.
 */
public class MinAbsDiffBST {
    private TreeNode preNode = null;

    /**
     * 186 / 186 test cases passed.
     * Status: Accepted
     * Runtime: 18 ms, bit 58.81%
     *
     * @param root
     * @return
     */
    public int getMinimumDifference(TreeNode root) {
        if (root == null) return Integer.MAX_VALUE;
        int l = getMinimumDifference(root.left);
        int dis = preNode == null ? l : Math.min(l, Math.abs(root.val - preNode.val));
        preNode = root;
        return Math.min(dis, getMinimumDifference(root.right));
    }

    public static void main(String[] args) {
        MinAbsDiffBST test = new MinAbsDiffBST();
        int[] nums = {236, 104, 701, 0, 227, 0, 911};
        TreeNode root = BinarySearchTree.instance(nums).getRoot();
        System.out.println(test.getMinimumDifference(root));
    }
}
