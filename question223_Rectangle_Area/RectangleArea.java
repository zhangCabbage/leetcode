package zhang.algorithm.leetcode.question223_Rectangle_Area;

/**
 * Created by IntelliJ IDEA.
 * User: zhang_MacPro
 * Date: 16/7/30
 * Time: 下午10:22
 * To change this template use File | Settings | File Templates.
 */
public class RectangleArea {
    /**
     * 为什么我总是在把问题复杂化呢
     *
     * @param A
     * @param B
     * @param C
     * @param D
     * @param E
     * @param F
     * @param G
     * @param H
     * @return
     */
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        long area = 0;
        int firstWidth = Math.abs(C - A);
        int firstHigh = Math.abs(D - B);
        int secondWidth = Math.abs(G - E);
        int secondHigh = Math.abs(H - F);
        area = firstWidth * firstHigh + secondWidth * secondHigh;
        if (E >= C || G <= A || H <= B || F >= D) return (int) area;


        return 0;
    }
}
