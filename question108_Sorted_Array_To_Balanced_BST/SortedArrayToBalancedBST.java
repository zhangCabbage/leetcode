package zhang.algorithm.leetcode.question108_Sorted_Array_To_Balanced_BST;

import zhang.algorithm.modelUtil.Tree.TreeNode;

/**
 * Created by zhang_zack on 16/6/19.
 */
public class SortedArrayToBalancedBST {
    /**
     * we maybe can use two different way to build a balanced binary Search tree by sorted array
     * first maybe the common way that construct a balanced binary Search tree, this way almost can do in any input sence.
     * but maybe we can find a way aim at the array input to easy do.<br/>
     * <br/>
     * this mind maybe I can not find until I see the next problem, I think that is this a two question?
     * Yes, I can not deny why I has this mind is because I forget how to build a balanced binary Search tree
     * through insert node and constantly adjust tree.<br/>
     * <br/>
     * <strong>result of test:</strong><br/>
     * 32 / 32 test cases passed<br/>
     * Status: Accepted<br/>
     * Runtime: 1 ms, bit 7.0%<br/>
     * <br/>
     * <strong>Deep thinking:</strong><br/>
     * this way is easy to code, but it runs slow. Is there a way more better?<br/>
     * Just as I thought to look discuss but this site is maintenance(维修) currently. Bad luckly!
     *
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(nums, 0, nums.length-1);
    }

    private TreeNode buildBST(int[] nums, int start, int end) {
        if(start > end){
            return null;
        }
        int mid = (start+end)>>1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildBST(nums, start, mid-1);
        root.right = buildBST(nums, mid+1, end);
        return root;
    }
}
