package zhang.algorithm.leetcode.question299_Bulls_Cows;

/**
 * Created by IntelliJ IDEA.
 * User: zhang_MacPro
 * Date: 16/8/25
 * Time: 下午10:32
 * To change this template use File | Settings | File Templates.
 */
public class BullsCows {
    /**
     * <strong>result of test:</strong>
     * 151 / 151 test cases passed
     * Status: Accepted
     * Runtime: 2 ms, bit 97.99%
     *
     * @param secret
     * @param guess
     * @return
     */
    public String getHint(String secret, String guess) {
        char[] s = secret.toCharArray();
        char[] g = guess.toCharArray();
        int[] map = new int[10];

        for (int i = 0; i < s.length; i++) {
            map[s[i] - '0']++;
        }

        int sum = 0;
        for (int i = 0; i < g.length; i++) {
            if (map[g[i] - '0'] != 0) {
                map[g[i] - '0']--;
                sum++;
            }
        }

        int bull = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == g[i])
                bull++;
        }
        return bull + "A" + (sum - bull) + "B";
    }

    /**
     * only one loop
     * use two side of zero, one side +, another side -
     * this mind is very nice.
     * <p>
     * but the result is -->
     * 151 / 151 test cases passed
     * Status: Accepted
     * Runtime: 3 ms, bit 84.24%
     *
     * @param secret
     * @param guess
     * @return
     */
    public String getHint2(String secret, String guess) {
        int bull = 0;
        int cow = 0;
        int[] map = new int[10];
        int s, g;
        for (int i = 0; i < secret.length(); i++) {
            s = secret.charAt(i) - '0';
            g = guess.charAt(i) - '0';
            if (s == g) {
                bull++;
            } else {
                if (map[s] < 0) cow++;
                if (map[g] > 0) cow++;
                map[s]++;
                map[g]--;
            }
        }
        return bull + "A" + cow + "B";
    }

    public static void main(String[] args) {
        BullsCows test = new BullsCows();
        String secret = "1123";
        String guess = "0111";
        System.out.println(test.getHint(secret, guess));
        System.out.println(test.getHint2(secret, guess));
    }
}
