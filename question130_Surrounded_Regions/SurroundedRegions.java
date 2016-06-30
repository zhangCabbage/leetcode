package zhang.algorithm.leetcode.question130_Surrounded_Regions;

/**
 * Created by IntelliJ IDEA.
 * User: zhang_Lenovo
 * Date: 2016/6/26
 * Time: 20:15
 * To change this template use File | Settings | File Templates.
 */
public class SurroundedRegions {
    /**
     *
     * X X X X           X X X X
     * X O O X   ====>   X X X X
     * X X O X   ====>   X X X X
     * X O X X           X O X X
     *
     * How to solve this problem? I have no idea!!
     * the hit tags is Bread first traversal and union find! But it same like useless.
     * This is about handle of graph
     *
     * Use breadth-first-traversal
     *
     * @param board
     */
    public void solve(char[][] board) {
        if(board.length<3) return;
        if(board[0].length<3) return;
        for(int j=0; j<board[0].length; j++){
            bfs(board, 0, j);
            bfs(board, board.length-1, j);
        }
        for(int i=0; i<board.length; i++){
            bfs(board, i, 0);
            bfs(board, i, board[0].length-1);
        }

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] == '#'){
                    board[i][j] = 'O';
                }else{
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void bfs(char[][] board, int i, int j) {

    }

    /**
     *
     * @param board
     */
    public void solve2(char[][] board) {

    }
}
