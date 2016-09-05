package zhang.algorithm.leetcode.question372_Super_Pow;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 16/9/1
 * Time: 下午10:39
 * To change this template use File | Settings | File Templates.
 */
public class SuperPow {

    /**
     * straight and narrow
     * <p>
     * <strong>result of test:</strong>
     * 54 / 54 test cases passed
     * Status: Accepted
     * Runtime: 6 ms, bit 84.70%
     *
     * @param a
     * @param b
     * @return
     */
    public int superPow(int a, int[] b) {
        int res = 1;
        a %= 1337;  //if the a is very big

        for (int i = b.length - 1; i >= 0; i--) {
            //loop time by the number of b[i]
            for (int j = 0; j < b[i]; j++) {
                res *= a;
                res %= 1337;
            }

            //calculation a^10
            int temp = 0;
            for (int j = 0; j < 3; j++) {
                a *= a;
                a %= 1337;
                if (j == 0) temp = a;
            }
            a = a * temp % 1337;
        }
        return res;
    }

    //-----------------------------------------------------------------
    //second method
    //-----------------------------------------------------------------

    /**
     * the big cattle solution use fermat because of 1337 is 7 * 191
     * detail derivation process below
     * [https://discuss.leetcode.com/topic/50591/fermat-and-chinese-remainder]
     * <p>
     * x % 7 = u and x % 191 = w
     * w + 191t ≡ u (mod 7)
     * t ≡ 4(u-w) (mod 7)
     * <p>
     * so
     * x = w + 191t
     * ..= w + 191(4(u-w) + 7s)
     * ..= 764u - 763w + 1337s
     * ..= 764u + (1337-763)w + 1337(s-w)
     * ..= 764u + 574w + 1337(s-w)
     * <p>
     * 54 / 54 test cases passed
     * Status: Accepted
     * Runtime: 3 ms, bit 94.57%
     *
     * @param a
     * @param b
     * @return
     */
    public int superPow2(int a, int[] b) {
        return (superPow(a, b, 7) * 764 + superPow(a, b, 191) * 574) % 1337;
    }

    public int superPow(int a, int[] b, int prime) {
        a %= prime;
        if (a == 0) return 0;

        int e = 0;
        int mod = prime - 1; //attention please
        for (int digit : b) {
            e = (e * 10 + digit) % mod;
        }

        int pow = 1;
        while (e > 0) {
            if ((e & 1) == 1)
                pow = a * pow % prime;
            a = a * a % prime;
            e >>= 1;
        }
        return pow;
    }

    //-----------------------------------------------------------------
    //third method
    //-----------------------------------------------------------------

    /**
     * <strong>result of test:</strong>
     * 54 / 54 test cases passed
     * Status: Accepted
     * Runtime: 6 ms, bit 84.70%
     *
     * @param a
     * @param b
     * @return
     */
    public int superPow3(int a, int[] b) {
        int DIV = 1337;
        a %= DIV;
        if (a == 0 || a == 1) return a;

        boolean[] flags = new boolean[DIV];
        List<Integer> all = new ArrayList<>();
        int temp = a;

        while (!flags[temp]) {
            flags[temp] = true;
            all.add(temp);
            temp = temp * a % DIV;
        }

        temp = 0;
        for (int digit : b) {
            temp = (temp * 10 + digit) % all.size();
        }
        temp = (temp == 0) ? all.size() : temp;
        return all.get(temp - 1);
    }

    public static void main(String[] args) {
        SuperPow test = new SuperPow();
        int a = 2147483647;
        int[] b = {2, 0, 0};
        System.out.println(test.superPow(a, b));
        System.out.println(test.superPow2(a, b));
        System.out.println(test.superPow3(a, b));
    }
}
