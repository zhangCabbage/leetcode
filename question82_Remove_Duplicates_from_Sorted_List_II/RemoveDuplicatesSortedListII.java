package zhang.algorithm.leetcode.question82_Remove_Duplicates_from_Sorted_List_II;

import zhang.algorithm.modelUtil.List.ListNode;

/**
 * Created by zhang_zack on 16/5/30.
 */
public class RemoveDuplicatesSortedListII {
    /**
     * <br/>
     * <strong>测试结果:</strong><br/>
     * 166 / 166 test cases passed.<br/>
     * Status: Accepted<br/>
     * Runtime: 1 ms,只击败了21.24%<br/>
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode preHead = new ListNode(1);
        preHead.next = head;
        ListNode preNode = preHead;
        ListNode curNode = head;
        boolean flag = false;

        while (curNode != null && curNode.next != null) {
            if (curNode.val != curNode.next.val) {
                if (flag == false) {
                    preNode.next = curNode;
                    preNode = curNode;
                }
                curNode = curNode.next;
                flag = false;
            } else {
                flag = true;
                curNode = curNode.next;
            }
        }
        if (flag == false) {
            preNode.next = curNode;
        } else {
            preNode.next = null;
        }
        return preHead.next;
    }

    /**
     * Review Time: 2017-03-12 17:23:28
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates2(ListNode head) {
        ListNode empty = new ListNode(0);
        ListNode tail = empty;
        boolean flag = false;

        while (head != null && head.next != null) {
            if (head.val == head.next.val) {
                flag = true;
                head.next = head.next.next;
            } else {
                if (flag) {
                    head = head.next;
                    flag = false;
                } else {
                    tail.next = head;
                    tail = head;
                    head = head.next;
                    tail.next = null;
                }
            }
        }
        if (head != null && !flag) tail.next = head;
        return empty.next;
    }

    public static void main(String[] args) {
        RemoveDuplicatesSortedListII test = new RemoveDuplicatesSortedListII();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        node1.next = node2;
        System.out.println(test.deleteDuplicates(node1));
    }
}
