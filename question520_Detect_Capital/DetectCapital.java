package zhang.algorithm.leetcode.question520_Detect_Capital;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 17/4/21
 * Time: 下午4:36
 * To change this template use File | Settings | File Templates.
 */
public class DetectCapital {
    /**
     * 550 / 550 test cases passed.
     * Status: Accepted
     * Runtime: 27 ms, bit 97.10%
     *
     * @param word
     * @return
     */
    public boolean detectCapitalUse(String word) {
        int j = -1;
        boolean flag = true;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                flag = i - j < 2;
                if (!flag) return flag;
                j = i;
            } else if (j > 0 && i > 1) return false;
        }
        return flag;
    }

    /**
     * cnt可以提早结束的
     * 550 / 550 test cases passed.
     * Status: Accepted
     * Runtime: 41 ms, bit 33.42%
     *
     * @param word
     * @return
     */
    public boolean detectCapitalUse2(String word) {
        int cnt = 0;  //大写字母个数
        for (char c : word.toCharArray()) if ('Z' - c >= 0) cnt++;
        return ((cnt == 0) || (cnt == word.length()) || ((cnt == 1) && ('Z' - word.charAt(0) >= 0)));
    }

    public static void main(String[] args) {
        DetectCapital test = new DetectCapital();
    }
}
