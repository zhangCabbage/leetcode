package zhang.algorithm.leetcode.question341_Flatten_Nested_List_Iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 16/11/27
 * Time: 下午9:20
 * To change this template use File | Settings | File Templates.
 * <p>
 * 晚上头晕, 竟然整了1个半小时
 * 44 / 44 test cases passed.
 * Status: Accepted
 * Runtime: 9 ms, bit 48.35%
 */
public class NestedIterator implements Iterator<Integer> {
    private List<NestedInteger> nestedList;
    private Stack<List<NestedInteger>> listStack = new Stack<>();
    private Stack<Integer> nextIndexStack = new Stack<>();
    private NestedInteger curNestedInteger = null;
    private int curIndex = 0;

    /**
     * 这里需要注意[[]]、[[],2,[1,1]]的情况
     *
     * @param nestedList
     */
    public NestedIterator(List<NestedInteger> nestedList) {
        this.nestedList = nestedList;
    }

    @Override
    public Integer next() {
        return curNestedInteger.getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!listStack.isEmpty() || curIndex < nestedList.size()) {
            if (curIndex == nestedList.size()) {
                nestedList = listStack.pop();
                curIndex = nextIndexStack.pop();
                continue;
            }

            NestedInteger tmp = nestedList.get(curIndex++);
            if (tmp.isInteger()) {
                curNestedInteger = tmp;

                return true;
            } else {
                listStack.push(nestedList);
                nextIndexStack.push(curIndex);

                nestedList = tmp.getList();
                curIndex = 0;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Nested one_1 = new Nested(1);
        Nested one_2 = new Nested(1);
        List<Nested> list1 = new ArrayList<>();
        list1.add(one_1);
        list1.add(one_2);
        Nested one = null;

        Nested two = new Nested(2);

        Nested three_1 = new Nested(1);
        Nested three_2 = new Nested(1);
        List<Nested> list2 = new ArrayList<>();
        list2.add(three_1);
        list2.add(three_2);
        Nested three = new Nested(list2);

        List<NestedInteger> list = new ArrayList<>();
        list.add(one);
        list.add(two);
        list.add(three);

        NestedIterator i = new NestedIterator(list);
        while (i.hasNext()) {
            System.out.println(i.next());
        }
    }
}

interface NestedInteger {
    public boolean isInteger();

    public Integer getInteger();

    public List<NestedInteger> getList();
}

class Nested implements NestedInteger {
    private int num = 0;
    private List<NestedInteger> list = null;

    public Nested(int num) {
        this.num = num;
    }

    public Nested(List list) {
        this.list = list;
    }

    @Override
    public boolean isInteger() {
        return num != 0;
    }

    @Override
    public Integer getInteger() {
        return num;
    }

    @Override
    public List<NestedInteger> getList() {
        return list;
    }
}