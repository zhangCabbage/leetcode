package zhang.algorithm.leetcode.question131_Palindrome_Partitioning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: zhang_Lenovo
 * Date: 2016/7/1
 * Time: 15:46 - 16:50 more than one hour
 * To change this template use File | Settings | File Templates.
 * <p>
 * Review Time: 2017-03-06 11:44:17
 * I almost forget it's my solution!
 */
public class PalindromePartitioning {
    /**
     * This problem is using backtracking.回溯的方法
     * No, you are a bad coding because of this problem is cost too much time.
     * <p>
     * My method has its two sides.
     * The way handle sudStr is bad.
     * <p>
     * <strong>result of test:</strong><br/>
     * 22 / 22 test cases passed<br/>
     * Status: Accepted<br/>
     * Runtime: 6 ms, bit 69.79%, use findAllPalindromeSubString<br/>
     * Runtime: 7 ms, bit 57.29%, use findAllPalindromeSubString2<br/>
     * <p>
     * But I do not know why it has this different
     *
     * @param s
     * @return
     */
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        int[] partition = new int[s.length()];
        findAllPalindromeSubString(result, s, 0, partition);
//        findAllPalindromeSubString2(result, s, 0, partition);
        return result;
    }

    private void findAllPalindromeSubString(List<List<String>> result, String s, int start, int[] partition) {
        if (start == s.length()) {
            //end the recursive find
            List<String> list = new ArrayList<String>();
            int l = 0;
            int r = 1;

            while (r < partition.length) {
                if (partition[r] != partition[r - 1]) {
                    list.add(s.substring(l, r));
                    l = r;
                }
                r++;
            }
            list.add(s.substring(l, r));
            result.add(list);
        } else {
            for (int k = 0; k < s.length() - start; k++) {
                //还得看能不能这样来分
                int l = start;
                int r = start + k;
                while (l < r && s.charAt(l) == s.charAt(r)) {
                    l++;
                    r--;
                }
                if (l < r) continue;

                for (int i = 0; i <= k; i++) {
                    partition[start + i] = start;
                }

                findAllPalindromeSubString(result, s, start + k + 1, partition);
            }
        }
    }

    private void findAllPalindromeSubString2(List<List<String>> result, String s, int start, int[] partition) {
        if (start == s.length()) {
            //end the recursive find
            List<String> list = new ArrayList<String>();
            int l = 0;
            int r = 1;

            while (r < partition.length) {
                if (partition[r] != partition[r - 1]) {
                    list.add(s.substring(l, r));
                    l = r;
                }
                r++;
            }
            list.add(s.substring(l, r));
            result.add(list);
        } else {
            for (int i = start; i < s.length(); i++) {
                if (isPalin(s, start, i)) {
                    Arrays.fill(partition, start, i + 1, start);

                    findAllPalindromeSubString(result, s, i + 1, partition);
                }
            }
        }
    }

    private boolean isPalin(String str, int start, int end) {
        while (start < end) {
            if (str.charAt(start++) != str.charAt(end--)) {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        PalindromePartitioning test = new PalindromePartitioning();
        String s = "aaabaaa";
        System.out.println(test.partition(s));
    }
}
