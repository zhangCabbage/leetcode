package zhang.algorithm.leetcode.question328_Odd_Even_Linked_List;

import zhang.algorithm.modelUtil.List.LinkedListTools;
import zhang.algorithm.modelUtil.List.ListNode;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 16/10/29
 * Time: 下午2:00
 * To change this template use File | Settings | File Templates.
 */
public class OddEvenLinkedList {
    /**
     * 70 / 70 test cases passed
     * Status: Accepted
     * Runtime: 1 ms, bit 3.65%
     *
     * @param head
     * @return
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode oddHead = head, oddTail = oddHead;
        ListNode evenHead = head.next, evenTail = evenHead;
        head = head.next.next;
        int count = 3;

        while (head != null) {
            if (count % 2 == 0) {
                //偶数位
                evenTail.next = head;
                evenTail = evenTail.next;
            } else {
                //奇数位
                oddTail.next = head;
                oddTail = oddTail.next;
            }
            head = head.next;
            count++;
        }
        oddTail.next = evenHead;
        evenTail.next = null;
        return oddHead;
    }

    /**
     * 很简洁的一种代码方式!!
     *
     * @param head
     * @return
     */
    public ListNode oddEvenList2(ListNode head) {
        if (head != null) {
            ListNode odd = head;
            ListNode even = head.next, evenHead = even;
            while (even != null && even.next != null) {
                odd.next = odd.next.next;
                even.next = even.next.next;
                odd = odd.next;
                even = even.next;
            }
            odd.next = evenHead;
        }

        return head;
    }

    public static void main(String[] args) {
        OddEvenLinkedList test = new OddEvenLinkedList();
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(test.oddEvenList(LinkedListTools.factory(nums)));
    }
}
