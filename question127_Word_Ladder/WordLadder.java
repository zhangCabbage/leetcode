package zhang.algorithm.leetcode.question127_Word_Ladder;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: zhang_MacPro
 * Date: 16/6/24
 * Time: 上午10:20
 * To change this template use File | Settings | File Templates.
 * <p>
 * I have no thought right now.
 */
public class WordLadder {
    /**
     *
     * This problem is very like gray code. So I think can I use gray code here?
     * But when I think twice find that it can not do like that.
     * <p>
     * Finally, I give up.
     * 采用广度优先搜索的方式
     *
     * <strong>result of test:</strong><br/>
     * 37 / 37 test cases passed
     * Status: Accepted
     * Runtime: 134 ms, bit 22.84%
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        int level = 0;

        Queue<String> queue = new LinkedList<String>();
        Map<String, Boolean> map = new HashMap<String, Boolean>();

        queue.offer(beginWord);
        map.put(beginWord, true);

        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for (int i = 0; i < size; i++) {
                String curStr = queue.poll();

                for (int k = 0; k < curStr.length(); k++) {
                    char[] curChar = curStr.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        curChar[k] = c;
                        String str = String.valueOf(curChar);

                        if (str.equals(curStr)) continue;
                        if (str.equals(endWord)) return ++level;

                        if (wordList.contains(str) && map.get(str) == null) {
                            queue.offer(str);
                            map.put(str, true);
                        }
                    }
                }

            }
        }

        return 0;
    }

    public static void main(String[] args) {
        WordLadder test = new WordLadder();
        String beginWord = "hot";
        String endWord = "dog";

        String[] strs = {"hot", "dog", "dot"};

    }
}
