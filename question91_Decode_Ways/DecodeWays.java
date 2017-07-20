package zhang.algorithm.leetcode.question91_Decode_Ways;

/**
 * Created by zhang_zack on 16/6/3.
 */
public class DecodeWays {
    /**
     * 当我开始考虑多种情况的时候,总会头脑思路不太清晰.
     * 这道题虽然我知道使用动态规划是可以做,但是我反复提交测试多次才得以通过<br/>
     * <br/>
     * 整体代码if else的逻辑堆叠太多,导致解决一个小问题的代码量却很多,
     * 是不是可以有更好的办法呢?<br/>
     * <p>
     * <strong>测试结果:</strong><br/>
     * 259 / 259 test cases passed<br/>
     * Status: Accepted<br/>
     * Runtime: 2 ms,击败了68.71%<br/>
     *
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        if (s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }

        char[] c = s.toCharArray();
        int[] nums = new int[c.length];
        nums[0] = 1;

        for (int i = 1; i < c.length; i++) {
            if (i == 1) {
                if (c[0] > '2') {
                    if (c[1] == '0') {
                        return 0;
                    }
                    nums[1] = 1;
                } else if ((c[0] == '1' && c[1] == '0') || (c[0] == '2' && (c[1] > '6' || c[1] == '0'))) {
                    nums[1] = 1;
                } else {
                    nums[1] = 2;
                }
            } else {
                if (c[i - 1] == '1') {
                    if (c[i] == '0') {
                        nums[i] = nums[i - 2];
                    } else {
                        nums[i] = nums[i - 1] + nums[i - 2];
                    }
                } else if (c[i - 1] == '2') {
                    if (c[i] > '0' && c[i] < '7') {
                        nums[i] = nums[i - 1] + nums[i - 2];
                    } else if (c[i] == '0') {
                        nums[i] = nums[i - 2];
                    } else {
                        nums[i] = nums[i - 1];
                    }
                } else {
                    if (c[i] == '0') {
                        return 0;
                    }
                    nums[i] = nums[i - 1];
                }
            }
        }
        return nums[c.length - 1];
    }

    /**
     * 这里的程序简化做的相当的好,但是因为直接处理字符串,导致效率下降<br/>
     * <br/>
     * <strong>测试结果:</strong><br/>
     * 259 / 259 test cases passed<br/>
     * Status: Accepted<br/>
     * Runtime: 6 ms,击败12.42%<br/>
     *
     * @param s
     * @return
     */
    public int numDecodings2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int[] nums = new int[s.length() + 1];
        nums[0] = 1;
        nums[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i <= s.length(); i++) {
            int first = Integer.parseInt(s.substring(i - 1, i));
            int second = Integer.parseInt(s.substring(i - 2, i));

            if (first >= 1 && first <= 9) nums[i] += nums[i - 1];
            if (second >= 10 && second <= 26) nums[i] += nums[i - 2];

            if (nums[i] == 0) return 0;
        }
        return nums[s.length()];
    }

    public static void main(String[] args) {
        DecodeWays test = new DecodeWays();
        String s = "100";//110 10
        System.out.println(test.numDecodings(s));
    }
}
