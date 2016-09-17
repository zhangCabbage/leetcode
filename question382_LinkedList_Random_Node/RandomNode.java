package zhang.algorithm.leetcode.question382_LinkedList_Random_Node;

import zhang.algorithm.modelUtil.List.ListNode;

import java.util.Random;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 16/9/1
 * Time: 下午10:25
 * To change this template use File | Settings | File Templates.
 */
public class RandomNode {
    ListNode head;
    Random random;

    /**
     * @param head The linked list's head.
     *             Note that the head is guaranteed to be not null, so it contains at least one node.
     */
    public RandomNode(ListNode head) {
        this.head = head;
        this.random = new Random();
    }

    /**
     * Returns a random node's value.
     * linked list is extremely large and its length is unknown, How to do?
     * the hint tag is Reservoir Sampling
     * <p>
     * 7 / 7 test cases passed
     * Status: Accepted
     * Runtime: 142 ms
     *
     * @return
     */
    public int getRandom() {
        ListNode curNode = this.head;
        int count = 0;
        int res = 0;
        while (curNode != null) {
            if (random.nextInt(++count) == 0) {
                res = curNode.val;
            }
            curNode = curNode.next;
        }
        return res;
    }

    public static void main(String[] args) {
        RandomNode test = new RandomNode(null);
    }
}
