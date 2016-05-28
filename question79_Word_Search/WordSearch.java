package zhang.algorithm.leetcode.question79_Word_Search;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhang_zack on 16/5/28.
 */
public class WordSearch {
    private boolean isFind = false;
    private int[] dx = {-1, 1, 0, 0};
    private int[] dy = {0, 0, -1, 1};
    /**
     * 看来是个回溯问题,但是如何构造整个算法呢?似乎有点困难哦!!<br/>
     * 经过我这搓搓的编程技术,费了九牛二虎之力终于是自己做出来了,但是效果并不是太好<br/>
     * 这里一种方法是使用tag数组保留回溯状态,另一种方法是每次改变board字符数组的值
     * <br/>
     * <strong>测试结果:</strong><br/>
     * 87 / 87 test cases passed.<br/>
     * Status: Accepted<br/>
     * Runtime: 31 ms,只击败了10.32%的人<br/>
     *
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        if(words.length == 0){
            return false;
        }
        //整个回溯过程我们可以理解成把找到的点依次放入栈中
        List<List<Integer>> starts = findStartIndex(board, words[0]);
        for(int k=0; k<starts.size(); k++){
            int[][] tag = new int[board.length][board[0].length];
            int i = starts.get(k).get(0);
            int j = starts.get(k).get(1);
            tag[i][j] = -1;
            backtracking1(board, tag, words, i, j, 1);
            if(isFind){
                return isFind;
            }
        }
        return false;
    }

    private void backtracking1(char[][] board, int[][] tag, char[] words, int i, int j, int len) {
        if(len == words.length){
            this.isFind = true;
            return;
        }else{
            //找下一个i,j.按照从上到下,从左到右的顺序
            for(int k=0; k<4; k++){
                //上
                int newi = i+this.dx[k];
                int newj = j+this.dy[k];
                if( newi>=0 && newi<board.length && newj>=0 && newj<board[0].length && tag[newi][newj]!=-1 && board[newi][newj]==words[len] ){
                    tag[newi][newj] = -1;
                    backtracking1(board, tag, words, newi, newj, len+1);
                    if(isFind){
                        return;
                    }
                    tag[newi][newj] = 0;
                }
            }

        }
    }

    /**
     * 改进版,不需要使用标记数组的回溯方法<br/>
     * @param board
     * @param words
     * @param i
     * @param j
     * @param len
     */
    private void backtracking2(char[][] board, char[] words, int i, int j, int len) {
        if(len == words.length){
            this.isFind = true;
            return;
        }else{
            //找下一个i,j.按照从上到下,从左到右的顺序
            for(int k=0; k<4; k++){
                //上
                int newi = i+this.dx[k];
                int newj = j+this.dy[k];
                if( newi>=0 && newi<board.length && newj>=0 && newj<board[0].length && board[newi][newj]==words[len] ){
                    board[newi][newj] ^= 256;
                    backtracking2(board, words, newi, newj, len+1);
                    if(isFind){
                        return;
                    }
                    board[newi][newj] ^= 256;
                }
            }

        }
    }

    private List<List<Integer>> findStartIndex(char[][] board, char word) {
        List<List<Integer>> starts = new ArrayList<List<Integer>>();
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] == word){
                    List<Integer> position = new ArrayList<Integer>();
                    position.add(i);
                    position.add(j);
                    starts.add(position);
                }
            }
        }
        return starts;
    }

    public static void main(String[] args) {
        WordSearch test = new WordSearch();

        String[] strs = {"ABCE","SFCS","ADEE"};
        char[][] board = new char[strs.length][];
        for(int i=0; i<strs.length; i++){
            board[i] = strs[i].toCharArray();
        }
        String word = "ABCCED";

        System.out.println(test.exist(board, word));
    }
}
