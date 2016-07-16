package zhang.algorithm.leetcode.question166_Fraction_to_Recurring_Decimal;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: zhang_MacPro
 * Date: 16/7/15
 * Time: 下午2:55
 * To change this template use File | Settings | File Templates.
 */
public class FractionToRecurringDecimal {
    /**
     * fraction to recurring decimal - 由分数转变成十进制小数
     * 一定要逻辑清楚,考虑全面!!
     * 分子、分母有为负, 分子为-1、分母为-2147483648等等
     * 需要考虑当正常除法时, temp乘10,循环过大,int溢出的情况!!
     * -2147483648/-1 = 2147483648
     * -1/-2147483648 =
     * <p>
     * <strong>result of test:</strong><br/>
     * 35 / 35 test cases passed
     * Status: Accepted
     * Runtime: 3 ms, bit 96,97%
     * <p>
     * map中存放的键值对的含义为 : 之后对此key(余数)除的结果放在小数点之后第value(下标)位
     * <p>
     * 为什么我选择这种循环模式呢? 对余数进行先乘10做除法操作,再判断余数的循环模式
     * 编程中调试发现的, 这样可以保证不向sb中多添加余数。
     * 先把除法操作结果加入sb中, 然后比较余数是否已经存在, 如果已经存在, 那么就不在多添加了
     *
     * @param numerator   分子
     * @param denominator 分母
     * @return
     */
    public String fractionToDecimal(int numerator, int denominator) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        StringBuffer sb = new StringBuffer();

        if (numerator == 0) return "0";

        //注意对整数进行绝对值取正时,一定要注意溢出的情况!!
        long tempNumerator = Math.abs((long) numerator);
        long tempDenominator = Math.abs((long) denominator);

        int index = 0;
        int mod = (int) (tempNumerator % tempDenominator);
        long div = tempNumerator / tempDenominator;

        if ((numerator ^ denominator) < 0) sb.append("-");
        sb.append(div);
        if (mod != 0) {
            sb.append(".");
            map.put(mod, ++index);
        }

        while (mod != 0) {
            long temp = (long) mod * 10;
            mod = (int) (temp % tempDenominator);
            div = temp / tempDenominator;

            sb.append(div);

            Integer recur = map.get(mod);
            if (recur != null) {
                //循环小数
                sb.insert(sb.length() - (index - recur + 1), "(");
                sb.append(")");
                return sb.toString();
            }

            map.put(mod, ++index);

        }

        return sb.toString();
    }

    /**
     * <strong>result of test:</strong><br/>
     * 35 / 35 test cases passed
     * Status: Accepted
     * Runtime: 4 ms, bit 39,97%
     * <p>
     * 他的代码比我的更简洁
     *
     * @param numerator
     * @param denominator
     * @return
     */
    public String fractionToDecimal2(int numerator, int denominator) {
        StringBuilder result = new StringBuilder();
        if (1.0 * numerator / denominator < 0) {
            result.append("-");
        }
        long x = Math.abs((long) numerator);
        long y = Math.abs((long) denominator);
        result.append(x / y);
        x %= y;
        if (x == 0) {
            return result.toString();
        }
        result.append(".");
        Map<Long, Integer> map = new HashMap<>();
        while (x != 0 && !map.containsKey(x)) {
            map.put(x, result.length());
            x *= 10;
            result.append(x / y);
            x %= y;
        }
        if (x != 0) {
            result.insert(map.get(x), "(");
            result.append(")");
        }
        return result.toString();
    }

    public static void main(String[] args) {
//        测试
//        StringBuffer sb = new StringBuffer();
//        sb.append("1");
//        sb.append("2");
//        sb.append("3");
//        sb.append("4");
//        sb.insert(0, "0");//01234, stringbuffer的插入是以数组下标的方式进行定位插入的

        FractionToRecurringDecimal test = new FractionToRecurringDecimal();
        int numerator = -2147483648;
        int denominator = -1;
        System.out.println(test.fractionToDecimal(numerator, denominator));
    }
}
