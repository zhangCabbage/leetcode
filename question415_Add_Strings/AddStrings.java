package zhang.algorithm.leetcode.question415_Add_Strings;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 16/10/16
 * Time: 下午12:57
 * To change this template use File | Settings | File Templates.
 */
public class AddStrings {
    /**
     * <strong>result of test:</strong>
     * 315 / 315 test cases passed
     * Status: Accepted
     * Runtime: 32 ms
     *
     * @param num1
     * @param num2
     * @return
     */
    public String addStrings(String num1, String num2) {
        int index1 = num1.length();
        int index2 = num2.length();
        int curVal = 0;
        StringBuffer sb = new StringBuffer();

        while (index1 > 0 || index2 > 0) {
            int tmp1 = index1 > 0 ? num1.charAt(--index1) - '0' : 0;
            int tmp2 = index2 > 0 ? num2.charAt(--index2) - '0' : 0;
            int res = tmp1 + tmp2 + curVal;
            curVal = res / 10;
            sb.insert(0, res % 10);
        }
        if (curVal != 0)
            sb.insert(0, curVal);

        return sb.toString();
    }

    public static void main(String[] args) {
        AddStrings test = new AddStrings();
        String num1 = "9990";
        String num2 = "99290";
        System.out.println(test.addStrings(num1, num2));
    }
}
