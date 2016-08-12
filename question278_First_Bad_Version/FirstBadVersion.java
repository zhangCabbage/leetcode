package zhang.algorithm.leetcode.question278_First_Bad_Version;

/**
 * Created by IntelliJ IDEA.
 * User: zhang_MacPro
 * Date: 16/8/12
 * Time: 下午8:26
 * To change this template use File | Settings | File Templates.
 */
public class FirstBadVersion {
    /**
     * <strong>result of test:</strong>
     * 21 / 21 test cases passed
     * Status: Accepted
     * Runtime: 18 ms, bit 54.15%
     *
     * @param n
     * @return
     */
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
//            int mid = (int) (((long) left + right) >> 1);
            int mid = left + (right - left) >> 1;
            //use this way need not to consider that over the limit of int
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    /**
     * this is more slow way!
     *
     * @param n
     * @return
     */
    public int firstBadVersion2(int n) {
        int start = 1;
        int end = n;
        if (isBadVersion(start)) return start;
        while (true) {
            int mid = start + ((end - start) >> 1);
            //attention this way + is prior than >>
            int next = mid + 1;
            if (mid == n) return n;
            boolean res = isBadVersion(mid);
            boolean nextRes = isBadVersion(next);
            if (!res && nextRes) return next;
            if (res) end = mid;
            if (!nextRes) start = next;
        }
    }

    private boolean isBadVersion(int version) {
        return version < 3 ? false : true;
    }

    public static void main(String[] args) {
        FirstBadVersion test = new FirstBadVersion();
        int n = 3;
        System.out.println(test.firstBadVersion(n));
    }
}
