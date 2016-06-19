package zhang.algorithm.leetcode.question107_Binary_Tree_Level_Order_Traversal_II;

import zhang.algorithm.modelUtil.Tree.TreeNode;

import java.util.*;


/**
 * Created by zhang_zack on 16/6/19.
 */
public class BTLevelOrderTraversalII {
    /**
     * this problem is similar as problem 102, but return it's reverse result<br/>
     * in other words, level order of binary tree from bottom to the top.<br/>
     * here we use the API of Java Collection at the last reverse.<br/>
     * <br/>
     * <strong>result of test:</strong><br/>
     * 34 / 34 test cases passed<br/>
     * Status: Accepted<br/>
     * Runtime: 3 ms, bit 31.02%, not stable<br/>
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                list.add(temp.val);
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
            result.add(list);
        }
        Collections.reverse(result);
        return result;
    }

    //----------------------------------------------------------------------
    // I find it is faster and more stable to use recursive way
    // to deal with a lot problem in binary tree
    // compare to use queue or stack data structure.
    // Below is the way solve problem with recursive method.
    //----------------------------------------------------------------------

    /**
     *
     * <strong>result of test:</strong><br/>
     * 34 / 34 test cases passed<br/>
     * Status: Accepted<br/>
     * Runtime: 2 ms, bit 77.07%<br/>
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        recursiveTravelTree(0, root, result);
        Collections.reverse(result);
        return result;
    }

    private void recursiveTravelTree(int level, TreeNode root, List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        if (result.size() <= level) {
            result.add(new ArrayList<Integer>());
        }
        result.get(level).add(root.val);
        recursiveTravelTree(level + 1, root.left, result);
        recursiveTravelTree(level + 1, root.right, result);
    }
}
