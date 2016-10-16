package zhang.algorithm.leetcode.question412_Fizz_Buzz;

import java.util.Arrays;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 16/10/16
 * Time: 下午1:17
 * To change this template use File | Settings | File Templates.
 */
public class FizzBuzz {
    /**
     * <strong>result of test:</strong>
     * 8 / 8 test cases passed
     * Status: Accepted
     * Runtime: 6 ms
     *
     * @param n
     * @return
     */
    public List<String> fizzBuzz(int n) {
        String[] res = new String[n];
        for (int i = 0; i < n; i++) {
            res[i] = i + 1 + "";
        }

        for (int i = 1; i < n; i++) {
            if (i * 3 > n) break;
            if (i % 5 == 0)
                res[3 * i - 1] = "FizzBuzz";
            else
                res[3 * i - 1] = "Fizz";
        }

        for (int i = 1; i < n; i++) {
            if (i * 5 > n) break;
            if (i % 3 == 0)
                continue;
            else
                res[5 * i - 1] = "Buzz";
        }
        return Arrays.asList(res);
    }

    public static void main(String[] args) {
        FizzBuzz test = new FizzBuzz();
        System.out.println(test.fizzBuzz(50));
    }
}
