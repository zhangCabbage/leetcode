package zhang.algorithm.leetcode.question82_Remove_Duplicates_from_Sorted_List_II;

import zhang.algorithm.leetcode.ListNode;

/**
 * Created by zhang_zack on 16/5/30.
 */
public class RemoveDuplicatesSortedListII {
    /**
     *
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

        while(curNode!=null && curNode.next!=null){
            if(curNode.val != curNode.next.val){
                if(flag == false){
                    preNode.next = curNode;
                    preNode = curNode;
                }
                curNode = curNode.next;
                flag = false;
            }else{
                flag = true;
                curNode = curNode.next;
            }
        }
        if(flag==false){
            preNode.next = curNode;
        }else{
            preNode.next = null;
        }
        return preHead.next;
    }

    public static void main(String[] args) {
        RemoveDuplicatesSortedListII test = new RemoveDuplicatesSortedListII();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        node1.next = node2;
        System.out.println(test.deleteDuplicates(node1));
    }
}
