package zhang.algorithm.leetcode.question461_hamming_distance;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 17/2/26
 * Time: 下午7:52
 * To change this template use File | Settings | File Templates.
 */
public class HammingDistance {
    /**
     * 149 / 149 test cases passed.
     * Status: Accepted
     * Runtime: 12 ms, only bit 35.13%
     *
     * @param x
     * @param y
     * @return
     */
    public int hammingDistance(int x, int y) {
        int tmp = x ^ y;
        int dis = 0;
        while (tmp > 0) {
            dis++;
            tmp &= (tmp - 1);
        }
        return dis;
    }

    public static void main(String[] args) {
        HammingDistance test = new HammingDistance();
    }
}
