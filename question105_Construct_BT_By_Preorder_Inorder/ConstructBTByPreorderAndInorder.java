package zhang.algorithm.leetcode.question105_Construct_BT_By_Preorder_Inorder;

import zhang.algorithm.modelUtil.Tree.TreeNode;

/**
 * Created by zhang_zack on 16/6/18.
 */
public class ConstructBTByPreorderAndInorder {
    /**
     * this problem let us use the result of preorder and inorder to inverse get original tree
     * <br/>
     * <strong>result of test:</strong><br/>
     * 202 / 202 test cases passed<br/>
     * Status: Accepted<br/>
     * Runtime: 5 - 21ms, 不稳定, 82.42%-12.43%<br/>
     * confusion of thinking in the code
     *
     * @param preorder the result of preOrder traversal
     * @param inorder  the result of inorder traversal
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = preorder.length;
        return buildChildTree(preorder, 0, len, inorder, 0, len);
    }

    private int find(int[] nums, int start, int len, int target) {
        int result = -1;
        for (int i = 0; i < len; i++) {
            if (nums[start + i] == target) {
                result = i;
                break;
            }
        }
        return result;
    }

    private TreeNode buildChildTree(int[] preorder, int preStart, int preLen, int[] inorder, int inStart, int inLen) {
        if (preLen < 1 || inLen < 1) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int index = find(inorder, inStart, inLen, preorder[preStart]);
        root.left = buildChildTree(preorder, preStart + 1, index, inorder, inStart, index);
        root.right = buildChildTree(preorder, preStart + index + 1, preLen - index - 1, inorder, inStart + index + 1, inLen - index - 1);
        return root;
    }
    //----------------------------------------------------------------------------------
    //the second method that I find other person do to deal this problem, more stable and faster
    //----------------------------------------------------------------------------------

    /**
     * <br/>
     * <strong>result of test:</strong><br/>
     * 202 / 202 test cases passed<br/>
     * Status: Accepted<br/>
     * Runtime: 1 - 2ms, bit 98.92%<br/>
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, inorder, inorder.length - 1, 0);
    }

    private TreeNode buildTree(int[] preorder, int idx, int[] inorder, int end, int start) {
        if (idx >= preorder.length || start > end) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[idx]);
        int i;
        for (i = end; i >= start; i--) {
            if (preorder[idx] == inorder[i]) {
                break;
            }
        }
        root.left = buildTree(preorder, idx + 1, inorder, i - 1, start);
        root.right = buildTree(preorder, idx + i - start + 1, inorder, end, i + 1);
        return root;
    }

    public static void main(String[] args) {
        ConstructBTByPreorderAndInorder test = new ConstructBTByPreorderAndInorder();
        int[] preOrder = {1, 2, 3};
        int[] inOrder = {2, 3, 1};
        test.buildTree(preOrder, inOrder);
    }
}
