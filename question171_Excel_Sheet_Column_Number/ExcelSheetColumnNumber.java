package zhang.algorithm.leetcode.question171_Excel_Sheet_Column_Number;

/**
 * Created by IntelliJ IDEA.
 * User: zhang_MacPro
 * Date: 16/7/8
 * Time: 下午8:55
 * To change this template use File | Settings | File Templates.
 */
public class ExcelSheetColumnNumber {
    /**
     *
     * <strong>result of test:</strong><br/>
     * 1000 / 1000 test cases passed
     * Status: Accepted
     * Runtime: 2 ms, bit 73.74%
     *
     * @param s
     * @return
     */
    public int titleToNumber(String s) {
        int result = 0;
        for(int i=0; i<s.length(); i++){
            int cur = s.charAt(i)-'A'+1;
            result = result*26 + cur;
        }
        return result;
    }
}
