package zhang.algorithm.leetcode.question206_Reverse_Linked_List;

import zhang.algorithm.leetcode.ListNode;

/**
 * Created by zhang_zack on 16/6/3.
 */
public class ReverseLinkedList {
    /**
     * 倒置链表,可以使用反复前插的办法,这种方法属于iteratively--迭代<br/>
     * 貌似倒置链表不使用带头结点的链表方式更简单哦<br/>
     * <br/>
     * <strong>测试结果:</strong><br/>
     * 27 / 27 test cases passed<br/>
     * Status: Accepted<br/>
     * Runtime: 1 ms,只击败了4.66%<br/>
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode reverseHead = new ListNode(0);
        ListNode reverseNext = reverseHead.next;
        while(head != null){
            ListNode next = head.next;

            reverseHead.next = head;
            head.next = reverseNext;
            reverseNext = head;

            head = next;
        }
        return reverseNext;
    }

    /**
     * 使用递归的方法完成链表的倒置--recusive递归<br/>
     * <br/>
     * <strong>测试结果:</strong><br/>
     * 同样的效果
     *
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode reverseHead = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return reverseHead;
    }
}
