package zhang.algorithm.leetcode.question147_Insertion_Sort_List;

import zhang.algorithm.modelUtil.List.ListNode;
import zhang.algorithm.modelUtil.List.ListTool;

/**
 * Created by IntelliJ IDEA.
 * User: zhang_MacPro
 * Date: 16/7/11
 * Time: 下午5:13
 * To change this template use File | Settings | File Templates.
 */
public class InsertionSortList {
    /**
     * 这个问题中我们使用前插的方法,来进行插入排序,从前往后比较。
     *
     * <strong>result of test:</strong><br/>
     * 21 / 21 test cases passed
     * Status: Accepted
     * Runtime: 39 ms, bit 65.19%
     *
     * ===>
     *
     * Runtime: 7 ms, bit 95.59%
     *
     * 我这种方法虽然代码简介,但是有一个很重要的问题是每次一个新的节点都需要从头到尾进行比较!
     *
     * @param head
     * @return
     */
    public ListNode insertionSortList(ListNode head) {
        ListNode extraHead = new ListNode(Integer.MIN_VALUE);
        ListNode tail = extraHead;

        while (head != null) {
            ListNode temp = head.next;

            if(head.val >= tail.val){
                head.next = null;
                tail.next = head;
                tail = head;
            }else{
                ListNode pre = null, cur = extraHead;
                while (cur != null && cur.val <= head.val) {
                    pre = cur;
                    cur = cur.next;
                }

                pre.next = head;
                head.next = cur;
            }
            head = temp;
        }

        return extraHead.next;
    }

    /**
     *
     * <strong>result of test:</strong><br/>
     * 21 / 21 test cases passed
     * Status: Accepted
     * Runtime: 10 ms, bit 86.76%
     *
     * But Why it faster than me?
     *
     * @param head
     * @return
     */
    public ListNode insertionSortList2(ListNode head) {
        ListNode newH = new ListNode(0);
        newH.next = head;
        ListNode fNode = newH, curNode = newH;
        while(fNode != null && fNode.next != null && fNode.next.next != null){
            if(fNode.next.val <= fNode.next.next.val){
                fNode = fNode.next;
            }
            else{
                ListNode tmp = fNode.next.next;
                fNode.next.next = tmp.next;
                curNode = newH;
                while(curNode.next.val < tmp.val)
                    curNode = curNode.next;
                tmp.next = curNode.next;
                curNode.next = tmp;
            }
        }
        return newH.next;
    }

    public static void main(String[] args) {
        InsertionSortList test = new InsertionSortList();
        int[] nums = {3, 1, 2, 4};
        ListNode head = ListTool.factory(nums);
        System.out.println(head);
        head = test.insertionSortList(head);
        System.out.println(head);
    }
}
