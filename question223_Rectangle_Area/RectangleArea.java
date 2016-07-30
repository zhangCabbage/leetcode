package zhang.algorithm.leetcode.question223_Rectangle_Area;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: zhang_MacPro
 * Date: 16/7/30
 * Time: 下午10:22
 * To change this template use File | Settings | File Templates.
 */
public class RectangleArea {
    /**
     * I find the way to deal with this problem in a simple code.
     * But when I see other code
     * I think I still think too much things that make me coding so complexity.
     * <p>
     * <strong>result of test:</strong><br/>
     * 3081 / 3081 test cases passed
     * Status: Accepted
     * Runtime: 6 ms, bit 5.78%
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
        long area = Math.abs(C - A) * Math.abs(D - B);
        area += Math.abs(G - E) * Math.abs(H - F);

        if (E >= C || G <= A || H <= B || F >= D) return (int) area;

        int[] x = {A, C, E, G};
        int[] y = {B, D, F, H};

        Arrays.sort(x);
        Arrays.sort(y);

        area -= (x[2] - x[1]) * (y[2] - y[1]);
        return (int) area;
    }

    /**
     * this way we do not need to distinguish is C-A is positive or negative.
     * Great Idea.
     * <strong>result of test:</strong><br/>
     * 3081 / 3081 test cases passed
     * Status: Accepted
     * Runtime: 4-5 ms, bit 70.33 - 13.87%
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
    public int computeArea2(int A, int B, int C, int D, int E, int F, int G, int H) {
        int left = Math.max(A, E);
        int right = Math.max(Math.min(C, G), left);
        //why this place to find right need two compare
        //this way we need to distinguish whether the two rectangles is intersect or not.

        int bottom = Math.max(B, F);
        int top = Math.max(Math.min(D, H), bottom);

        return (C - A) * (D - B) - (right - left) * (top - bottom) + (G - E) * (H - F);
    }
}
