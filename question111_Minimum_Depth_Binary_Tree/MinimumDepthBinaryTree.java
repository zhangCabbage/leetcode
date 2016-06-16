package zhang.algorithm.leetcode.question111_Minimum_Depth_Binary_Tree;

import zhang.algorithm.modelUtil.Tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by zhang_zack on 16/6/15.
 */
public class MinimumDepthBinaryTree {
    /**
     * this problem is to find min depth of tree.<br/>
     * <br/>
     * <strong>result of test:</strong><br/>
     * 41 / 41 test cases passed<br/>
     * Status: Accepted<br/>
     * Runtime: 1 ms, beat 11.23%<br/>
     *
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        int depth = 0;//use to record the depth of traversal

        int curIndex = 1;//current Index
        int curLevel = 0;//current level max Index
        int nextLevel = 0;//use to record the number of node that are currently in queue.
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if(root != null){
            queue.offer(root);
            nextLevel++;
        }
        while(!queue.isEmpty()){
            if(curIndex == curLevel+1){
                curLevel = nextLevel;
                depth++;
            }

            TreeNode curNode = queue.poll();
            curIndex++;

            if(curNode.left != null){
                queue.offer(curNode.left);
                nextLevel++;
            }
            if(curNode.right != null){
                queue.offer(curNode.right);
                nextLevel++;
            }
            if(curNode.left==null && curNode.right==null){
                break;
            }
        }
        return depth;
    }

    /**
     * use other way BFS to solve this problem,structure of this code is more easy that my first way.<br/>
     * <br/>
     * the result of test is same with first way.<br/>
     * @param root
     * @return
     */
    public int minDepth2(TreeNode root){
        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if(root == null){
            return depth;
        }
        queue.offer(root);
        while(queue.peek() != null){
            depth++;
            int size = queue.size();
            for(int i=0; i<size; i++){
                TreeNode curNode = queue.poll();
                if(curNode.left==null && curNode.right==null){
                    return depth;
                }
                if(curNode.left!=null){
                    queue.offer(curNode.left);
                }
                if(curNode.right!=null){
                    queue.offer(curNode.right);
                }
            }
        }
        //impossible to go this step!
        return 0;
    }

    /**
     * use recursive way to solve problem.<br/>
     * <br/>
     * the result of test is same with first way.<br/>
     * <br/>
     * @param root
     * @return
     */
    public int minDepth3(TreeNode root){
        int depth = 0;
        if(root == null){
            return depth;
        }
        if(root.left!=null && root.right!=null){
            int leftDepth = minDepth3(root.left);
            int rightDepth = minDepth3(root.right);
            depth = Math.min(leftDepth, rightDepth);
        }else if(root.left != null){
            depth = minDepth3(root.left);
        }else if(root.right != null){
            depth = minDepth3(root.right);
        }
        return depth+1;
    }
}
