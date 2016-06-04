package zhang.algorithm.leetcode;

/**
 * Created by zhang_zack on 16/5/27.
 * Listnode often use in question about list!
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(){

    }
    public ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        ListNode temp = this;
        sb.append("[");
        while(temp != null){
            sb.append(temp.val);
            sb.append(", ");
            temp = temp.next;
        }
        sb.delete(sb.length()-2, sb.length());
        sb.append("]");
        return sb.toString();
    }
}