package zhang.algorithm.leetcode.question19_remove_nth_node;

/**
 * 
 * @author zhang_zack
 *
 */
public class RemoveNthNode {
	public ListNode removeNthFromEnd(ListNode head, int n) {
        return head;
    }
	
	public static void main(String[] args){
		RemoveNthNode test = new RemoveNthNode();
		System.out.println();
	}
}

class ListNode {
	int val;
	ListNode next;
	
	ListNode(int x) {
		val = x;
	}
}