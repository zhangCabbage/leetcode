package zhang.algorithm.leetcode.question94_Binary_Tree_Inorder_Traversal;

import zhang.algorithm.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhang_zack on 16/6/5.
 */
public class BinaryTreeInorderTraversal {
    /**
     * 二叉树的中序遍历,这里使用递归的中序遍历方法,但是仍是有许多其他方法很值得看的<br/>
     * <br/>
     * <strong>测试结果:</strong><br/>
     * 68 / 68 test cases passed<br/>
     * Status: Accepted<br/>
     * Runtime: 2 ms,击败3.26%<br/>
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if(root != null){
            List<Integer> left = inorderTraversal(root.left);
            list.addAll(left);

            list.add(root.val);

            List<Integer> right = inorderTraversal(root.right);
            list.addAll(right);
        }
        return list;
    }
}
