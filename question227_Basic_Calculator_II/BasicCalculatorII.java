package zhang.algorithm.leetcode.question227_Basic_Calculator_II;

/**
 * Created by IntelliJ IDEA.
 * User: zhang_MacPro
 * Date: 16/8/16
 * Time: 下午10:05
 * To change this template use File | Settings | File Templates.
 */
public class BasicCalculatorII {
    /**
     * this easy problem I spend so much time on it
     *
     * @param s
     * @return
     */
    public int calculate(String s) {
        return calculate(s, 0, s.length() - 1);
    }

    /**
     * this way may be a simple way, but in case of 100000000/1/2/3/4/5/6/7/8/9/10
     * it will java.lang.ArithmeticException: / by zero
     *
     * @param s
     * @param start
     * @param end
     * @return
     */
    public int calculate(String s, int start, int end) {
        int temp = 0;
        for (int i = start; i <= end; i++) {
            char c = s.charAt(i);
            if (c == ' ') continue;
            if (c >= '0' && c <= '9') {
                temp = temp * 10 + (c - '0');
                continue;
            }
            switch (c) {
                case '+':
                    return temp + calculate(s, i + 1, end);
                case '-':
                    return temp - calculate(s, i + 1, end);
                case '*':
                    return temp * calculate(s, i + 1, end);
                case '/':
                    return temp / calculate(s, i + 1, end);
            }
        }
        return temp;
    }

    /**
     * first time I want use logic like below:
     * while (i < s.length()) {
     * char c = s.charAt(i);
     * if (c == ' ') continue;
     * if (c >= '0' && c <= '9') {}
     * }
     * But this can not hand the last number, if you must do like this, it will make
     * you coding bad.
     * think about 4-4/2 or 4+4/2
     * <p>
     * <strong>result of test:</strong>
     * 109 / 109 test cases passed
     * Status: Accepted
     * Runtime: 35 ms, bit 64.29%
     *
     * @param s
     * @return
     */
    public int calculate2(String s) {
        if (s.length() == 0) return 0;
        s = s.trim().replaceAll(" +", "");

        int res = 0;
        long pre = 0;
        char operator = '+';

        int i = 0;
        while (i < s.length()) {
            long cur = 0;
            while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                cur = cur * 10 + (s.charAt(i) - '0');
                i++;
            }
            //this way judge by number
            if (operator == '+') {
                res += pre;
                pre = cur;
            } else if (operator == '-') {
                res += pre;
                pre = -cur;
            } else if (operator == '*') {
                pre = pre * cur;
            } else if (operator == '/') {
                pre = pre / cur;
            }
            if (i < s.length()) operator = s.charAt(i++);
        }
        res += pre;

        return res;
    }

    /**
     * the technology of this problem solve method
     * the way of judge operator is in +_-_*_/, "".indexOf(c)
     * 这里使用两个操作符, perOperator 和 operator分别代表 前前操作符 和 前操作符,
     * perOperator初始为+, 以用来加pre的数
     * 对于 1-3/4 实际过程为:
     * res += 1
     * pre = -1*3
     * pre = pre/4
     * res += pre
     *
     * 109 / 109 test cases passed
     * Status: Accepted
     * Runtime: 14 ms, bit 95.04%
     *
     * @param s
     * @return
     */
    public int calculate3(String s) {
        int res = 0;

        char preOperator = '+';
        char operator = '*';
        long pre = 1;
        int cur = 0;
        for (int i = 0; i <= s.length(); i++) {
            char c = i == s.length() ? 0 : s.charAt(i);
            if (c == ' ') continue;
            if (c >= '0' && c <= '9') {
                cur = cur * 10 + (c - '0');
                continue;
            }
            //this way judge by the operator
            if (c == 0 || "+-*/".indexOf(c) >= 0) {
                pre = operator == '*' ? pre * cur : pre / cur;
                cur = 0;
                if (c == 0 || c == '+' || c == '-') {
                    res += preOperator == '-' ? -pre : pre;

                    preOperator = c;
                    operator = '*';
                    pre = 1;
                } else {
                    //if is * or /, we can do right now, so we storage it.
                    operator = c;
                }
            }

        }
        return res;
    }

    public static void main(String[] args) {
        BasicCalculatorII test = new BasicCalculatorII();
        String s = "  1 + 1";
        System.out.println(test.calculate3(s));
    }
}
