package zhang.algorithm.leetcode.question210_Course_Schedule_II;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by IntelliJ IDEA.
 * User: zhang_MacPro
 * Date: 16/8/1
 * Time: 上午10:20
 * To change this template use File | Settings | File Templates.
 */
public class CourseScheduleII {
    /**
     * <strong>result of test:</strong><br/>
     * 36 / 36 test cases passed
     * Status: Accepted
     * Runtime: 8 ms, bit 85.98%
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList();
        }
        for (int[] edge : prerequisites) {
            graph[edge[1]].add(edge[0]);
            inDegree[edge[0]]++;
        }

        int[] orderCourse = new int[numCourses];
        int count = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
                orderCourse[count++] = i;
            }
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int i = 0; i < graph[cur].size(); i++) {
                int index = graph[cur].get(i);
                if (--inDegree[index] == 0) {
                    orderCourse[count++] = index;
                    queue.offer(index);
                }
            }
        }

        if (count != numCourses) {
            orderCourse = new int[0];
        }
        return orderCourse;
    }

    /**
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public int[] findOrder2(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList();
        }
        for (int[] edge : prerequisites) {
            graph[edge[1]].add(edge[0]);
        }

        int[] visited = new int[numCourses];

        return null;
    }
}
