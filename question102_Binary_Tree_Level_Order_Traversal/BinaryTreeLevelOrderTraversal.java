package zhang.algorithm.leetcode.question102_Binary_Tree_Level_Order_Traversal;

import zhang.algorithm.modelUtil.Tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by zhang_zack on 16/6/8.
 */
public class BinaryTreeLevelOrderTraversal {
    /**
     * ヾ(｡｀Д´｡)我这是有代码洁癖症啊啊,分分钟觉得我下面写的代码就是一坨屎。
     * ok,所以我自己又重新改了一遍
     *
     * <br/>
     * <strong>测试结果:</strong><br/>
     * 34 / 34 test cases passed<br/>
     * Status: Accepted<br/>
     * Runtime: 2 ms,击败57.82%<br/>
     * Runtime: 3 ms,击败14.45%<br/>
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        int curLevel=0, nextLevel = 0;
        int curIndex = 1;

        if(root != null){
            queue.offer(root);
            nextLevel++;
        }

        List<Integer> curLevelList = null;
        while(!queue.isEmpty()){
            if(curIndex == curLevel+1){
                curLevelList = new ArrayList<Integer>();
                result.add(curLevelList);
                //这里新建一个list列表之后立马加入到result中
                //这样可以避免在循环外还需要把最后一次的curLevelList加入到result中
                curLevel = nextLevel;
            }
            TreeNode curNode = queue.poll();
            curLevelList.add(curNode.val);

            if(curNode.left!=null){
                queue.offer(curNode.left);
                nextLevel++;
            }
            if(curNode.right!=null){
                queue.offer(curNode.right);
                nextLevel++;
            }
            curIndex++;
        }

        return result;
    }

    /**
     * 这里是第一版的代码,但是有点挫
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        int curLevel=0, nextLevel = 0;
        int curIndex = 1;

        if(root != null){
            queue.offer(root);
            curLevel++;
            nextLevel++;
        }

        List<Integer> curLevelList = null;
        while(!queue.isEmpty()){
            if(curIndex == 1 || curIndex == curLevel+1){
                if(curLevelList != null) result.add(curLevelList);
                curLevelList = new ArrayList<Integer>();
                curLevel = nextLevel;
            }
            TreeNode curNode = queue.poll();
            curLevelList.add(curNode.val);

            if(curNode.left!=null){
                queue.offer(curNode.left);
                nextLevel++;
            }
            if(curNode.right!=null){
                queue.offer(curNode.right);
                nextLevel++;
            }
            curIndex++;
        }
        if(curLevelList != null) result.add(curLevelList);

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left2 = new TreeNode(2);
        TreeNode right2 = new TreeNode(2);
        TreeNode left3 = new TreeNode(3);
        TreeNode right3 = new TreeNode(3);
        TreeNode left4 = new TreeNode(4);
        TreeNode right4 = new TreeNode(4);

        root.left = left2;
        root.right = right2;
        left2.left = left3;
        left2.right = right4;
        right2.left = left4;
        right2.right = right3;

        BinaryTreeLevelOrderTraversal test = new BinaryTreeLevelOrderTraversal();
        System.out.println(test.levelOrder(root));
    }
}
