package zhang.algorithm.leetcode.question133_Clone_Graph;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: zhang_Lenovo
 * Date: 2016/7/1
 * Time: 21:26
 * To change this template use File | Settings | File Templates.
 */
public class CloneGraph {
    Map<Integer, UndirectedGraphNode> visitedMap = new HashMap<Integer, UndirectedGraphNode>();

    /**
     * slow handle to coding, Maybe I have thought but I always think about a lot thing.
     *
     * first I want to solve this problem by using queue to help me,
     * and I always think that it neighbors whether contains before.
     * like {0,1,2#1,2#2,2}.
     * But I was worry
     *
     * So, I see the answer that other people writing
     *
     * <strong>result of test:</strong><br/>
     * 12 / 12 test cases passed
     * Status: Accepted
     * Runtime: 5 ms, bit 66.77%
     *
     * @param node
     * @return
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;

        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        visitedMap.put(clone.label, clone);
        for (UndirectedGraphNode neighbor : node.neighbors) {
            //this way every time we must compare one time to judgement
            if (!visitedMap.containsKey(neighbor.label)) {
                clone.neighbors.add(cloneGraph(neighbor));
            } else {
                clone.neighbors.add(visitedMap.get(neighbor.label));
            }
        }
        return clone;
    }

    //--------------------------------------------------------------------------------
    //This is about graph traversal
    //--------------------------------------------------------------------------------

    /**
     * <strong>result of test:</strong><br/>
     * 12 / 12 test cases passed
     * Status: Accepted
     * Runtime: 4 ms, bit 94.51%
     *
     * so why this code way is more faster than others like before
     * This code do not use containKey
     *
     * @param node
     * @return
     */
    public UndirectedGraphNode cloneGraph2(UndirectedGraphNode node) {
        if (node == null) return null;
        HashMap<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
        return handler(node, map);
    }

    private UndirectedGraphNode handler(UndirectedGraphNode node, HashMap<Integer, UndirectedGraphNode> map) {
        UndirectedGraphNode res = new UndirectedGraphNode(node.label);
        map.put(node.label, res);
        for (UndirectedGraphNode n : node.neighbors) {
            UndirectedGraphNode nb = map.get(n.label);
            if (nb == null)
                nb = handler(n, map);
            res.neighbors.add(nb);
        }
        return res;
    }

    class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
    }
}
