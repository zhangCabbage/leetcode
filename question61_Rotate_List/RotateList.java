package zhang.algorithm.leetcode.question61_Rotate_List;

public class RotateList {
	/**
	 * 这里我用最笨的一种方法，毫无技巧可言<br/>
	 * <br/>
	 * <strong>执行结果：</strong><br/>
	 * 230 / 230 test cases passed.<br/>
	 * Status: Accepted<br/>
	 * Runtime: 1 ms，击败14.33%<br/>
	 * 
	 * @param head
	 * @param k 可以是任何值
	 * @return
	 */
    public ListNode rotateRight(ListNode head, int k) {
    	if(head==null || head.next==null){
    		return head;
    	}
    	int len = 1;
    	ListNode tail = head;
    	while(tail.next != null){
    		len++;
    		tail = tail.next;
    	}
    	
    	k = k%len;
    	if(k == 0){
    		return head;
    	}
    	
    	tail = head;
    	ListNode temp = head;
    	for(int i=0; i<k; i++){
    		temp = temp.next;
    	}
    	
    	while(temp.next != null){
    		tail = tail.next;
    		temp = temp.next;
    	}
    	temp.next = head;
    	head = tail.next;
    	tail.next = null;
    	
        return head;
    }
	
	public static void main(String[] args){
		RotateList test = new RotateList();
		ListNode head = new ListNode(1);
		ListNode two = new ListNode(2);
		ListNode three = new ListNode(3);
		ListNode four = new ListNode(4);
		ListNode five = new ListNode(5);
		head.next = two;
		two.next = three;
		three.next = four;
		four.next = five;
		int k = 2;
		System.out.println(test.rotateRight(head, k));
	}
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}