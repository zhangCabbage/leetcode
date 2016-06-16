package zhang.algorithm.leetcode.question100_Same_Tree;

import zhang.algorithm.modelUtil.Tree.TreeNode;

/**
 * Created by zhang_zack on 16/6/8.
 */
public class IsSameTree {
    /**
     * 我自己的思路,但是感觉代码比较冗余,不太简洁,<br/>
     * <br/>
     * <strong>测试结果:</strong><br/>
     * 54 / 54 test cases passed<br/>
     * Status: Accepted<br/>
     * Runtime: 0 ms,击败了10.42%<br/>
     *
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val == q.val && isSameTree(p.left, q.left)) {
            return isSameTree(p.right, q.right);
        }
        return false;
    }

    /**
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree2(TreeNode p, TreeNode q) {
        return (p == null && q == null) || (p != null && q != null && p.val == q.val && isSameTree2(p.left, q.left) && isSameTree2(p.right, q.right));
    }

}
