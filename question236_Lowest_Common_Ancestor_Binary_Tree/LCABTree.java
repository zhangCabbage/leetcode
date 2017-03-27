package zhang.algorithm.leetcode.question236_Lowest_Common_Ancestor_Binary_Tree;

import zhang.algorithm.modelUtil.Tree.BinaryTree;
import zhang.algorithm.modelUtil.Tree.TreeNode;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 17/3/25
 * Time: 上午11:36
 * To change this template use File | Settings | File Templates.
 */
public class LCABTree {
    private TreeNode common = null;
    private int count = 0;

    /**
     * 错误解法, 为什么会错误呢?
     * 这道题是结合我错误理解question235导致的解法, 原来并没有使用全局的count来记录找到了几个节点
     * 正是因为这里我想直接function返回TreeNode, 使用了全局的count,
     * 导致在root.left之后, if(count == 1) common = root, 这一步错误!!
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return root;

        if (root.val == p.val || root.val == q.val) {
            count++;
            if (common == null) common = root;
            else return common;
        }

        TreeNode res = lowestCommonAncestor(root.left, p, q);
        if (count == 2) return res;
        else if (count == 1) common = root;
        return lowestCommonAncestor(root.right, p, q);
    }

    //----------------------------------------------------------------------------------------
    //参考他人解法: https://discuss.leetcode.com/topic/18566/my-java-solution-which-is-easy-to-understand
    //----------------------------------------------------------------------------------------

    /**
     * 假如p、q一定在root树中存在, 那么可以使用这个办法
     * find the lowest common ancestor (LCA) of two given nodes in the tree.
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        TreeNode right = lowestCommonAncestor2(root.right, p, q);
        if (left != null && right != null) return root;
        return left == null ? right : left;
    }

    public static void main(String[] args) {
        LCABTree test = new LCABTree();
        int[] nums = {1, 2, 3, 0, 4};
        TreeNode root = BinaryTree.instance(nums).getRoot();
        System.out.println(test.lowestCommonAncestor(root, new TreeNode(4), new TreeNode(1)));
    }
}
