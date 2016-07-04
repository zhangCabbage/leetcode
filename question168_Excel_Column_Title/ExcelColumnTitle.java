package zhang.algorithm.leetcode.question168_Excel_Column_Title;

/**
 * Created by IntelliJ IDEA.
 * User: zhang_MacPro
 * Date: 16/7/4
 * Time: 下午7:34
 * To change this template use File | Settings | File Templates.
 */
public class ExcelColumnTitle {
    /**
     * <strong>result of test:</strong><br/>
     * 18 / 18 test cases passed
     * Status: Accepted
     * Runtime: 0 ms, bit 8.52%
     *
     * @param n
     * @return
     */
    public String convertToTitle(int n) {
        StringBuffer sb = new StringBuffer();
        while (n != 0) {
            sb.insert(0, String.valueOf((char) ((--n) % 26 + 'A')));
            n = n / 26;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ExcelColumnTitle test = new ExcelColumnTitle();
        System.out.println(test.convertToTitle(677));
    }
}
