package zhang.algorithm.leetcode.question341_Flatten_Nested_List_Iterator;

import java.util.*;

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
 * Runtime: 8 ms, bit 64.55%
 * ==>
 * 需要注意的一点是, 我这种实现如果不调用hasNext()的话, 调用next()返回的总是同一个数
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

        //方法1
        stack = new Stack<Iterator<NestedInteger>>();
        stack.push(nestedList.iterator());

        //方法2
        flattenedList = new LinkedList<>();
        flatten(nestedList);
        it = flattenedList.iterator();
    }

    //-----------------------------------------------------------------------------------
    //First method:
    //-----------------------------------------------------------------------------------
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


    //-----------------------------------------------------------------------------------
    //Second method:
    //通过存放iterator对象来方便查找下一个
    //这两种方式其实差不多, 具体视list的数据结构而定效率, 如果不为RandomAccess类型, 那么用next更快
    //-----------------------------------------------------------------------------------
    NestedInteger nextInt;
    Stack<Iterator<NestedInteger>> stack;

    public Integer next1() {
        return nextInt != null ? nextInt.getInteger() : null; //Just in case
    }

    public boolean hasNext1() {
        while (!stack.isEmpty()) {
            if (!stack.peek().hasNext()) stack.pop();
            else if ((nextInt = stack.peek().next()).isInteger()) return true;
            else stack.push(nextInt.getList().iterator());
        }
        return false;
    }

    //-----------------------------------------------------------------------------------
    //Third method:
    //不使用stack数据, 采用dfs的方式
    //这种方法的弊端就是如果测试时不遍历全部数据的话, 程序中其实我还是需要遍历全部数据
    //-----------------------------------------------------------------------------------

    private List<Integer> flattenedList;
    private Iterator<Integer> it;

    private void flatten(List<NestedInteger> nestedList) {
        for (NestedInteger i : nestedList) {
            if (i.isInteger()) {
                flattenedList.add(i.getInteger());
            } else {
                flatten(i.getList());
            }
        }
    }

    public Integer next2() {
        return it.next();
    }

    public boolean hasNext2() {
        return it.hasNext();
    }

    //-----------------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------

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
        while (i.hasNext1()) {
            System.out.println(i.next1());
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