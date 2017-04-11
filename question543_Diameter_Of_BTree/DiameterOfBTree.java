package zhang.algorithm.leetcode.question543_Diameter_Of_BTree;

import zhang.algorithm.modelUtil.Tree.TreeNode;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 17/4/11
 * Time: 上午11:44
 * To change this template use File | Settings | File Templates.
 */
public class DiameterOfBTree {
    /**
     * 106 / 106 test cases passed.
     * Status: Accepted
     * Runtime: 24 ms
     *
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int l_r = max(root.left) + max(root.right);
        int res = Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right));
        return Math.max(res, l_r);
    }

    private int max(TreeNode root) {
        if (root == null) return 0;
        int l = max(root.left);
        int r = max(root.right);
        return Math.max(l, r) + 1;
    }

    //---------------------------------------------------------------------------------------------------------
    // 我的方法直接硬计算diameterOfBinaryTree, 感觉遍历两边
    // 可以用 max 来记录
    //---------------------------------------------------------------------------------------------------------
    private int max;

    public int diameterOfBinaryTree2(TreeNode root) {
        maxDepth(root);
        return max;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        max = Math.max(max, l + r);
        return Math.max(l, r) + 1;
    }

    public static void main(String[] args) {
        DiameterOfBTree test = new DiameterOfBTree();
    }
}
