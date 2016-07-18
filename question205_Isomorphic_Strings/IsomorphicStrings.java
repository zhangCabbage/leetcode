package zhang.algorithm.leetcode.question205_Isomorphic_Strings;

/**
 * Created by IntelliJ IDEA.
 * User: zhang_MacPro
 * Date: 16/7/18
 * Time: 下午9:14
 * To change this template use File | Settings | File Templates.
 */
public class IsomorphicStrings {
    /**
     * s --> t
     * 这道题我本来还以为需要保持各个元素之间的顺序关系,还想了好一会儿。
     * 但是看举的栗子,没有这个要求。那么就简单多了
     * <p>
     * 1、不同的s不能对应同一个t, t需要一个map, 存放t对应的s的值,
     * 2、同一个s需要对应同一个t, s需要一个map, 存放s对应的t的值, 用来对比
     * <p>
     * <strong>result of test:</strong><br/>
     * 30 / 30 test cases passed
     * Status: Accepted
     * Runtime: 4 ms, bit 97.66%
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic(String s, String t) {
        char[] schar = s.toCharArray();
        char[] tchar = t.toCharArray();

        if (schar.length != tchar.length) return false;

        int[] smap = new int[128];
        int[] tmap = new int[128];

        for (int i = 0; i < schar.length; i++) {
            if (smap[schar[i]] == 0 && tmap[tchar[i]] == 0) {
                smap[schar[i]] = tchar[i];
                tmap[tchar[i]] = schar[i];
            } else if (smap[schar[i]] != tchar[i] || tmap[tchar[i]] != schar[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        IsomorphicStrings test = new IsomorphicStrings();
        String s = "aa";
        String t = "ab";
        System.out.println(test.isIsomorphic(s, t));
    }
}
