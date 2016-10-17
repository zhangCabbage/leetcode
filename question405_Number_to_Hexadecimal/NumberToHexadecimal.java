package zhang.algorithm.leetcode.question405_Number_to_Hexadecimal;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 16/10/17
 * Time: 下午7:48
 * To change this template use File | Settings | File Templates.
 */
public class NumberToHexadecimal {
    /**
     * <strong>result of test:</strong>
     * 100 / 100 test cases passed
     * Status: Accepted
     * Runtime: 9 ms, bit 26.73% - 15.57%
     *
     * @param num
     * @return
     */
    public String toHex(int num) {
        int n = 0;
        StringBuffer sb = new StringBuffer();
        //从后往前进行处理
        int[] radic = {1, 2, 4, 8};
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < radic.length; j++) {
                if ((num & 1) == 1) {
                    n += radic[j];
                }
                num >>>= 1;
            }
            if (n < 10)
                sb.insert(0, n);
            else
                sb.insert(0, (char) ('a' + (n - 10)));
            n = 0;
        }

        //去掉前导0的逻辑
        while (sb.charAt(0) == '0' && sb.length() != 1) {
            sb.deleteCharAt(0);
        }

        return sb.toString();
    }

    /**
     * 100 / 100 test cases passed
     * Status: Accepted
     * Runtime: 10 ms, bit 51.92% - 26%
     *
     * @param num
     * @return
     */
    public String toHex2(int num) {
        char[] digits = "0123456789abcdef".toCharArray();
        //从前往后处理, 4个一组
        int i = 32 - 4;
        StringBuffer sb = new StringBuffer();
        boolean noZero = false;
        for (; i >= 0; i -= 4) {
            int tmp = (num & (0xf << i)) >>> i;
            if (tmp != 0 || noZero || i == 0) {
                sb.append(digits[tmp]);
                noZero = true;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        NumberToHexadecimal test = new NumberToHexadecimal();
        int num = 0;
        System.out.println(test.toHex(num));
        System.out.println(test.toHex2(num));
    }
}
