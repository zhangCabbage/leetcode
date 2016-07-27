package zhang.algorithm.leetcode.question207_Course_Schedule;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: zhang_MacPro
 * Date: 16/7/25
 * Time: 下午10:39
 * To change this template use File | Settings | File Templates.
 */
public class CourseSchedule {
    /**
     * this problem my mind to deal is to find a Directed graph have a ring。
     * But How to find, or change to another problem.
     * Graph algorithm I only know traversal right now, so can it do in this way.
     * <p>
     * About Topological Sort
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
     * We just need to judge whether there has a circle in course list
     * so much easier without DFS and BFS which we are thinking too complicate.
     * Maybe the author of this code is right , but I think the code has something wrong.
     * <p>
     * 0-1
     * 0-2
     * 1-3
     * 3-0
     * 2-4
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish2(int numCourses, int[][] prerequisites) {
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

    public static void main(String[] args) {
        CourseSchedule test = new CourseSchedule();
        int numCourses = 5;
        int[][] prerequisites = {
                {0, 1},
                {0, 2},
                {1, 3},
                {3, 0},
                {2, 4},
        };
        System.out.println(test.canFinish(numCourses, prerequisites));
        System.out.println(test.canFinish2(numCourses, prerequisites));
    }
}
