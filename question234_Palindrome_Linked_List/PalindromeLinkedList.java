package zhang.algorithm.leetcode.question234_Palindrome_Linked_List;

import zhang.algorithm.modelUtil.List.ListNode;

/**
 * Created by IntelliJ IDEA.
 * User: zhang_MacPro
 * Date: 16/8/10
 * Time: 下午9:37
 * To change this template use File | Settings | File Templates.
 */
public class PalindromeLinkedList {
    /**
     * 22 / 22 test cases passed
     * Status: Accepted
     * Runtime: 4 - 5 ms, bit 13.52 - 15.72%
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        return equals(head, reverse(head));
    }

    public ListNode reverse(ListNode head) {
        ListNode newHead = new ListNode(0);
        ListNode next = null;
        while (head != null) {
            ListNode temp = new ListNode(head.val);

            newHead.next = temp;
            temp.next = next;
            next = temp;

            head = head.next;
        }

        return newHead.next;
    }

    public boolean equals(ListNode head1, ListNode head2) {
        while (head1.next != null) {
            if (head1.val != head2.val) return false;
            head1 = head1.next;
            head2 = head2.next;
        }
        return true;
    }

    //-----------------------------------------------------
    //
    //-----------------------------------------------------

    /**
     * 22 / 22 test cases passed
     * Status: Accepted
     * Runtime: 3 ms, bit 22.33%
     *
     * @param head
     * @return
     */
    public boolean isPalindrome2(ListNode head) {
        if (head == null) return true;

        ListNode first = head;
        ListNode second = head.next;
        while (second != null && second.next != null) {
            first = first.next;
            second = second.next.next;
        }

        ListNode cur = first.next;
        ListNode next = null;
        while (cur != null) {
            ListNode temp = cur.next;

            cur.next = null;
            first.next = cur;
            cur.next = next;

            next = cur;
            cur = temp;
        }

        while (first.next != null) {
            if (head.val != first.next.val) return false;
            head = head.next;
            first = first.next;
        }
        return true;
    }
}
