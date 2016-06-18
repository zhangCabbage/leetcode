package zhang.algorithm.leetcode.question106_Construct_BT_Inorder_Postorder;

import zhang.algorithm.modelUtil.Tree.TreeNode;

/**
 * Created by zhang_zack on 16/6/18.
 */
public class ConstructBTInorderAndPostorder {
    /**
     * <strong>result of test:</strong><br/>
     * <br/>
     * 202 / 202 test cases passed<br/>
     * Status: Accepted<br/>
     * Runtime: 2 ms, bit 92.05%<br/>
     *
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(postorder, postorder.length-1, inorder, 0, inorder.length-1);
    }

    /**
     *
     * @param postorder
     * @param index 【post order】 list from end to start
     * @param inorder special note the mean of below two arguments
     * @param start is the inorder list index start
     * @param end is the inorder list index end
     * @return
     */
    private TreeNode buildTree(int[] postorder, int index, int[] inorder, int start, int end){
        if(index < 0 || start > end){
            return null;
        }
        TreeNode root = new TreeNode(postorder[index]);
        int i;
        for(i=end; i>=start; i--){
            if(inorder[i] == postorder[index]){
                break;
            }
        }
//        root.left = buildTree(postorder, i-1, inorder, start, i-1);
//        root.right = buildTree(postorder, end-1, inorder, i+1, end);

        //why this do like that, not like above?
        //due to we use postOrder from end to start, so the right is the first!
        //so this position we must leave enough number to right child tree
        //
        //my solve way in this problem is worry when has not left child if direct to use i - 1
        //because of many times recursive
        root.left = buildTree(postorder, index-(end-i+1), inorder, start, i-1);
        root.right = buildTree(postorder, index-1, inorder, i+1, end);
        return root;
    }

    public static void main(String[] args) {
        ConstructBTInorderAndPostorder test = new ConstructBTInorderAndPostorder();
        int[] inOrder = {1, 2, 3};
        int[] postOrder = {3, 2, 1};
        test.buildTree(inOrder, postOrder);
    }

}
