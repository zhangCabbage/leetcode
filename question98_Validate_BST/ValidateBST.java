package zhang.algorithm.leetcode.question98_Validate_BST;

import zhang.algorithm.leetcode.TreeNode;

/**
 * Created by zhang_zack on 16/6/7.
 */
public class ValidateBST {
    /**
     * 使用prev结点来保存子树中最后一个访问的结点
     */
    private TreeNode prev = null;
    /**
     * 考察深度优先遍历 Depth-first Search<br/>
     * 下面的代码在理解深度优先遍历,并使用上做的非常好,代码也非常简洁,但是理解起来有点吃力<br/>
     * 看到这个代码真是好想给写这个代码的人生猴子,大屌.立马把自己写的代码给删了<br/>
     * <br/>
     * <strong>测试结果:</strong><br/>
     * 74 / 74 test cases passed<br/>
     * Status: Accepted<br/>
     * Runtime: 1 ms<br/>
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        if(!isValidBST(root.left)) return false;
        if(prev != null && root.val <= prev.val) return false;
        prev = root;

        return isValidBST(root.right);
    }


    public static void main(String[] args) {
        ValidateBST test = new ValidateBST();
//        [10,5,15,null,null,6,20]
        TreeNode root = new TreeNode(10);
        TreeNode a = new TreeNode(5);
        TreeNode b = new TreeNode(15);
        root.left = a;
        root.right = b;
        TreeNode c = new TreeNode(6);
        TreeNode d = new TreeNode(20);
        test.isValidBST(root);
    }
}
