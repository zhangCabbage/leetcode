package zhang.algorithm.leetcode.question129_Sum_Root_Leaf_Numbers;

import zhang.algorithm.modelUtil.Tree.TreeNode;

/**
 * Created by IntelliJ IDEA.
 * User: zhang_Lenovo
 * Date: 2016/6/24
 * Time: 22:15
 * To change this template use File | Settings | File Templates.
 */
public class SumRootLeafNumbers {
    private int sum = 0;

    /**
     * I use to much judge in the recursive, but this judge look seem not necessary!!!
     *
     * <strong>result of test:</strong><br/>
     * 109 / 109 test cases passed<br/>
     * Status: Accepted<br/>
     * Runtime: 1 ms, bit 27.88%<br/>
     *
     * @param root
     * @return
     */
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        int[] numArray = new int[50];
        sumNumbers(root, numArray, 0);
        return sum;
    }

    private void sumNumbers(TreeNode root, int[] numArray, int index){
        numArray[index] = root.val;
        if(root.left == null && root.right == null){
            int num = 0;
            for(int i=0; i<=index; i++){
                num = num*10+numArray[i];
            }
            sum += num;
            return;
        }
        if(root.left != null) sumNumbers(root.left, numArray, index+1);
        if(root.right != null) sumNumbers(root.right, numArray, index+1);
    }

    //---------------------------------------------------------------------------
    //more simple, more faster
    //---------------------------------------------------------------------------

    /**
     * this way is
     * <strong>result of test:</strong><br/>
     * 109 / 109 test cases passed<br/>
     * Status: Accepted<br/>
     * Runtime: 0 ms, bit 71.87%<br/>
     *
     * @param root
     * @return
     */
    public int sumNumbers2(TreeNode root){
        return sumNumbers(root, 0);
    }

    private int sumNumbers(TreeNode root, int preSum){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return preSum + root.val;
        }
        preSum = (preSum+root.val)*10;
        return sumNumbers(root.left, preSum)+ sumNumbers(root.right, preSum);
    }
}
