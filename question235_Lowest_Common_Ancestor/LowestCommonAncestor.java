package zhang.algorithm.leetcode.question235_Lowest_Common_Ancestor;

import zhang.algorithm.modelUtil.Tree.BinaryTree;
import zhang.algorithm.modelUtil.Tree.TreeNode;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 16/11/2
 * Time: 下午7:51
 * To change this template use File | Settings | File Templates.
 */
public class LowestCommonAncestor {

    private TreeNode common = null;

    /**
     * [我的思路]:
     * 找两个节点, 如果沿着某一条分支找到 p or q 中的一个, 那么往父节点回退的时候, common也回退至父节点
     * 如果检测到某个分支遍历后找到p和q两个节点, 那么直接结束。
     * <p>
     * [说明]
     * 当前题目没有两个val相同的TreeNode节点, 所以我们可以使用val直接比较, 判断节点是否相同。
     * 这里我们使用判断val的方式进行本地测试!!
     * <p>
     * [结果]
     * 27 / 27 test cases passed.
     * Status: Accepted
     * Runtime: 9 - 10ms, bit 26.45% - 14.05%
     * <p>
     * [深入思考]
     * 我思考这道题的时候没有考虑到题目中的 [binary search tree (BST)] 条件, 我的方法具有通用性, 对任意一个二叉树都适用。
     * 这里我应该要利用好二叉搜索树这个条件进行发挥。
     * <p>
     * Review Time: 2017-03-25 12:08:49
     * 代码整合太辣鸡了, 解法详见下一题: question236
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root, p, q);
        return common;
    }

    /**
     * @param root
     * @param p
     * @param q
     * @return
     */
    private int helper(TreeNode root, TreeNode p, TreeNode q) {
        int count = 0;
        if (root == null) return count;

        if (root.val == p.val || root.val == q.val) {
            if (common == null) {
                common = root;
                count = 1;
            } else return 2;
        }
        int res = helper(root.left, p, q);
        if (res == 1) common = root;
        else if (res == 2) return res;

        return count + res + helper(root.right, p, q);
    }

    //----------------------------------------------------------------------
    //方法二
    //----------------------------------------------------------------------

    /**
     * 充分利用二叉搜索树这一条件, 测试结果可能达到 8ms
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }

    public static void main(String[] args) {
        LowestCommonAncestor test = new LowestCommonAncestor();
        int[] nums = {6, 2, 1, 8, 4, 7, 9, 0, 0, 3, 5};
        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(4);
        System.out.println(test.lowestCommonAncestor(BinaryTree.instance(nums).getRoot(), p, q));
    }
}
