package zhang.algorithm.leetcode.question143_Reorder_List;

import zhang.algorithm.modelUtil.List.ListNode;
import zhang.algorithm.modelUtil.List.ListTool;

/**
 * Created by IntelliJ IDEA.
 * User: zhang_MacPro
 * Date: 16/7/10
 * Time: 下午7:04
 * To change this template use File | Settings | File Templates.
 */
public class ReorderList {
    /**
     *
     * <strong>result of test:</strong><br/>
     * 13 / 13 test cases passed
     * Status: Accepted
     * Runtime: 3 ms, bit 25.82%
     *
     * @param head
     */
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        ListNode first = head, second = head.next;
        while (second.next != null && second.next.next != null) {
            first = first.next;
            second = second.next.next;
        }

        ListNode insertHead = first.next.next;
        first.next.next = null;
        insertHead = reverse(insertHead);

        first = head;
        second = insertHead;
        while (second != null) {
            ListNode temp1 = first.next, temp2 = second.next;
            first.next = second;
            second.next = temp1;
            first = temp1;
            second = temp2;
        }

    }

    /**
     * reverse single linked list
     *
     * @param head
     */
    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode cur = head.next;
        head.next = null;

        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = head;
            head = cur;
            cur = temp;
        }
        return head;
    }

    public static void main(String[] args) {
        ReorderList test = new ReorderList();
        int[] nums = {1, 2};
        ListNode head = ListTool.factory(nums);
        test.reorderList(head);

        System.out.println(head);
    }
}
