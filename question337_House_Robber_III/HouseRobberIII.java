package zhang.algorithm.leetcode.question337_House_Robber_III;

import zhang.algorithm.modelUtil.Tree.BinaryTree;
import zhang.algorithm.modelUtil.Tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 16/10/31
 * Time: 下午7:33
 * To change this template use File | Settings | File Templates.
 */
public class HouseRobberIII {
    /**
     * 第一次受两个栗子的引导错误理解题意, 简单的以为是树的houseRobber的层次遍历, 但是实现之后提交发现不对!!
     * 远不是这样,
     * 尝试从[中序遍历]或者[后序遍历]的方式来着手这道题, 但是仍是没想出来!
     *
     * @param root
     * @return
     */
    public int rob(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.offer(root);
        int pre1 = 0, pre2 = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int cur = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                cur += node.val;
            }
            if (pre2 == 0) pre2 = cur;
            else if (pre1 == 0) pre1 = Math.max(cur, pre2);
            else {
                cur = Math.max(pre1, pre2 + cur);
                pre2 = pre1;
                pre1 = cur;
            }
        }
        return Math.max(pre1, pre2);
    }

    /**
     * 后序遍历 -- 返回两个结果, res[0]包括当前节点的最大值, res[1]不包括当前节点的最大值
     * You can see this beautiful solution explain.
     * (https://discuss.leetcode.com/topic/39834/step-by-step-tackling-of-the-problem)
     * <p>
     * 124 / 124 test cases passed.
     * Status: Accepted
     * Runtime: 1 ms bit 78.64%
     *
     * @param root
     * @return
     */
    public int rob2(TreeNode root) {
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }

    private int[] dfs(TreeNode root) {
        int[] res = new int[2];
        if (root == null) return res;
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        res[0] = left[1] + right[1] + root.val;
        res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return res;
    }

    public static void main(String[] args) {
        HouseRobberIII test = new HouseRobberIII();
        int[] nums = {2, 1, 3, 0, 4};
        System.out.println(test.rob(BinaryTree.instance(nums).getRoot()));
        System.out.println(test.rob2(BinaryTree.instance(nums).getRoot()));
    }
}
