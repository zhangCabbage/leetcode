package zhang.algorithm.leetcode.question24_SwapNodes;

public class SwapNodes {
	
	public ListNode swapPairs(ListNode head) {
		ListNode newHead = new ListNode(0);
		ListNode curNode = newHead;
		
		while(head!=null && head.next!=null){
			//原来我的想法，从逻辑上讲的话思路太混乱了，AC成功
//			ListNode nextNode = head.next.next;
//			
//			curNode.next = head.next;
//			head.next = null;
//			curNode.next.next = head;
//			curNode = head;
//			
//			head = nextNode;
			
			//参考别人的想法，这种是在本链表中进行修改，但是思路显得清晰多了，AC成功
			ListNode tempNode = head.next;
			
			head.next = head.next.next;
			tempNode.next = head;
			curNode.next = tempNode;
			curNode = head;
			head = head.next;
			
		}
		curNode.next = head;
        return newHead.next;
    }
	
	public static void main(String[] args){
		ListNode one = new ListNode(1);
		ListNode two = new ListNode(2);
		one.next = two;
		SwapNodes test = new SwapNodes();
		System.out.println(test.swapPairs(one));
	}
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}