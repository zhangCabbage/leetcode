package zhang.algorithm.leetcode.question21_merge_sorted_lists;

/**
 * @since 2016/5/5
 * @author DELL
 * 
 */
public class MergeSortedLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode tail = head;
		while(l1!=null && l2!=null){
			if(l1.val<l2.val){
				tail.next = l1;
				l1 = l1.next;
			}else{
				tail.next = l2;
				l2 = l2.next;
			}
			tail = tail.next;
        }
		if(l1==null){
        	tail.next = l2;
        }
        if(l2==null){
        	tail.next = l1;
        }
		return head.next;
    }
	
	public static void main(String[] args){
		ListNode first0 = new ListNode(1);
		
		ListNode second0 = new ListNode(2);
		
		MergeSortedLists test = new MergeSortedLists();
		System.out.println(test.mergeTwoLists(first0, second0));
	}
	
}


class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}