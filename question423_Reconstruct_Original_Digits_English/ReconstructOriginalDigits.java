package zhang.algorithm.leetcode.question423_Reconstruct_Original_Digits_English;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 16/11/3
 * Time: 下午7:42
 * To change this template use File | Settings | File Templates.
 */
public class ReconstructOriginalDigits {
    /**
     * hhahah, 竟然被我做出来了, 我真是太TM聪明了!!
     * zero
     * one
     * two
     * three
     * four
     * five
     * six
     * seven
     * eight
     * nine
     * * * * * * * * * * * * *
     * e --> 0, 1, 3, 3, 5, 7, 7, 8, 9
     * f --> 4, 5 ✔️ -> 5
     * g --> 8 ✔️
     * h --> 3, 8 ✔️ -> 3
     * i --> 5, 6, 8, 9 ✔️ -> 9
     * n --> 1, 7, 9, 9
     * o --> 0, 1, 2, 4 ✔️ -> 1
     * r --> 0, 3, 4
     * s --> 6, 7 ✔️ -> 6
     * t --> 2, 3, 8
     * u --> 4 ✔️
     * v --> 5, 7 ✔️ -> 7
     * w --> 2 ✔️
     * x --> 6 ✔️
     * z --> 0 ✔️
     * <p>
     * 24 / 24 test cases passed.
     * Status: Accepted
     * Runtime: 19 - 20 ms, bit 67.08 - 69.96%
     *
     * @param s
     * @return
     */
    public String originalDigits(String s) {
        int[] map = new int[26];  //a - z
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - 'a']++;
        }
        int[] digits = new int[10];
        digits[0] = map['z' - 'a'];
        digits[2] = map['w' - 'a'];
        digits[4] = map['u' - 'a'];
        digits[6] = map['x' - 'a'];
        digits[8] = map['g' - 'a'];

        digits[3] = map['h' - 'a'] - digits[8];
        digits[5] = map['f' - 'a'] - digits[4];
        digits[7] = map['v' - 'a'] - digits[5];
        digits[6] = map['s' - 'a'] - digits[7];

        digits[1] = map['o' - 'a'] - digits[0] - digits[2] - digits[4];
        digits[9] = map['i' - 'a'] - digits[5] - digits[6] - digits[8];

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < digits.length; i++) {
            while (digits[i]-- != 0) {
                sb.append(i);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ReconstructOriginalDigits test = new ReconstructOriginalDigits();
        String s = "owoztneoer";
        System.out.println(test.originalDigits(s));
    }
}
