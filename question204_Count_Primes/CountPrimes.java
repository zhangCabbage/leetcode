package zhang.algorithm.leetcode.question204_Count_Primes;

/**
 * Created by IntelliJ IDEA.
 * User: zhang_MacPro
 * Date: 16/7/18
 * Time: 下午12:58
 * To change this template use File | Settings | File Templates.
 */
public class CountPrimes {
    /**
     * <strong>result of test:</strong><br/>
     * 20 / 20 test cases passed
     * Status: Accepted
     * Runtime: 107 ms, bit 10.31%
     *
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        int num = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i] == false) num++;
            int k = 2;
            while (i * k < n) {
                isPrime[i * k] = true;
                k++;
            }
        }
        return num;
    }

    /**
     * follow the third hint:
     * 2 × 6 = 12
     * 3 × 4 = 12
     * 4 × 3 = 12
     * 6 × 2 = 12
     * As you can see, calculations of 4 × 3 and 6 × 2 are not necessary.
     * So, for the first method when traversal to a nunmber that is not a prime.
     * We need not to product from 2---
     * <p>
     * <strong>result of test:</strong><br/>
     * 20 / 20 test cases passed
     * Status: Accepted
     * Runtime: 29 ms, bit 58.27%
     *
     * @param n
     * @return
     */
    public int countPrimes2(int n) {
        boolean[] isPrime = new boolean[n];
        int num = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i] == false) {
                num++;
                int k = 2;
                while (i * k < n) {
                    isPrime[i * k] = true;
                    k++;
                }
            }
        }
        return num;
    }

    /**
     * 我们可以知道,对于一个数,2*2、2*3、2*4、2*5...
     * 之后
     * 当遍历到5时,我们仍然使用5*2、5*3...
     * 其实这些之前我们已经算过了,所以只需要从5*5开始即可
     * <p>
     * <strong>result of test:</strong><br/>
     * 20 / 20 test cases passed
     * Status: Accepted
     * Runtime: 20 ms, bit 95.16%
     *
     * @param n
     * @return
     */
    public int countPrimes3(int n) {
        boolean[] isPrime = new boolean[n];
        int sqrtN = (int) Math.sqrt(n);
        int num = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i] == false) {
                num++;
                if (i > sqrtN) continue;
                int k = i;
                while (k * i < n) {
                    isPrime[i * k] = true;
                    k++;
                }
            }
        }
        return num;
    }

    public static void main(String[] args) {
        CountPrimes test = new CountPrimes();
        System.out.println(test.countPrimes(70));
        System.out.println(test.countPrimes2(70));
    }
}
