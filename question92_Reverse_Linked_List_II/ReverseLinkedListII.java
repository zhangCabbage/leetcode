package zhang.algorithm.leetcode.question92_Reverse_Linked_List_II;

import zhang.algorithm.modelUtil.List.ListNode;

/**
 * Created by zhang_zack on 16/6/4.
 */
public class ReverseLinkedListII {
    /**
     *
     * 倒置链表中第m个位置的元素和第n个位置的元素,但是我很奇怪的是我竟然把代码写的这么烂
     * 而且当我把代码写完之后发现,还TM的跟题意不相同,失败!!!<br/>
     *
     * <strong>测试结果:</strong><br/>
     *
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null || head.next==null || m==n){
            return head;
        }

        ListNode nodeHead = new ListNode(0);
        nodeHead.next = head;
        ListNode left=nodeHead, right=nodeHead;
        while(n>m){
            right = right.next;
            n--;
        }
        for(int i=1; i<m; i++){
            left = left.next;
            right = right.next;
        }
        ListNode temp1 = left.next;
        ListNode temp2 = right.next;

        if(left.next == right){
            left.next = right.next.next;

            temp2.next = temp1;
            temp1.next = left.next;
            left.next = temp2;
        }else{
            left.next = left.next.next;
            right.next = right.next.next;

            temp2.next = left.next;
            left.next = temp2;
            temp1.next = right.next;
            right.next = temp1;
        }

        return nodeHead.next;
    }

    /**
     * 对只交换m和n两位置的结点程序进行重写
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween1(ListNode head, int m, int n) {
        if(head==null || head.next==null || m==n){
            return head;
        }

        ListNode nodeHead = new ListNode(0);
        nodeHead.next = head;

        ListNode pre = nodeHead, cur = pre.next;
        ListNode preLeft=null, left=null, right=null;

        int index = 1;
        while(cur != null){
            if(index == m){
                preLeft = pre;
                left = cur;
                pre.next = cur.next;

                cur = cur.next;
                index++;
            }else if(index == n){
                left.next = cur.next;
                pre.next = left;

                right = cur;
                break;
            }else{
                pre = pre.next;
                cur = cur.next;
                index++;
            }
        }
        if(index == n){
            right.next = preLeft.next;
            preLeft.next = right;
        }

        return nodeHead.next;
    }

//--------------------------------------------------------------------------------

    /**
     * 翻转第m个结点到第n个结点中间所有的结点!!<br/>
     * <br/>
     * <strong>测试结果:</strong><br/>
     * 44 / 44 test cases passed.<br/>
     * Status: Accepted<br/>
     * Runtime: 0 ms,击败7.78%<br/>
     *
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween2(ListNode head, int m, int n) {
        if(head==null || head.next==null || m==n){
            return head;
        }

        ListNode nodeHead = new ListNode(0);
        nodeHead.next = head;
        ListNode left=nodeHead, right=nodeHead;
        while(n>=m){
            right = right.next;
            n--;
        }
        for(int i=1; i<m; i++){
            left = left.next;
            right = right.next;
        }

        ListNode subhead = left.next;
        left.next = right.next;
        right.next = null;

        while(subhead!=null){
            ListNode temp = subhead.next;
            subhead.next = left.next;
            left.next = subhead;
            subhead = temp;
        }

        return nodeHead.next;
    }

    /**
     * 在自己写的函数2中,整个链表最大时间复杂度可能到达O(2*n),因为最大情况下可能遍历两遍
     * 以下方法对其进行改进,只需要遍历一遍即可完成倒置.可以看到程序结构性更好,并且逻辑更清晰<br/>
     * <br/>
     * <strong>测试结果:</strong>同上
     *
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween3(ListNode head, int m, int n) {
        if(head==null || head.next==null || m==n){
            return head;
        }

        ListNode nodeHead = new ListNode(0);
        nodeHead.next = head;
        ListNode pre = nodeHead;

        for(int i=1; i<m; i++){
            //少遍历一次,pre表示的是第m个元素的前一个结点
            pre = pre.next;
        }

        ListNode cur = pre.next;
        ListNode subHead = pre.next;//用来记录当前子链表的最初头位置
        ListNode subTail = null;//随着遍历子链表移动,到子链表的尾部位置

        for(int i=0; i<=n-m; i++){
            ListNode temp = cur.next;

            cur.next = subTail;
            subTail = cur;
            cur = temp;
        }

        pre.next = subTail;
        subHead.next = cur;

        return nodeHead.next;
    }

    public static void main(String[] args) {
        ReverseLinkedListII test = new ReverseLinkedListII();

        ListNode test1Head1 = new ListNode(1);
        ListNode test1Next2 = new ListNode(2);
        test1Head1.next = test1Next2;

        ListNode test2Head1 = new ListNode(1);
        ListNode test2Next2 = new ListNode(2);
        ListNode test2Next3 = new ListNode(3);
        ListNode test2Next4 = new ListNode(4);
        test2Head1.next = test2Next2;
        test2Next2.next = test2Next3;
        test2Next3.next = test2Next4;

        System.out.println(test.reverseBetween(test1Head1, 1, 2));
        System.out.println(test.reverseBetween1(test1Head1, 1, 2));

        System.out.println(test.reverseBetween(test2Head1, 1, 3));
        System.out.println(test.reverseBetween1(test2Head1, 1, 3));
    }
}
