package zhang.algorithm.leetcode.question230_Kth_Smallest_Element_in_BST;

import zhang.algorithm.modelUtil.Tree.BinarySearchTree;
import zhang.algorithm.modelUtil.Tree.TreeNode;

import java.util.Stack;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 16/11/19
 * Time: 下午7:40
 * To change this template use File | Settings | File Templates.
 * <p>
 * The optimal runtime complexity should be O(height of BST).
 */
public class KthSmallestElementBST {
    /**
     * 91 / 91 test cases passed.
     * Status: Accepted
     * Runtime: 1 ms, bit 51.49%
     *
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {
        int leftNodes = traverse(root.left);

        if (leftNodes == k - 1) return root.val;
        else if (leftNodes < k - 1) return kthSmallest(root.right, k - leftNodes - 1);
        else return kthSmallest(root.left, k);
    }

    private int traverse(TreeNode root) {
        int num = 0;

        if (root != null) {
            num++;
            num += traverse(root.left);
            num += traverse(root.right);
        }

        return num;
    }

    /**
     * 使用中序遍历, 我本来以为会比第一种方法更快, 谁知道却不是, why?
     * 因为这里使用了stack数据结构?
     * <p>
     * 91 / 91 test cases passed.
     * Status: Accepted
     * Runtime: 2 - 3 ms 23.57%
     *
     * @param root
     * @param k
     * @return 返回剩余多少
     */
    public int kthSmallest2(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        int num = 0;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
                num++;
                if (num == k) return root.val;
                root = root.right;
            }
        }

        return 0;
    }

    private int ct = 0;

    /**
     * 不使用附加数据结构的中序遍历, [强烈推荐]
     * 91 / 91 test cases passed.
     * Status: Accepted
     * Runtime: 0 ms bit 92.78%
     *
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest3(TreeNode root, int k) {
        if (root == null) return 0;
        int res = kthSmallest3(root.left, k);
        if (ct == k) return res;
        else if (++ct == k) return root.val;
        return kthSmallest3(root.right, k);
    }

    public static void main(String[] args) {
        KthSmallestElementBST test = new KthSmallestElementBST();
        int[] nums = {1, 2};
        BinarySearchTree tree = BinarySearchTree.instance(nums);
        int k = 2;
        System.out.println(test.kthSmallest(tree.getRoot(), k));
        System.out.println(test.kthSmallest2(tree.getRoot(), k));
    }
}
