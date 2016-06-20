package zhang.algorithm.leetcode.question113_Path_Sum_II;

import zhang.algorithm.modelUtil.Tree.BinaryTree;
import zhang.algorithm.modelUtil.Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhang_zack on 16/6/20.
 */
public class PathSumII {
    private int maxPathLen = 2000;
    private int[] path = new int[maxPathLen];
    List<List<Integer>> result = new ArrayList<List<Integer>>();

    /**
     * <br/>
     * <strong>result of test:</strong><br/>
     * 114 / 114 test cases passed<br/>
     * Status: Accepted<br/>
     * Runtime: 3 ms, bit 38.48%<br/>
     * <p>
     * here the size of maxPathLen is very influence program run speed
     * if maxPathLen = 9999, Runtime: 3 ms, bit 38.48%
     * if maxPathLen = 2000, Runtime: 2 ms, bit 94.02%
     *
     * @param root
     * @param sum
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        findAllPath(0, root, sum);
        return result;
    }

    private void findAllPath(int index, TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        path[index] = root.val;
        if (root.left == null && root.right == null && root.val == sum) {
            List<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i <= index; i++) {
                list.add(path[i]);
            }
            result.add(list);
            return;
        }
        findAllPath(index + 1, root.left, sum - root.val);
        findAllPath(index + 1, root.right, sum - root.val);
    }

    public static void main(String[] args) {
        PathSumII test = new PathSumII();
        int[] nums = {1, -2, -3, 1, 3, -2, 0, -1};
        TreeNode root = BinaryTree.instance(nums).getRoot();
        System.out.println(test.pathSum(root, 2));
    }
}
