package zhang.algorithm.leetcode.question2_add_two_number;

/**
 * 考虑不够全面，编写链表的遍历创建时，逻辑混乱
 * 这么简单的一个程序，竟然还花了不少时间，真是fuck我自己了
 * @author DELL
 *
 */
public class AddTwoNumber {
	/**
	 * 自己的思路
	 * @param l1
	 * @param l2
	 * @return
	 */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ln=null;
        ListNode preNode=null;
        int next = 0;
        boolean isFirst = true;
        while(l1!=null && l2!=null){
            ListNode currentNode = new ListNode((l1.val+l2.val+next)%10);
            next = (l1.val+l2.val+next)/10;
            l1 = l1.next;
            l2 = l2.next;
            if(isFirst){
                preNode = currentNode;
                ln = currentNode;
                isFirst = false;
            }else{
                preNode.next = currentNode;
                preNode = currentNode;
            }
        }
        while(l1!=null){
            ListNode currentNode = new ListNode((l1.val+next)%10);
            next = (l1.val+next)/10;
            l1 = l1.next;
            if(isFirst){
                preNode = currentNode;
                ln = currentNode;
                isFirst = false;
            }else{
                preNode.next = currentNode;
                preNode = currentNode;
            }
        }
        while(l2!=null){
            ListNode currentNode = new ListNode((l2.val+next)%10);
            next = (l2.val+next)/10;
            l2 = l2.next;
            if(isFirst){
                preNode = currentNode;
                ln = currentNode;
                isFirst = false;
            }else{
                preNode.next = currentNode;
                preNode = currentNode;
            }
        }
        if(next!=0){
            ListNode currentNode = new ListNode(next);
            preNode.next = currentNode;
        }
        return ln;
    }
	
	/**
	 * 借鉴别人的思路的重新编写，带头节点的链表的创建<br/>
	 * 代码方式更加简洁！
	 * 你需要思考为什么你的代码感觉逻辑冗余！！？？
	 * 
	 * @param l1
	 * @param l2
	 * @return
	 */
	public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
		ListNode prev = new ListNode(0);
		ListNode head = prev;
		int next = 0;
		while(l1!=null || l2!=null || next!=0){
			int sum = ((l1==null)?0:l1.val)+((l2==null)?0:l2.val)+next;
			ListNode current = new ListNode(sum%10);
			next = sum/10;
			prev.next = current;
			prev = current;
			l1 = (l1==null)?l1:l1.next;
			l2 = (l2==null)?l2:l2.next;
		}
		return head.next;
	}
	
	public static void main(String args[]){
		AddTwoNumber test = new AddTwoNumber();
		int nums1[] = {2, 4, 3};
		ListNode l1 = ListNode.makeListNode(nums1);
		ListNode.printListNode(l1);
		int nums2[] = {5, 6, 4};
		ListNode l2 = ListNode.makeListNode(nums2);
		ListNode.printListNode(l2);
		
		test.addTwoNumbers(l1, l2);
	}
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
	public static ListNode makeListNode(int[] nums){
		ListNode currentnode = new ListNode(nums[0]);
		ListNode listnode = currentnode;
		for(int i=1; i<nums.length; i++){
			ListNode nextnode = new ListNode(nums[i]);
			currentnode.next = nextnode;
			currentnode = nextnode;
		}
		return listnode;
	}
	
	public static void printListNode(ListNode node){
		System.out.print("[");
		while(node!=null){
			System.out.print(node.val+", ");
			node = node.next;
		}
		System.out.print("]");
	}
}