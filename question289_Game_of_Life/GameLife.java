package zhang.algorithm.leetcode.question289_Game_of_Life;

import zhang.algorithm.modelUtil.Array.ArrayTool;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 16/11/30
 * Time: 下午7:33
 * To change this template use File | Settings | File Templates.
 */
public class GameLife {
    /**
     * O(3 * m * n)
     * <p>
     * 22 / 22 test cases passed.
     * Status: Accepted
     * Runtime: 0 ms, bit 83.50%
     *
     * @param board
     */
    public void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] *= 8;
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] >= 8) {
                    if (i > 0) {
                        board[i - 1][j] += 1; //上
                        if (j > 0) board[i - 1][j - 1] += 1; //上左
                        if (j < board[0].length - 1) board[i - 1][j + 1] += 1; //上右
                    }
                    if (i < board.length - 1) {
                        board[i + 1][j] += 1; //下
                        if (j > 0) board[i + 1][j - 1] += 1; //下左
                        if (j < board[0].length - 1) board[i + 1][j + 1] += 1; //下右
                    }
                    if (j > 0) board[i][j - 1] += 1; //左
                    if (j < board[0].length - 1) board[i][j + 1] += 1; //右
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 3 || board[i][j] == 10 || board[i][j] == 11) {
                    board[i][j] = 1;
                } else {
                    board[i][j] = 0;
                }
            }
        }
    }

    /**
     * 看起来更加简洁
     * 但是时间复杂度更高 O(8 * m * n)
     * 22 / 22 test cases passed.
     * Status: Accepted
     * Runtime: 1 ms, bit 13.30%
     *
     * @param board
     */
    public void gameOfLife2(int[][] board) {
        int m = board.length;
        int n = m > 0 ? board[0].length : 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = 0;
                for (int I = Math.max(i - 1, 0); I < Math.min(i + 2, m); I++)
                    for (int J = Math.max(j - 1, 0); J < Math.min(j + 2, n); J++)
                        count += board[I][J] & 1;
                count -= board[i][j] & 1; //除掉当前的值

                if ((count | board[i][j]) == 3) { // 2_3
                    board[i][j] |= 2;
                }
            }
        }

        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                board[i][j] >>= 1;
    }

    public static void main(String[] args) {
        GameLife test = new GameLife();
        int[][] board = {{1, 1}, {1, 0}};
        test.gameOfLife2(board);
        ArrayTool.printIntMatrix(board);
    }
}
