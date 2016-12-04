package zhang.algorithm.leetcode.question434_Number_Segments_String;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 16/12/4
 * Time: 上午10:43
 * To change this template use File | Settings | File Templates.
 */
public class NumberSegmentsString {
    /**
     * @param s
     * @return
     */
    public int countSegments(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') count++;
        }
        return ++count;
    }

    public static void main(String[] args) {
        NumberSegmentsString test = new NumberSegmentsString();
        String s = "Hello, my name is John";
        System.out.println(test.countSegments(s));
    }
}
