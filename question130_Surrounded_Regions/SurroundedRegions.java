package zhang.algorithm.leetcode.question130_Surrounded_Regions;

import zhang.algorithm.modelUtil.Array.ArrayTool;

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by IntelliJ IDEA.
 * User: zhang_Lenovo
 * Date: 2016/6/26
 * Time: 20:15
 * To change this template use File | Settings | File Templates.
 */
public class SurroundedRegions {
    /**
     * X X X X           X X X X
     * X O O X   ====>   X X X X
     * X X O X   ====>   X X X X
     * X O X X           X O X X
     * <p>
     * How to solve this problem? I have no idea!!
     * the hit tags is Bread first traversal and union find! But it same like useless.
     * This is about handle of graph
     * <p>
     * Use breadth-first-traversal
     * <p>
     * <strong>result of test:</strong><br/>
     * 58 / 58 test cases passed<br/>
     * Status: Accepted<br/>
     * Runtime: 8 ms, bit 58.71%<br/>
     *
     * @param board
     */
    public void solve(char[][] board) {
        if (board.length < 3) return;
        if (board[0].length < 3) return;

        for (int j = 0; j < board[0].length; j++) {
            bfs(board, 0, j);
            bfs(board, board.length - 1, j);
        }
        for (int i = 1; i < board.length - 1; i++) {
            bfs(board, i, 0);
            bfs(board, i, board[0].length - 1);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void bfs(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O') return;

        Queue<Point> queue = new LinkedList<Point>();
        board[i][j] = '#';
        queue.offer(new Point(i, j));

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            if (point.x > 0 && board[point.x - 1][point.y] == 'O') {
                board[point.x - 1][point.y] = '#';
                queue.offer(new Point(point.x - 1, point.y));
            }
            if (point.x < board.length - 1 && board[point.x + 1][point.y] == 'O') {
                board[point.x + 1][point.y] = '#';
                queue.offer(new Point(point.x + 1, point.y));
            }
            if (point.y > 0 && board[point.x][point.y - 1] == 'O') {
                board[point.x][point.y - 1] = '#';
                queue.offer(new Point(point.x, point.y - 1));
            }
            if (point.y < board[0].length - 1 && board[point.x][point.y + 1] == 'O') {
                board[point.x][point.y + 1] = '#';
                queue.offer(new Point(point.x, point.y + 1));
            }
        }
        return;
    }

    /**
     * @param board
     */
    public void solve2(char[][] board) {

    }

    public static void main(String[] args) {
        SurroundedRegions test = new SurroundedRegions();
//        String[] strs = {
//                "XXXX",
//                "XOOX",
//                "OXOX",
//                "XOXX",
//        };
        String[] strs = {"XOOXXXOXOO", "XOXXXXXXXX", "XXXXOXXXXX", "XOXXXOXXXO", "OXXXOXOXOX", "XXOXXOOXXX", "OXXOOXOXXO", "OXXXXXOXXX", "XOOXXOXXOO", "XXXOOXOXXO"};
        char[][] board = ArrayTool.string2Char(strs);
        ArrayTool.printCharMatrix(board);
        test.solve(board);
        ArrayTool.printCharMatrix(board);
    }
}
