package zhang.algorithm.leetcode.question406_Queue_Reconstruction_by_Height;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 16/10/24
 * Time: 下午10:03
 * To change this template use File | Settings | File Templates.
 */
public class ReconstructionByHeight {
    /**
     * I can not solve this problem.
     * (https://leetcode.com/problems/queue-reconstruction-by-height/)
     * The below answer is wrong!!
     *
     * @param people
     * @return
     */
    public int[][] reconstructQueue(int[][] people) {
        List<int[]> tmp = new ArrayList<>();
        List<Integer> count = new ArrayList<>();

        for (int[] p : people) {
            int index = 0;
            int c = 0;
            //1、从前到后找一个满足插入条件的, 让大的尽量往后插入
            while (index < tmp.size() && c <= p[1]) {
                int[] cur = tmp.get(index);
                if (p[0] <= cur[0]) {
                    c++;
                }
                if (c != p[1] + 1) {
                    index++;
                }
            }
            tmp.add(index, p);
            count.add(index++, c - 1);

            //2、继续遍历后面的数, 找到不满足的, 前插
            while (index < tmp.size()) {
                int[] cur = tmp.get(index);
                if (p[0] > cur[0]) {
                    int curN = count.get(index);
                    if (curN == cur[1]) {
                        //向前寻找一个大于它的数, 插入其前面
                    } else {
                        count.set(index, curN + 1);
                    }
                }
                index++;
            }

        }

        return null;
    }

    /**
     * 37 / 37 test cases passed
     * Status: Accepted
     * Runtime: 87-90 ms, bit 20.72% - 23.04%
     *
     * @param people
     * @return
     */
    public int[][] reconstructQueue2(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] != b[0] ? b[0] - a[0] : a[1] - b[1]);
        List<int[]> res = new ArrayList<>();
        for (int[] arr : people) {
            res.add(arr[1], arr);
        }

        return res.toArray(new int[people.length][]);
    }

    public static void main(String[] args) {
        ReconstructionByHeight test = new ReconstructionByHeight();
    }
}
