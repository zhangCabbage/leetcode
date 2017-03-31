package zhang.algorithm.leetcode.question36_Valid_Sudoku;

import java.util.Arrays;

/**
 * Review Time: 2017-03-27 10:11:45
 */
public class ValidSudoku {
    /**
     * 现在只是验证这个初始的数独是否满足数独的三个条件：<br/>
     * 1、每行为不重复1-9 <br/>
     * 2、每列为不重复1-9 <br/>
     * 3、每个九宫格为不重复1-9 <br/>
     * <p>
     * 501 / 501 test cases passed.
     * Status: Accepted
     * Runtime: 29 ms, bit 93.47%
     * [Review]:
     * MD, 我什么时候写的代码没有注释, 真是蛋疼!
     * 每次同时遍历一行一列, 每次临到[3的倍数]就遍历一个3*3小方格, 如此即可。
     * 不过这种方式会导致重复验证列!!
     *
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        int[] rowMap = new int[board.length];  //行
        int[] colMap = new int[board.length];  //列
        int[] cornerMap = new int[board.length];

        //每一行每一列不能有重复的1-9
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                char curRow = board[i][j];
                char curCol = board[j][i];

                if (curRow != '.') {
                    if (rowMap[curRow - '1'] != 1) {
                        rowMap[curRow - '1'] = 1;
                    } else {
                        return false;
                    }
                }
                if (curCol != '.') {
                    if (colMap[curCol - '1'] != 1) {
                        colMap[curCol - '1'] = 1;
                    } else {
                        return false;
                    }
                }
                if (i % 3 == 0 && j % 3 == 0) {
                    Arrays.fill(cornerMap, 0);
                    for (int m = 0; m < 3; m++) {
                        for (int n = 0; n < 3; n++) {
                            char curCorner = board[i + m][j + n];
                            if (curCorner != '.') {
                                if (cornerMap[curCorner - '1'] != 1) {
                                    cornerMap[curCorner - '1'] = 1;
                                } else {
                                    return false;
                                }
                            }
                        }
                    }
                }
            }
            Arrays.fill(rowMap, 0);
            Arrays.fill(colMap, 0);
        }

        return true;
    }

    /**
     * Review Time Result.
     * 501 / 501 test cases passed.
     * Status: Accepted
     * Runtime: 28 ms, bit 96.31%
     *
     * @param board
     * @return
     */
    public boolean isValidSudoku2(char[][] board) {
        int[] rowMap = new int[board.length];  //行
        int[] colMap = new int[board.length];  //列

        //每一行每一列不能有重复的1-9
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {

                if (board[i][j] != '.') {
                    int c = board[i][j] - '1';
                    int tmp = 1 << c;

                    if ((rowMap[i] & tmp) == 0) rowMap[i] |= tmp;
                    else return false;

                    if ((colMap[j] & tmp) == 0) colMap[j] |= tmp;
                    else return false;
                }

                if (i % 3 == 0 && j % 3 == 0) {
                    int cornerMap = 0;
                    for (int m = 0; m < 3; m++) {
                        for (int n = 0; n < 3; n++) {
                            if (board[i + m][j + n] == '.') continue;

                            int tmp = 1 << (board[i + m][j + n] - '1');
                            if ((cornerMap & tmp) == 0) cornerMap |= tmp;
                            else return false;
                        }
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        ValidSudoku test = new ValidSudoku();
        String[] strs = {".87654321", "2........", "3........", "4........", "5........", "6........", "7........", "8........", "9........"};
        char[][] board = new char[strs.length][];
        for (int i = 0; i < strs.length; i++) {
            board[i] = strs[i].toCharArray();
        }
        System.out.println(test.isValidSudoku(board));
    }
}
