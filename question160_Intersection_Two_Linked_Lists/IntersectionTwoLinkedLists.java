package zhang.algorithm.leetcode.question160_Intersection_Two_Linked_Lists;

import zhang.algorithm.modelUtil.List.ListNode;

/**
 * Created by IntelliJ IDEA.
 * User: zhang_MacPro
 * Date: 16/7/3
 * Time: 下午11:33
 * To change this template use File | Settings | File Templates.
 */
public class IntersectionTwoLinkedLists {

    /**
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA = headA, tempB = headB;
        if(tempA == null || tempB == null) return null;

        int lenA = 0;
        int lenB = 0;
        while(tempA != null || tempB != null){
            if(tempA != null){
                lenA++;
                tempA = tempA.next;
            }
            if(tempB != null){
                lenB++;
                tempB = tempB.next;
            }
        }
        lenA = (lenA < lenB) ? 0 : lenA-lenB;
        lenB = (lenB < lenA) ? 0 : lenB-lenA;
        tempA = headA;
        tempB = headB;
        for(int i=0; i<lenA; i++){
            tempA = tempA.next;
        }
        for(int i=0; i<lenB; i++){
            tempB = tempB.next;
        }
        while(tempA!= null && tempA != tempB){
            tempA = tempA.next;
            tempB = tempB.next;
        }
        return tempA;
    }

    public static void main(String[] args) {

    }
}
