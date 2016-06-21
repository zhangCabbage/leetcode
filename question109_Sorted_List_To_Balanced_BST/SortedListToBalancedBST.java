package zhang.algorithm.leetcode.question109_Sorted_List_To_Balanced_BST;

import zhang.algorithm.modelUtil.List.ListNode;
import zhang.algorithm.modelUtil.Tree.TreeNode;

/**
 * Created by zhang_zack on 16/6/19.
 */
public class SortedListToBalancedBST {
    /**
     *
     * we can still use the way similar like last problem。<br/>
     * The feasibility of the method is proved in the below!<br/>
     * But I want you to solve this problem in the way that insert node to balanced binary tree.<br/>
     *
     * <strong>result of test:</strong><br/>
     * 32 / 32 test cases passed<br/>
     * Status: Accepted<br/>
     * Runtime: 2 ms, bit 9.78% it's too slow.<br/>
     *
     * @param head
     * @return
     */
    public TreeNode sortedListToBST(ListNode head) {
        ListNode mid = findMidNode(head);
        if (mid == null) return null;
        TreeNode root = new TreeNode(mid.val);
        root.left = (mid == head) ? null : sortedListToBST(head);
        root.right = sortedListToBST(mid.next);
        return root;
    }

    private ListNode findMidNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slower = head;
        ListNode faster = head.next;
        ListNode preNode = faster;
        //here let preNode equal faster is to avoid when the len of list is two
        //the preNode maybe null, so below preNode.next will be worry.
        while (faster.next != null && faster.next.next != null) {
            preNode = slower;
            slower = slower.next;
            faster = faster.next.next;
        }
        if (faster.next != null) {
            preNode = slower;
            slower = slower.next;
        }
        preNode.next = null;

        return slower;
    }
}
