package zhang.algorithm.leetcode.question290_Word_Pattern;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: zhang_MacPro
 * Date: 16/8/5
 * Time: 上午10:24
 * To change this template use File | Settings | File Templates.
 */
public class WordPattern {
    /**
     * <strong>result of test:</strong><br/>
     * 29 / 29 test cases passed
     * Status: Accepted
     * Runtime: 3 ms
     *
     * @param pattern
     * @param str
     * @return
     */
    public boolean wordPattern(String pattern, String str) {
        char[] pats = pattern.toCharArray();
        String[] strs = str.split(" ");
        if (pats.length != strs.length) return false;

        Map<Character, String> patMapStr = new HashMap();
        Map<String, Character> strMapPat = new HashMap();

        for (int i = 0; i < strs.length; i++) {
            String temp1 = patMapStr.get(pats[i]);
            Character temp2 = strMapPat.get(strs[i]);

            if (temp1 == null && temp2 == null) {
                patMapStr.put(pats[i], strs[i]);
                strMapPat.put(strs[i], pats[i]);
            } else if (temp1 != null && temp2 != null && temp1.equals(strs[i])) {
            } else return false;
        }
        return true;
    }

    public static void main(String[] args) {
        WordPattern test = new WordPattern();
        String pattern = "abba";
        String str = "dog cat cat dog";
        System.out.println(test.wordPattern(pattern, str));
    }
}
