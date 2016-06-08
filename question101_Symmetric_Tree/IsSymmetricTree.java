package zhang.algorithm.leetcode.question101_Symmetric_Tree;

import zhang.algorithm.leetcode.TreeNode;

/**
 * Created by zhang_zack on 16/6/8.
 */
public class IsSymmetricTree {
    /**
     * 这里使用递归深度优先的方法进行遍历,来判断是否是中心对称的树<br/>
     * <br/>
     * <strong>测试结果:</strong><br/>
     * 193 / 193 test cases passed<br/>
     * Status: Accepted<br/>
     * Runtime: 1 ms,击败了22.89%<br/>
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if( root==null ){
            return true;
        }
        return recusiveIsSymmetic(root.left, root.right);
    }

    private boolean recusiveIsSymmetic(TreeNode left, TreeNode right){
        if(left==null && right==null){
            return true;
        }
        return left!=null && right!=null && left.val==right.val && recusiveIsSymmetic(left.left, right.right) && recusiveIsSymmetic(left.right, right.left);
    }

    public static void main(String[] args) {
        IsSymmetricTree test = new IsSymmetricTree();

        TreeNode root = new TreeNode(1);
        TreeNode left2 = new TreeNode(2);
        TreeNode right2 = new TreeNode(2);
        TreeNode left3 = new TreeNode(3);
        TreeNode right3 = new TreeNode(3);
        TreeNode left4 = new TreeNode(4);
        TreeNode right4 = new TreeNode(4);

        root.left = left2;
        root.right = right2;
        left2.left = left3;
        left2.right = right4;
        right2.left = left4;
        right2.right = right3;

        System.out.println(test.isSymmetric(root));
    }
}
