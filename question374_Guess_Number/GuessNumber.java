package zhang.algorithm.leetcode.question374_Guess_Number;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 16/9/5
 * Time: 下午8:59
 * To change this template use File | Settings | File Templates.
 */
public class GuessNumber {
    private int Num = 4;

    public int guessNumber(int n) {
        int l = 1;
        int r = n;

        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            int res = guess(mid);
            if (res == 0) {
                return mid;
            } else if (res == -1) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return 0;
    }

    private int guess(int num) {
        if (this.Num == num) {
            return 0;
        } else if (num > this.Num) {
            return 1;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        GuessNumber test = new GuessNumber();
        System.out.println(test.guessNumber(10));
    }
}
