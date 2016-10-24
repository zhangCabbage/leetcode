package zhang.algorithm.leetcode.question419_Battleships_in_Board;

import zhang.algorithm.modelUtil.Array.ArrayTool;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 16/10/24
 * Time: 下午9:41
 * To change this template use File | Settings | File Templates.
 */
public class BattleshipsInBoard {
    /**
     * 28 / 28 test cases passed
     * Status: Accepted
     * Runtime: 4 ms, bit 46.12%
     *
     * @param board
     * @return
     */
    public int countBattleships(char[][] board) {
        int count = 0;
        if (board == null || board.length < 1 || board[0].length < 1) return count;

        if (board[0][0] == 'X') count++;
        //0列
        for (int i = 1; i < board.length; i++) {
            if (board[i][0] == '.') continue;
            if (board[i - 1][0] != 'X') count++;
        }

        //0行
        for (int i = 1; i < board[0].length; i++) {
            if (board[0][i] == '.') continue;
            if (board[0][i - 1] != 'X') count++;
        }

        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board[0].length; j++) {
                if (board[i][j] == '.') continue;
                if (board[i - 1][j] != 'X' && board[i][j - 1] != 'X') count++;
            }
        }
        return count;
    }

    /**
     * 代码优化
     *
     * @param board
     * @return
     */
    public int countBattleships2(char[][] board) {
        int count = 0;
        if (board == null || board.length < 1) return count;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') continue;
                if (i > 0 && board[i - 1][j] == 'X') continue;
                if (j > 0 && board[i][j - 1] == 'X') continue;
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        BattleshipsInBoard test = new BattleshipsInBoard();
        String[] str = {""};
        System.out.println(test.countBattleships(ArrayTool.string2Char(str)));

    }
}
