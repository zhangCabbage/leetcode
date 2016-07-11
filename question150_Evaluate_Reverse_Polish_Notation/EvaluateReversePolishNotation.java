package zhang.algorithm.leetcode.question150_Evaluate_Reverse_Polish_Notation;

import java.util.Stack;

/**
 * Created by IntelliJ IDEA.
 * User: zhang_MacPro
 * Date: 16/7/11
 * Time: 下午7:04
 * To change this template use File | Settings | File Templates.
 */
public class EvaluateReversePolishNotation {
    /**
     * 使用【逆波兰表示法】计算表达式的值
     *
     * <strong>result of test:</strong><br/>
     * 20 / 20 test cases passed
     * Status: Accepted
     * Runtime: 12 ms, bit 95.00%
     *
     * @param tokens
     * @return
     */
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < tokens.length; i++) {

            switch (tokens[i]) {
                case "+":
                    int m = stack.pop();
                    int n = stack.pop();
                    stack.push(m + n);
                    break;
                case "-":
                    m = stack.pop();
                    n = stack.pop();
                    stack.push(n - m);
                    break;
                case "*":
                    m = stack.pop();
                    n = stack.pop();
                    stack.push(m * n);
                    break;
                case "/":
                    m = stack.pop();
                    n = stack.pop();
                    stack.push(n / m);
                    break;
                default:
                    stack.push(string2int(tokens[i]));
            }
        }
        return stack.pop();
    }

    private int string2int(String str) {
        char first = str.charAt(0);
        int flag = 1;
        int result = 0;
        if (first == '-') {
            flag = -1;
        }else if (first != '+') {
            result = first - '0';
        }

        for (int i = 1; i < str.length(); i++) {
            result = result * 10 + (str.charAt(i) - '0');
        }
        return flag * result;
    }

    public static void main(String[] args) {
        EvaluateReversePolishNotation test = new EvaluateReversePolishNotation();
//        String[] tokens = {"2", "1", "+", "3", "*"};
        String[] tokens = {"4", "3", "-"};
        System.out.println(test.evalRPN(tokens));
    }
}
