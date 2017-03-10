package zhang.algorithm.leetcode.question19_remove_nth_node;

/**
 * Review Time: 2017-03-08 14:28:59
 */
public class RemoveNthNode {
    /**
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null && n == 1) return null;
        ListNode currentNode = head;//当前节点
        ListNode nthNode = head;//倒数第n个节点
        ListNode nthNodePre = null;//倒数第n个节点的前置节点
        int nDistance = 1;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
            nDistance++;
            if (nDistance > n) {
                nthNode = nthNode.next;
                if (nthNodePre == null) {
                    nthNodePre = head;
                } else {
                    nthNodePre = nthNodePre.next;
                }
            }
        }
        if (nthNodePre == null) {
            return nthNode.next;
        }
        nthNodePre.next = nthNode.next;
        return head;
    }

    /**
     * 207 / 207 test cases passed.
     * Status: Accepted
     * Runtime: 16 ms, bit 47.34%
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        if (head == null || head.next == null) return null;
        ListNode emptyHead = new ListNode(0);
        emptyHead.next = head;
        ListNode left = emptyHead, right = emptyHead;
        while (n-- > 0) right = right.next;
        while (right.next != null) {
            left = left.next;
            right = right.next;
        }
        left.next = left.next.next;
        return emptyHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        RemoveNthNode test = new RemoveNthNode();
        System.out.println(test.removeNthFromEnd(head, 2));
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}