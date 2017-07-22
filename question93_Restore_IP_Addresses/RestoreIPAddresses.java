package zhang.algorithm.leetcode.question93_Restore_IP_Addresses;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhang_zack on 16/6/5.
 * <p>
 * Review Time: 2017-03-05 11:05:09
 * <p>
 * 现在的思路: 递归时直接使用subString来传值
 * 以前的思路: 使用int[]数组来存储关键点位置
 */
public class RestoreIPAddresses {
    private List<String> results = null;

    /**
     * 本题使用递归回溯的方法<br/>
     * <br/>
     * <strong>测试结果:</strong><br/>
     * 147 / 147 test cases passed<br/>
     * Status: Accepted<br/>
     * Runtime: 3 ms,击败84.97%<br/>
     *
     * @param s
     * @return
     */
    public List<String> restoreIpAddresses(String s) {
        results = new ArrayList<String>();
        char[] c = s.toCharArray();

        int[] position = new int[5];
        position[4] = c.length;

        recusiveRestore(c, position, 0, 1);
        return results;
    }

    private void recusiveRestore(char[] c, int[] position, int start, int step) {
        if (step == 5) {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < 4; i++) {
                sb.append(c, position[i], position[i + 1] - position[i]);
                if (i != 3) {
                    sb.append(".");
                }
            }
            results.add(sb.toString());
        } else {
            position[step - 1] = start;
            int len = (c.length - start - 3 * (4 - step)) > 0 ? (c.length - start - 3 * (4 - step)) : 1;
            while (start + len <= c.length - (4 - step) && len <= 3) {
                if (c[start] == '0' && len != 1) {
                    break;
                }
                int num = Integer.parseInt(String.valueOf(c, start, len));
                if (num < 256) {
                    recusiveRestore(c, position, start + len, step + 1);
                }
                len++;
            }
        }
    }


    //-----------------------------------------------------------------------------------------------------
    // review code, date: 2017/7/22
    //-----------------------------------------------------------------------------------------------------
    private List<String> res = null;

    /**
     * 4:38 - 5:00
     *
     * @param s
     * @return
     */
    public List<String> restoreIpAddresses2(String s) {
        res = new ArrayList<>();
        if (s == null || s.length() < 4) return res;

        int[] position = new int[5];
        position[4] = s.length();
        restoreIpAddresses(s.toCharArray(), 0, 1, position);

        return res;
    }

    private void restoreIpAddresses(char[] c, int start, int step, int[] position) {
        if (step == 5) {
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i < position.length; i++) {
                if (i != 1) sb.append(".");
                sb.append(c, position[i - 1], position[i] - position[i - 1]);
            }
            res.add(sb.toString());
        } else {
            int minl = Math.max((c.length - start) - 3 * (4 - step), 1);
            int maxl = Math.min((c.length - start) - (4 - step), 3);
            while (minl <= maxl) {
                if ((c[start] == '0' && minl != 1) || Integer.parseInt(String.valueOf(c, start, minl)) > 255) break;
                position[step - 1] = start;
                restoreIpAddresses(c, start + minl, step + 1, position);
                minl++;
            }
        }
    }

    public static void main(String[] args) {
        RestoreIPAddresses test = new RestoreIPAddresses();
        String s = "010010";
        System.out.println(test.restoreIpAddresses(s));
    }
}
