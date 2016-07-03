package zhang.algorithm.leetcode.question155_Min_Stack;

/**
 * Created by IntelliJ IDEA.
 * User: zhang_MacPro
 * Date: 16/7/3
 * Time: 下午7:09
 * To change this template use File | Settings | File Templates.
 *
 * 测试发现,使用Java原生的Stack会超时 : Time Limit Exceeded
 * 我们这里只能使用数组来实现了!!
 *
 * <strong>result of test:</strong><br/>
 * 18 / 18 test cases passed<br/>
 * Status: Accepted<br/>
 * Runtime: 118 - 131 ms, bit 85.63 - 24.81%<br/>
 *
 */
public class MinStack {
    int[] stack;
    int index = 0;

    int min = Integer.MAX_VALUE;

    int minIndex = 0;
    boolean hasMin = true;

    public static int MaxSize = 7500;//min size needed

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new int[MaxSize];
        index = 0;
    }

    public void push(int x) {
        stack[index++] = x;
        if (hasMin && x < min) {
            min = x;
            minIndex = index-1;
        }
    }

    public void pop() {
        index--;
        if(index <= minIndex){
            hasMin = false;
        }
    }

    public int top() {
        return stack[index - 1];
    }

    public int getMin() {
        if(hasMin){
            return min;
        }else{
            min = Integer.MAX_VALUE;
            for (int i = 0; i < index; i++) {
                if (stack[i] < min) {
                    min = stack[i];
                    minIndex = i;
                }
            }
            hasMin = true;
            return min;
        }
    }
}
