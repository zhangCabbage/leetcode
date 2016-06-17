package zhang.algorithm.leetcode.question103_Zigzag_Level_Order_Traversal;

import zhang.algorithm.modelUtil.Tree.TreeNode;

import java.util.*;

/**
 * Created by zhang_zack on 16/6/17.
 */
public class ZigzagLevelOrderTraversal {
    /**
     * this way I use maybe too complexity. We can say this is hard way to solve.
     * <br/>
     * <strong>result of test:</strong><br/>
     * 33 / 33 test cases passed<br/>
     * Status: Accepted<br/>
     * Runtime: 3 ms, bit 12.56%<br/>
     *
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        boolean isOdd = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<Integer>();
            Integer[] arr = new Integer[size];

            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();

                if (isOdd) {
                    list.add(curNode.val);
                } else {
                    arr[i] = curNode.val;
                }

                if (curNode.left != null) {
                    queue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    queue.offer(curNode.right);
                }
            }
            if (isOdd) {
                result.add(list);
                isOdd = false;
            } else {
                reverse(arr);
                result.add(Arrays.asList(arr));
                isOdd = true;
            }
            //this may can use Java inner list util method reverse
            //Collections.reverse(list);
        }

        return result;
    }

    private void reverse(Integer[] nums) {
        int start = 0;
        int end = nums.length - 1;
        for (; start < end; start++, end--) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
        }
    }

}
