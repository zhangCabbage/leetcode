package zhang.algorithm.leetcode.question401_Binary_Watch;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 16/9/21
 * Time: 下午9:30
 * To change this template use File | Settings | File Templates.
 */
public class BinaryWatch {
    private String curStr;
    private List<String> result;
    private int num;

    /**
     * the code is so bad
     * <p>
     * 10 / 10 test cases passed
     * Status: Accepted
     * Runtime: 3 ms, bit 62.84%
     *
     * @param num
     * @return
     */
    public List<String> readBinaryWatch(int num) {
        result = new ArrayList();
        this.num = num;
        for (int i = 0; i <= num; i++) {
            int[] hours = new int[4];
            hourValue(i, hours, 0);
        }

        return result;
    }

    private void hourValue(int num, int[] hours, int start) {
        if (num == 0) {
            int res = 0;
            int count = 0;
            int temp = 1;
            for (int i = 0; i < hours.length; i++) {
                if (hours[i] == 1) {
                    count++;
                    res += temp;
                }
                temp <<= 1;
            }
            if (res > 11) return;
            int[] minutes = new int[6];
            minuteValue(res + ":", this.num - count, minutes, 0);
            return;
        }
        for (int i = start; i < hours.length; i++) {
            hours[i] = 1;
            hourValue(num - 1, hours, i + 1);
            hours[i] = 0;
        }
    }

    private void minuteValue(String curStr, int num, int[] minutes, int start) {
        if (num == 0) {
            int res = 0;
            int temp = 1;
            for (int i = 0; i < minutes.length; i++) {
                if (minutes[i] == 1)
                    res += temp;
                temp <<= 1;
            }
            if (res > 59) return;
            if (res <= 9)
                curStr += "0";
            curStr += res;
            result.add(curStr);
            return;
        }
        for (int i = start; i < minutes.length; i++) {
            minutes[i] = 1;
            minuteValue(curStr, num - 1, minutes, i + 1);
            minutes[i] = 0;
        }
    }

    public static void main(String[] args) {
        BinaryWatch test = new BinaryWatch();
        int n = 2;
        System.out.println(test.readBinaryWatch(n));
    }
}
