package zhang.algorithm.leetcode.question207_Course_Schedule;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: zhang_MacPro
 * Date: 16/7/25
 * Time: 下午10:39
 * To change this template use File | Settings | File Templates.
 */
public class CourseSchedule {
    //----------------------------------------------------
    //classical topological sort by BFS
    //every time find the node that in-degree is zero, delete all edges from the node
    //----------------------------------------------------

    /**
     * this problem my mind to deal is to find a Directed graph have a ring。
     * But How to find, or change to another problem.
     * Graph algorithm I only know traversal right now, so can it do in this way.
     * <p>
     * About Topological Sort. I use topological sort, but I do not want to
     * use the queue to storage the node that in-degree is zero.
     * so I do like this, but prof it more slow.
     * <p>
     * <strong>result of test:</strong><br/>
     * 35 / 35 test cases passed
     * Status: Accepted
     * Runtime: 61 ms, bit 21.31%
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] coursesFinish = new int[numCourses];//存放入度
        int remainNum = numCourses;//表示入度为0的课程数

        for (int i = 0; i < prerequisites.length; i++) {
            int cur = prerequisites[i][1];
            if (coursesFinish[cur] == 0) remainNum--;
            coursesFinish[cur]++;
        }

        while (remainNum != 0) {
            for (int i = 0; i < numCourses; i++) {
                if (coursesFinish[i] == 0) {
                    remainNum--;
                    coursesFinish[i]--;
                    for (int k = 0; k < prerequisites.length; k++) {
                        if (prerequisites[k][0] == i) {
                            coursesFinish[prerequisites[k][1]]--;
                            if (coursesFinish[prerequisites[k][1]] == 0) remainNum++;
                        }

                    }
                }
            }
        }

        for (int i = 0; i < numCourses; i++) {
            if (coursesFinish[i] != -1) {
                return false;
            }
        }
        return true;
    }

    /**
     * But the result is not match with I thought, it is faster than last method.
     * <strong>result of test:</strong><br/>
     * 35 / 35 test cases passed
     * Status: Accepted
     * Runtime: 42 ms, bit 27.65%
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        int[] map = new int[numCourses];
        for (int[] edge : prerequisites) {
            map[edge[1]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (map[i] == 0) queue.offer(i);
        }

        int count = queue.size();
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int[] edge : prerequisites) {
                if (edge[0] == cur) {
                    map[edge[1]]--;
                    if (map[edge[1]] == 0) {
                        queue.offer(edge[1]);
                        count++;
                    }
                }
            }
        }
        return count == numCourses;
    }

    /**
     * 更标准的BFS,进行topological sort
     * <strong>result of test:</strong><br/>
     * 35 / 35 test cases passed
     * Status: Accepted
     * Runtime: 8 ms
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish3(int numCourses, int[][] prerequisites) {
        ArrayList[] graph = new ArrayList[numCourses]; //邻接表结构的图
        int[] inDegree = new int[numCourses]; //入度表

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList();
        }

        //构造
        for (int[] edge : prerequisites) {
            graph[edge[0]].add(edge[1]);
            inDegree[edge[1]]++;
        }

        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                count++;
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int i = 0; i < graph[cur].size(); i++) {
                int pointer = (int) graph[cur].get(i);
                inDegree[pointer]--;
                if (inDegree[pointer] == 0) {
                    count++;
                    queue.offer(pointer);
                }
            }
        }

        return count == numCourses;
    }

    //----------------------------------------------------
    //find ring in graph by DFS
    //----------------------------------------------------

    /**
     * We just need to judge whether there has a circle in course list
     * so much easier without DFS and BFS which we are thinking too complicate.
     * Maybe the author of this code is right , but the code has something wrong.
     * <p>
     * 0-1
     * 0-2
     * 1-3
     * 3-0
     * 2-4
     * <p>
     * 很明显只用一个flag数组来存放边的信息, 不够充分
     * 其实本题也是想用DFS的方式来进行遍历查找
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish4(int numCourses, int[][] prerequisites) {
        if (numCourses < 1) return false;
        if (numCourses == 1) return true;

        int[] flag = new int[numCourses];
        Arrays.fill(flag, -1);

        for (int[] i : prerequisites) {
            int start = i[0];
            flag[start] = i[1];
            int temp = i[1];

            while (flag[temp] != -1 && flag[temp] != start) {
                temp = flag[temp];
            }
            if (flag[temp] == start) {
                return false;
            }
        }

        return true;
    }

    /**
     * this way to find whether the graph has a ring or not is very nice!!
     * <p>
     * Directed graph traversal this method use a int visited array in a smart way
     * to avoid repeated traversal in DFS way.
     * Normal boolean array can not express multiple status.
     * <p>
     * <strong>result of test:</strong><br/>
     * 35 / 35 test cases passed
     * Status: Accepted
     * Runtime: 5 ms, bit 98.42%
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish5(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        //构造邻接表
        for (int[] edge : prerequisites) {
            graph[edge[0]].add(edge[1]);
        }

        int[] visited = new int[numCourses];
        //1 表示访问过了
        //-1 表示在一次深度优先遍历中访问过的
        //0 表示未访问

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(graph, visited, i)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(List[] graph, int[] visited, int cur) {
        if (visited[cur] == -1) return false;
        if (visited[cur] == 1) return true;
        visited[cur] = -1;
        for (int i = 0; i < graph[cur].size(); i++) {
            if (!dfs(graph, visited, (int) graph[cur].get(i))) {
                return false;
            }
        }
        visited[cur] = 1;
        return true;
    }

    public static void main(String[] args) {
        CourseSchedule test = new CourseSchedule();
        int numCourses = 2;
        int[][] prerequisites = {
                {1, 0},
        };
        System.out.println(test.canFinish(numCourses, prerequisites));
        System.out.println(test.canFinish2(numCourses, prerequisites));
        System.out.println(test.canFinish3(numCourses, prerequisites));
    }
}
