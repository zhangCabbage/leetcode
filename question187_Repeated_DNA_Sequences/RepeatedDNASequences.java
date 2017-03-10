package zhang.algorithm.leetcode.question187_Repeated_DNA_Sequences;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: zhang_MacPro
 * Date: 16/7/22
 * Time: 下午11:01
 * To change this template use File | Settings | File Templates.
 */
public class RepeatedDNASequences {
    private int[] next;

    /**
     * I think that this problem can be solve with the method like KMP
     * But I think worry. Time Limit Exceeded
     * KMP的时间复杂度为O(m+n), 但是同时我把这个过程重复了n次,所以时间复杂度为 O(n*(m+n))
     * 假如使用map形式,我们每次只需要把对应长度的子串放入map中即可,时间复杂度为 O(n)
     *
     * @param s
     * @return
     */
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<String>();
        if (s == null || s.length() < 10) return res;

        next = new int[10];

        for (int i = 0; i < s.length() - 10; i++) {
            int fas = fastestLongth(s, i);
            if (fas > 10) {
                res.add(s.substring(i, i + 10));
                i += (fas - 10 + 1);
            } else {
                String subStr = s.substring(i, i + 10);
                findNext(subStr);
                if (isMatch(s, i + fas, subStr)) {
                    res.add(s.substring(i, i + 10));
                }
            }
        }

        return res;
    }

    private void findNext(String s) {
        int num = -1;
        next[0] = num;
        int cur = 0;
        while (cur < s.length() - 1) {
            if (num == -1 || s.charAt(num) == s.charAt(cur)) {
                next[++cur] = ++num;
            } else {
                num = next[num];
            }
        }
    }

    private boolean isMatch(String matStr, int start, String patStr) {
        int p = start; //mat index
        int t = 0; //pat index
        while (p < matStr.length() && t < patStr.length()) {
            if (t == -1 || matStr.charAt(p) == patStr.charAt(t)) {
                p++;
                t++;
            } else {
                t = next[t];
            }
        }
        if (t == patStr.length()) {
            return true;
        }
        return false;
    }

    private int fastestLongth(String s, int t) {
        int len = 1;
        while (t + len < s.length()) {
            if (s.charAt(t) == s.charAt(t + len)) {
                len++;
            } else {
                break;
            }
        }
        return len;
    }

    //---------------------------------------------------------------------
    //这里主要考虑只有四个字母ACGT, 所以可以针对性的进行mapKey优化
    //---------------------------------------------------------------------

    /**
     * Review Time: 2017-03-03 20:02:04
     * I can not to solve it !
     * <p>
     * <strong>result of test:</strong><br/>
     * 32 / 32 test cases passed
     * Status: Accepted
     * Runtime: 42 ms, bit 53.81%
     *
     * @param s
     * @return
     */
    public List<String> findRepeatedDnaSequences2(String s) {
        List<String> res = new ArrayList<String>();
        if (s == null || s.length() < 11) return res;

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('A', 0);
        map.put('C', 1);
        map.put('G', 2);
        map.put('T', 3);

        Set<Integer> first = new HashSet<Integer>();
        Set<Integer> second = new HashSet<Integer>();
        int hash = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i < 9) {
                hash = (hash << 2) + map.get(c);
            } else {
                hash = (hash << 2) + map.get(c);
                hash &= (1 << 20) - 1;

                if (!first.add(hash) && second.add(hash)) {
                    res.add(s.substring(i - 9, i + 1));
                }
            }
        }

        return res;
    }

    /**
     * 进一步优化
     * <strong>result of test:</strong><br/>
     * 32 / 32 test cases passed
     * Status: Accepted
     * Runtime: 35 ms, bit 89.09%
     *
     * @param s
     * @return
     */
    public List<String> findRepeatedDnaSequences3(String s) {
        List<String> res = new ArrayList<String>();
        if (s == null || s.length() < 11) return res;

        HashSet<Integer> once = new HashSet<Integer>();
        HashSet<Integer> twice = new HashSet<Integer>();

        int[] map = new int[26];
        map['A' - 'A'] = 0;
        map['C' - 'A'] = 1;
        map['G' - 'A'] = 2;
        map['T' - 'A'] = 3;
        int hash = 0;

        for (int i = 0; i < 9; ++i) {
            hash <<= 2;
            hash |= map[s.charAt(i) - 'A'];
        }
        for (int j = 9; j < s.length(); ++j) {
            hash <<= 2;
            hash &= 0xfffff;
            hash |= map[s.charAt(j) - 'A'];
            if (!once.add(hash) && twice.add(hash))
                res.add(s.substring(j - 9, j + 1));
        }

        return res;
    }

    public static void main(String[] args) {
        RepeatedDNASequences test = new RepeatedDNASequences();
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        System.out.println(test.findRepeatedDnaSequences2(s));
    }
}
