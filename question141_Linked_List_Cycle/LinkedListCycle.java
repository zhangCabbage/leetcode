package zhang.algorithm.leetcode.question141_Linked_List_Cycle;

import zhang.algorithm.modelUtil.List.ListNode;

/**
 * Created by IntelliJ IDEA.
 * User: zhang_MacPro
 * Date: 16/7/3
 * Time: 下午6:39
 * To change this template use File | Settings | File Templates.
 */
public class LinkedListCycle {
    /**
     * This problem is to find whether a linked list has a cycle.But I not think the solve
     * way in the first time.
     * So I see the tags. Two point: I remember that I have see similar problem before.
     *
     * <strong>result of test:</strong><br/>
     * 16 / 16 test cases passed<br/>
     * Status: Accepted<br/>
     * Runtime: 1 ms, bit 12.05%<br/>
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;
        ListNode first = head;
        ListNode second = head.next;
        while(first != second){
            first = first.next;
            second = (second.next == null) ? null : second.next.next;
            if(second == null) return false;
        }
        if(first == second) return true;
        return false;
    }

    /**
     * Other way to deal this problem.
     * But the result is the same, and it modify the original linked list。
     *
     * @param head
     * @return
     */
    public boolean hasCycle2(ListNode head){
        if(head == null || head.next == null) return false;
        if(head.next == head) return true;
        //如果某一个节点自己指向自己那么即为环

        //把当前节点自己指向自己,迭代下一个节点
        ListNode nextNode = head.next;
        head.next = head;

        return hasCycle(nextNode);
    }
}
