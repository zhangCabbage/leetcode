package zhang.algorithm.leetcode.question19_remove_nth_node;

/**
 * 
 * @author zhang_zack
 *
 */
public class RemoveNthNode {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if(head.next==null && n==1) return null;
		ListNode currentNode = head;//当前节点
		ListNode nthNode = head;//倒数第n个节点
		ListNode nthNodePre = null;//倒数第n个节点的前置节点
		int nDistance = 1;
		while(currentNode.next!=null){
			currentNode = currentNode.next;
			nDistance++;
			if(nDistance>n){
				nthNode = nthNode.next;
				if(nthNodePre==null){
					nthNodePre = head;
				}else{
					nthNodePre = nthNodePre.next;
				}
			}
		}
		if(nthNodePre==null){
			return nthNode.next;
		}
		nthNodePre.next = nthNode.next;
        return head;
    }
	
	public static void main(String[] args){
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