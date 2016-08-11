package zhang.algorithm.leetcode.question257_Binary_Tree_Paths;

import zhang.algorithm.modelUtil.Tree.BinaryTree;
import zhang.algorithm.modelUtil.Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: zhang_MacPro
 * Date: 16/8/11
 * Time: 上午11:02
 * To change this template use File | Settings | File Templates.
 */
public class BinaryTreePaths {
    /**
     * @param root
     * @return
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root != null) {
//            StringBuffer sb = new StringBuffer();
//            dfs(root, sb, res);
            dfs(root, "", res);
        }
        return res;
    }

    /**
     * <strong>result of test:</strong>
     * 209 / 209 test cases passed
     * Status: Accepted
     * Runtime: 5 ms, bit 6.21%
     *
     * @param root
     * @param sb
     * @param res
     */
    private void dfs(TreeNode root, StringBuffer sb, List<String> res) {

        if (sb.length() != 0) {
            sb.append("->");
        }
        sb.append(root.val);
        StringBuffer sb2 = new StringBuffer(sb);

        if (root.left == null && root.right == null)
            res.add(sb.toString());

        if (root.left != null) dfs(root.left, sb, res);
        if (root.right != null) dfs(root.right, sb2, res);
    }

    /**
     * <strong>result of test:</strong>
     * 209 / 209 test cases passed
     * Status: Accepted
     * Runtime: 3 ms, bit 29.59%
     *
     * @param root
     * @param path
     * @param res
     */
    private void dfs(TreeNode root, String path, List<String> res) {
        if (root.left == null && root.right == null) {
            res.add(path + root.val);
            return;
        }
        path += root.val + "->";
        if (root.left != null) dfs(root.left, path, res);
        if (root.right != null) dfs(root.right, path, res);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 0, 5};
        BinaryTree tree = BinaryTree.instance(nums);
        BinaryTreePaths test = new BinaryTreePaths();
        System.out.println(test.binaryTreePaths(tree.getRoot()));
    }
}
