package zhang.algorithm.leetcode.question237_Delete_Node_in_Linked_List;

import zhang.algorithm.modelUtil.List.ListNode;

/**
 * Created by IntelliJ IDEA.
 * User: zhang_MacPro
 * Date: 16/8/23
 * Time: 下午10:53
 * To change this template use File | Settings | File Templates.
 */
public class DeleteNodeInLinkedList {
    /**
     * this problem I can not understand it mean, it expression not clear
     * the node is one of the linked list, need you to delete this node from current linked list
     *
     * @param node
     */
    public void deleteNode(ListNode node) {
        if (node == null) {
            return;
        }
        if (node.next == null) {
            node = null;
            return;
        }
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
