package zhang.algorithm.leetcode.question86_Partition_List;

import zhang.algorithm.modelUtil.List.ListNode;

/**
 * Created by zhang_zack on 16/5/31.
 */
public class PartitionList {
    /**
     * 最简单的思路,分别用left链和right链来分割大于等于x的和小于x的数,然后再组合,不过感觉代码量可能有点多哎<br/>
     * <br/>
     * <strong>测试结果:</strong><br/>
     * 166 / 166 test cases passed.<br/>
     * Status: Accepted<br/>
     * Runtime: 1 ms,只击败了2.48%<br/>
     *
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        ListNode curNode = head;
        ListNode biggerStart = null;
        ListNode biggerCur = biggerStart;
        ListNode smallerStart = null;
        ListNode smallerCur = smallerStart;
        while (curNode != null) {
            if (curNode.val >= x) {
                //bigger,右侧
                if (biggerCur == null) {
                    biggerCur = curNode;
                    biggerStart = curNode;
                } else {
                    biggerCur.next = curNode;
                    biggerCur = biggerCur.next;
                }
            } else {
                //smaller,左侧
                if (smallerCur == null) {
                    smallerCur = curNode;
                    smallerStart = curNode;
                } else {
                    smallerCur.next = curNode;
                    smallerCur = smallerCur.next;
                }
            }
            curNode = curNode.next;
        }
        if (biggerStart == null) {
            return smallerStart;
        }
        biggerCur.next = null;
        if (smallerStart == null) {
            return biggerStart;
        }
        smallerCur.next = biggerStart;
        return smallerStart;
    }

    /**
     * 可以使用带头结点的链表来简化程序<br/>
     * <br/>
     * 测试结果跟上一个是一样的<br/>
     *
     * @param head
     * @param x
     * @return
     */
    public ListNode partition2(ListNode head, int x) {
        ListNode biggerStart = new ListNode(0);
        ListNode biggerCur = biggerStart;
        ListNode smallerStart = new ListNode(0);
        ListNode smallerCur = smallerStart;

        while (head != null) {
            if (head.val >= x) {
                //bigger,右侧
                biggerCur.next = head;
                biggerCur = biggerCur.next;
            } else {
                //smaller,左侧
                smallerCur.next = head;
                smallerCur = smallerCur.next;
            }
            head = head.next;
        }
        biggerCur.next = null;
        smallerCur.next = biggerStart.next;
        return smallerStart.next;
    }

    public static void main(String[] args) {
        PartitionList test = new PartitionList();
    }
}
