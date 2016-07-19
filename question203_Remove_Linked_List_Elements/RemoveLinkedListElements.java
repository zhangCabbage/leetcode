package zhang.algorithm.leetcode.question203_Remove_Linked_List_Elements;

import zhang.algorithm.modelUtil.List.ListNode;

/**
 * Created by IntelliJ IDEA.
 * User: zhang_MacPro
 * Date: 16/7/19
 * Time: 上午9:12
 * To change this template use File | Settings | File Templates.
 */
public class RemoveLinkedListElements {

    /**
     * <strong>result of test:</strong><br/>
     * 63 / 63 test cases passed
     * Status: Accepted
     * Runtime: 2 ms, bit 3.69%
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode extraHead = new ListNode(0);
        extraHead.next = head;
        ListNode cur = extraHead;
        while (head != null) {
            if (head.val == val) {
                cur.next = head.next;
            } else {
                cur = head;
            }

            head = head.next;
        }
        return extraHead.next;
    }
}
