package zhang.algorithm.leetcode.question148_Sort_List;

import java.util.LinkedList;
import java.util.Queue;

public class SortList {
	/**
	 * 链表时间复杂度为O(n*logn)的排序 <br/>
	 * 这里的想法是实现链表的归并排序，以达到目的！
	 * @param head
	 * @return
	 */
	public ListNode sortList(ListNode head) {
		Queue<ListNode> queue = new LinkedList<ListNode>();
		ListNode cur = head;
		queue.offer(cur);
		queue.offer(cur.next);
		cur = cur.next.next;
		int len = 1;
		while(!queue.isEmpty()){
			
			
			ListNode start = queue.poll();
			ListNode mid = start;
			for(int i=0; i<len; i++){
				mid = mid.next;
			}
			//合并两个有序链表
			
		}
        return null;
    }
	
	/**
	 * 时间复杂度为O(n*logn)的排序有：快排、归并、堆排。<br/>
	 * 双向链表适合快排，而单向链表适合使用归并排序 <br/>
	 * 这里很重要的一个方法是<strong>使用快慢指针的方法找到中间节点</strong><br/>
	 * 总耗时10ms
	 * @param head
	 * @return
	 */
	public ListNode sortList2(ListNode head) {
		if(head==null || head.next==null)return head;
		ListNode slow = head;
		ListNode fast = head;
		while(fast.next!=null && fast.next.next!=null){
			slow = slow.next;
			fast = fast.next.next;
		}
		fast = slow;
		slow = slow.next;
		fast.next = null;
		head = sortList2(head);
		slow = sortList2(slow);//这里需要注意一下，并不是在原来变量基础上改，合并是返回的另外的值，所以需要这样赋值一下！
		return mergeSortedList(head, slow);
	}
	
	public ListNode mergeSortedList(ListNode head1, ListNode head2){
		if(head1==null)return head2;
		if(head2==null)return head1;
		ListNode head = new ListNode(0);
		ListNode cur = head;
		while(head1!=null && head2!=null){
			if(head1.val<head2.val){
				cur.next = head1;
				head1 = head1.next;
			}else{
				cur.next = head2;
				head2 = head2.next;
			}
			cur = cur.next;
		}
		if(head1 == null)cur.next = head2;
		if(head2 == null)cur.next = head1;
		return head.next;
	}
	
	public static void main(String[] args){
		SortList test = new SortList();
		
		ListNode head = new ListNode(3);
		ListNode head1 = new ListNode(2);
		ListNode head2 = new ListNode(4);
		head.next = head1;
		head1.next = head2;
		System.out.println(test.sortList2(head));
	}
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}