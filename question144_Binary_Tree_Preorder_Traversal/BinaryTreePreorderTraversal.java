package zhang.algorithm.leetcode.question144_Binary_Tree_Preorder_Traversal;

import zhang.algorithm.modelUtil.Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by IntelliJ IDEA.
 * User: zhang_MacPro
 * Date: 16/7/10
 * Time: 下午7:50
 * To change this template use File | Settings | File Templates.
 */
public class BinaryTreePreorderTraversal {
    /**
     *
     * <strong>result of test:</strong><br/>
     * 67 / 67 test cases passed
     * Status: Accepted
     * Runtime: 2 ms, bit 1.86%
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(root != null || !stack.isEmpty()){
            while(root != null){
                result.add(root.val);
                stack.add(root);
                root = root.left;
            }
            if(!stack.isEmpty()){
                TreeNode cur = stack.pop();
                root = cur.right;
            }
        }
        return result;
    }
}
