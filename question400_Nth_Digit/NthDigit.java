package zhang.algorithm.leetcode.question400_Nth_Digit;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 16/9/19
 * Time: 下午11:02
 * To change this template use File | Settings | File Templates.
 */
public class NthDigit {
    /**
     * long time to thought, but i still can not has a clear good way to deal with it.
     *
     * @param n
     * @return
     */
    public int findNthDigit(int n) {
        if (n <= 9) return n;

        int total = 9;
        int len = 1;
        while (n > total) {
            n -= total;
            len++;
            total *= 10 * len;
        }
        int size = len * 10;
        int index = n % len == 0 ? len : n % len;
        int res = 0;
        if(index == 1) 
        for (int i = 0; i < index; i++) {

        }

        return 0;
    }

    public static void main(String[] args) {
        NthDigit test = new NthDigit();
        int n = 12;
        System.out.println(test.findNthDigit(n));
    }
}
