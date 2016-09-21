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

    //-----------------------------------------------------------------
    //second method
    //-----------------------------------------------------------------

    /**
     * nice
     *
     * @param num
     * @return
     */
    public List<String> readBinaryWatch2(int num) {
        List<String> times = new ArrayList<>();
        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                if (Integer.bitCount((h << 6) + m) == num)
                    times.add(String.format("%d:%02d", h, m));
            }
        }
        return times;
    }

    //-----------------------------------------------------------------
    //third method
    //-----------------------------------------------------------------
    String[][] hour = {
            {"0"},
            {"1", "2", "4", "8"},
            {"3", "5", "6", "9", "10"},
            {"7", "11"}
    };
    String[][] minute = {
            {"00"}, //1
            {"01", "02", "04", "08", "16", "32"}, //6
            {"03", "05", "06", "09", "10", "12", "17", "18", "20", "24", "33", "34", "36", "40", "48"}, //15
            {"07", "11", "13", "14", "19", "21", "22", "25", "26", "28", "35", "37", "38", "41", "42", "44", "49", "50", "52", "56"}, //20
            {"15", "23", "27", "29", "30", "39", "43", "45", "46", "51", "53", "54", "57", "58"}, //14
            {"31", "47", "55", "59"} //4
    };

    /**
     * what the fuck!
     *
     * @param num
     * @return
     */
    public List<String> readBinaryWatch3(int num) {
        List<String> ret = new ArrayList();
        for (int i = 0; i <= 3 && i <= num; i++) {
            if (num - i <= 5) { //!
                for (String str1 : hour[i]) {
                    for (String str2 : minute[num - i]) {
                        ret.add(str1 + ":" + str2);
                    }
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        BinaryWatch test = new BinaryWatch();
        int n = 1;
        System.out.println(test.readBinaryWatch(n));
        System.out.println(test.readBinaryWatch2(n));
        System.out.println(test.readBinaryWatch3(n));
    }
}
