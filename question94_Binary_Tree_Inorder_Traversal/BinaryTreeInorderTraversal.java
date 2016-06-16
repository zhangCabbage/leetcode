package zhang.algorithm.leetcode.question94_Binary_Tree_Inorder_Traversal;

import zhang.algorithm.modelUtil.Tree.TreeNode;

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

    /**
     * 当我做到第98题时,发现深度优先遍历算法所得到的结果和中序遍历是一样的,所以我就对此题的中序遍历做了改进.<br/>
     * <br/>
     * <strong>测试结果:</strong><br/>
     * 68 / 68 test cases passed<br/>
     * Status: Accepted<br/>
     * Runtime: 1 ms,击败60.68%<br/>
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        dfsTraversal(list, root);
//        dfsTraversal2(list, root);
        return list;
    }

    /**
     * 这里返回值表示左子树结点是否已经全部遍历
     * @param list
     * @param root
     * @return
     */
    private boolean dfsTraversal(List<Integer> list, TreeNode root) {
        if(root == null){
            return true;
        }
        if(dfsTraversal(list, root.left)){
            list.add(root.val);
        }
        return dfsTraversal(list, root.right);
    }
    /**
     * 可以看到其实就是使用一般的中序遍历。函数dfsTraversal就是dfsTraversal2<br/>
     * 所以其实code98只是稍微对中序遍历进行变形的!!<br/>
     *
     * @param list
     * @param root
     * @return
     */
    private void dfsTraversal2(List<Integer> list, TreeNode root) {
        if(root == null){
            return;
        }
        dfsTraversal2(list, root.left);
        list.add(root.val);
        dfsTraversal2(list, root.right);
    }
}
