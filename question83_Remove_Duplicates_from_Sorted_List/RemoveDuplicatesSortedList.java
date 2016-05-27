package zhang.algorithm.leetcode.question83_Remove_Duplicates_from_Sorted_List;

import zhang.algorithm.leetcode.ListNode;
/**
 * Created by zhang_zack on 16/5/27.
 */
public class RemoveDuplicatesSortedList {
    /**
     * <strong>测试结果:</strong><br/>
     * 164 / 164 test cases passed.<br/>
     * Status: Accepted<br/>
     * Runtime: 2 ms,只击败了6.2%<br/>
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curNode = head;
        int curValue;
        while(curNode!=null && curNode.next!=null){
            curValue = curNode.val;
            ListNode nextNode = curNode.next;
            while(nextNode!=null && nextNode.val == curValue){
                nextNode = nextNode.next;
            }
            curNode.next = nextNode;

            curNode = nextNode;

//            或者可以写成如下形式,更加简单易懂
//            if(curNode.val == curNode.next.val){
//                curNode.next = curNode.next.next;
//            }else{
//                curNode = curNode.next;
//            }

        }
        return head;
    }

    public static void main(String[] args) {
        RemoveDuplicatesSortedList test = new RemoveDuplicatesSortedList();
        System.out.println();
    }
}
