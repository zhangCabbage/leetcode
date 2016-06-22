package zhang.algorithm.leetcode.question116_Populating_Next_Right_Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by zhang_zack on 16/6/22.
 */
public class PopulatingNextRightNode {
    /**
     * use complexity data structure is always make program run slow.
     * <p>
     * And I also not see the note:
     * You may only use constant extra space.
     * You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
     * <p>
     * so my way to solve this problem is fault.
     *
     * @param root
     */
    public void connect(TreeLinkNode root) {
        if (root == null) return;

        Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size - 1; i++) {
                TreeLinkNode curNode = queue.poll();
                if (curNode.left != null) {
                    queue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    queue.offer(curNode.right);
                }
                curNode.next = queue.peek();
            }
        }
    }

    /**
     * this is the other boy's right result.
     *
     * @param root
     */
    public void connect2(TreeLinkNode root) {
        if (root == null) return;
        TreeLinkNode cur = root;
        TreeLinkNode nextLeftmost = null;

        while (cur.left != null) {
            nextLeftmost = cur.left; // save the start of next level
            while (cur != null) {
                cur.left.next = cur.right;
                cur.right.next = cur.next == null ? null : cur.next.left;
                cur = cur.next;
            }
            cur = nextLeftmost;  // point to next level
        }
    }

    /**
     * copy the below method with not to see one by one
     * @param root
     */
    public void connect3(TreeLinkNode root) {
        if (root == null) return;
        TreeLinkNode cur = root;
        TreeLinkNode nextLeft = null;

        while (cur.left != null) {
            nextLeft = cur.left;
            while (cur != null) {
                cur.left.next = cur.right;
                cur.right.next = cur.next == null ? null : cur.next.left;
                cur = cur.next;
            }
            cur = nextLeft;
        }

    }
}

class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;

    TreeLinkNode(int x) {
        val = x;
    }
}
