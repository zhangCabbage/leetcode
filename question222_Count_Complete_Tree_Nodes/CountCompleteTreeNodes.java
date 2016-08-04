package zhang.algorithm.leetcode.question222_Count_Complete_Tree_Nodes;

import zhang.algorithm.modelUtil.Tree.BinaryTree;
import zhang.algorithm.modelUtil.Tree.Direction;
import zhang.algorithm.modelUtil.Tree.TreeNode;

/**
 * Created by IntelliJ IDEA.
 * User: zhang_MacPro
 * Date: 16/8/4
 * Time: 上午10:23
 * To change this template use File | Settings | File Templates.
 */
public class CountCompleteTreeNodes {
    /**
     * first try, that Time Limit Exceeded
     * this method traversal every node, no use the complete tree feature.
     *
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    /**
     * Use the condition that whether the left depth is equal the right depth
     * to traversal the tree node.
     * <strong>result of test:</strong><br/>
     * 18 / 18 test cases passed
     * Status: Accepted
     * Runtime: 112 - 120 ms, bit 28.83 - 57.75%
     *
     * @param root
     * @return
     */
    public int countNodes2(TreeNode root) {
        int leftDepth = leftDepth(root);
        int rightDepth = rightDepth(root);
        if (leftDepth == rightDepth) return (1 << leftDepth) - 1;
        else return 1 + countNodes2(root.left) + countNodes2(root.right);
    }

    //--------------------------------------------------------------------
    //binary search for this problem
    //--------------------------------------------------------------------

    /**
     * use binary search
     * this place when we use Math.pow(a, b), this way is Time Limit Exceeded
     * But when we use bit operator replace it, this way is faster.
     * <p>
     * <strong>result of test:</strong><br/>
     * 18 / 18 test cases passed
     * Status: Accepted
     * Runtime: 68 - 72 ms, bit 88.17 - 90.61%
     *
     * @param root
     * @return
     */
    public int countNodes3(TreeNode root) {
        if (root == null) return 0;

        int totalNode = 0;
        int high = 0;
        TreeNode temp = root;
        while (temp != null) {
            temp = temp.left;
            high++;
        }
        int lastNode = 1 << (high - 1);
        totalNode += lastNode - 1;

        TreeNode cur = root;
        int level = 0;
        while (cur != null) {
            if (++level + totalHigh(cur) == high) {
                cur = cur.right;
                totalNode += cur == null ? 1 : lastNode / (1 << level);
            } else {
                cur = cur.left;
            }
        }

        return totalNode;
    }

    /**
     * other people's binary search code, maybe more perfect than me.
     * <p>
     * <strong>result of test:</strong><br/>
     * 18 / 18 test cases passed
     * Status: Accepted
     * Runtime: 53 ms, bit 98.69%
     *
     * @param root
     * @return
     */
    public int countNodes4(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null) return 1;

        int total = 0;
        int high = 0;
        TreeNode temp = root;
        while (temp.left != null) {
            total += (1 << high);
            high++;
            temp = temp.left;
        }

        return total + lastLevelNodes(root, high);
    }

    private int lastLevelNodes(TreeNode root, int height) {
        //last stop control logic
        if (height == 1) {
            if (root.right != null) return 2;
            else if (root.left != null) return 1;
            else return 0;
        }

        TreeNode midNode = root.left;
        int curHigh = 1;
        while (curHigh < height) {
            midNode = midNode.right;
            curHigh++;
        }

        if (midNode == null) return lastLevelNodes(root.left, height - 1);
        else return (1 << (height - 1)) + lastLevelNodes(root.right, height - 1);
    }

    //--------------------------------------------------------------------
    //binary search for this problem
    //--------------------------------------------------------------------

    private int totalHigh(TreeNode root) {
        int high = 0;
        root = root.left;
        while (root != null) {
            high++;
            root = root.right;
        }
        return high;
    }

    private int leftDepth(TreeNode root) {
        int leftDepth = 0;
        while (root != null) {
            leftDepth++;
            root = root.left;
        }
        return leftDepth;
    }

    private int rightDepth(TreeNode root) {
        int rightDepth = 0;
        while (root != null) {
            rightDepth++;
            root = root.right;
        }
        return rightDepth;
    }

    /**
     * In order to avoid redundancy(避免冗余)
     *
     * @param root
     * @param dir
     * @return
     */
    private int getDepth(TreeNode root, Direction dir) {
        int depth = 0;
        while (root != null) {
            depth++;
            if (dir == Direction.LEFT) root = root.left;
            else root = root.right;
        }
        return depth;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        BinaryTree tree = BinaryTree.instance(nums);
        CountCompleteTreeNodes test = new CountCompleteTreeNodes();

        System.out.println(test.countNodes4(tree.getRoot()));
    }
}
