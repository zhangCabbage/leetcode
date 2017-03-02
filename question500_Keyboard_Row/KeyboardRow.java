package zhang.algorithm.leetcode.question500_Keyboard_Row;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 17/2/26
 * Time: 下午8:46
 * To change this template use File | Settings | File Templates.
 */
public class KeyboardRow {
    /**
     * 22 / 22 test cases passed.
     * Status: Accepted
     * Runtime: 2 ms, bit 98.22%
     *
     * @param words
     * @return
     */
    public String[] findWords(String[] words) {
        int[] letter = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        int[] map = {0, -1, -1, 0, 1, 0, 0, 0, 1, 0, 0, 0, -1, -1, 1, 1, 1, 1, 0, 1, 1, -1, 1, -1, 1, -1};
        List<String> list = new LinkedList<>();
        for (int i = 0; i < words.length; i++) {
            int flag = 0;
            int j = 0;
            for (; j < words[i].length(); j++) {
                int c = Character.toLowerCase(words[i].charAt(j)) - 'a';
                if (j == 0) flag = map[c];
                if (flag != map[c]) break;
            }
            if (j == words[i].length())
                list.add(words[i]);
        }
        return list.toArray(new String[0]);
    }

    public static void main(String[] args) {
        KeyboardRow test = new KeyboardRow();
        String[] words = {"Hello", "Alaska", "Dad", "Peace"};
        System.out.println(Arrays.toString(test.findWords(words)));
    }
}
