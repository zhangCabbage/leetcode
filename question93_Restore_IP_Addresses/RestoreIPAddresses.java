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

    public static void main(String[] args) {
        RestoreIPAddresses test = new RestoreIPAddresses();
        String s = "010010";
        System.out.println(test.restoreIpAddresses(s));
    }
}
