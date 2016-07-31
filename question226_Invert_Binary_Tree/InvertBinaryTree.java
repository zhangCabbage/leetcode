package zhang.algorithm.leetcode.question226_Invert_Binary_Tree;

import zhang.algorithm.modelUtil.Tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by IntelliJ IDEA.
 * User: zhang_MacPro
 * Date: 16/7/31
 * Time: 上午8:51
 * To change this template use File | Settings | File Templates.
 */
public class InvertBinaryTree {
    /**
     * this problem is so easy to use recursive to deal.
     * <strong>result of test:</strong><br/>
     * 68 / 68 test cases passed
     * Status: Accepted
     * Runtime: 0 ms, bit 18.60%
     *
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;

        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
    }

    /**
     * How to use iterative deal this problem. But it is more slow.
     * <strong>result of test:</strong><br/>
     * 68 / 68 test cases passed
     * Status: Accepted
     * Runtime: 1 ms, bit 0.55%
     *
     * @param root
     * @return
     */
    public TreeNode invertTree2(TreeNode root) {
        if (root == null) return root;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        return root;
    }
}
