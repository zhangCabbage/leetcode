package zhang.algorithm.leetcode.question513_Find_BottomLeft;

import zhang.algorithm.modelUtil.Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 17/5/1
 * Time: 下午3:54
 * To change this template use File | Settings | File Templates.
 */
public class BottomLeftTreeValue {

    private List<Integer> res = new ArrayList(10);

    /**
     * 74 / 74 test cases passed.
     * Status: Accepted
     * Runtime: 8 ms, bit 75.42%
     *
     * @param root
     * @return
     */
    public int findBottomLeftValue(TreeNode root) {
        helper(root, 0);
        return res.get(res.size() - 1);
    }

    private void helper(TreeNode root, int level) {
        if (root == null) return;
        if (level >= res.size()) res.add(root.val);
        helper(root.left, level + 1);
        helper(root.right, level + 1);
    }

    public static void main(String[] args) {
        BottomLeftTreeValue test = new BottomLeftTreeValue();
    }
}
