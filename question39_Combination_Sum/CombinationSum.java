package zhang.algorithm.leetcode.question39_Combination_Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    /**
     * 我第一个想到的就是使用递归，这样我们很容易做出来。<br/>
     * AC---> 7ms <br/>
     * <strong>疑问：</strong><br/>
     * 1、关于在递归中反复使用List<Integer> temp = new ArrayList<Integer>(list)后内存回收的问题。 <br/>
     * 2、题目中有提示使用回溯法(backtracking)，但是此处如何使用回溯。关键是回溯的思想在这里和递归的区分！！ <br/>
     * <br/>
     * <strong>问题说明：</strong><br/>
     * 1、<br/>
     * 2、本题中你自己写的递归算法本身就自觉使用了回溯的思想<br/>
     * 3、扩展思维：if the candidate set may be used only once in the combination(如果给定候选数组每个数只能使用一次怎么办)？<br/>
     * subset-sum problem.
     * 正好这就是下一道题的问题Question40
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        if (candidates.length < 1 || target < candidates[0]) {
            return lists;
        }
        List<Integer> list = new ArrayList<Integer>();
        findCombination(lists, list, target, candidates, 0);
        return lists;
    }

    private void findCombination(List<List<Integer>> lists, List<Integer> list, int target, int[] candidates, int start) {
        if (target == 0) {
            lists.add(list);
        } else if (target > 0) {
            for (int i = start; i < candidates.length; i++) {
                if (candidates[i] > target) {
                    break;
                }
                List<Integer> temp = new ArrayList<Integer>(list);
                temp.add(candidates[i]);
                findCombination(lists, temp, target - candidates[i], candidates, i);

                //如果你疑惑内存的回收问题，那么我们使用另一种方式，而且这种方式更能反映递归的一些特性
//				list.add(candidates[i]);
//				findCombination(lists, list, target-candidates[i], candidates, i);
//				list.remove(candidates[i]);
                //但是这种方式有问题，因为list中可能存放了好几个相同的数

                //不过这里可能仍有一个改进方式。
                //用一个int数组来存放使用过的下标
                //可以参见：[【Print All Combinations of a Number as a Sum of Candidate Numbers】](http://articles.leetcode.com/print-all-combinations-of-number-as-sum)
            }
        }
        //否则，回溯！！
    }

    //-----------------------------------------------------------------------------------
    //Review Time: 2017-03-04 10:45:32
    //这么久重新做回溯的题目, 我对边界的控制以及回溯的逻辑把握已经很差了
    //-----------------------------------------------------------------------------------

    /**
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        if (candidates.length < 1 || target < candidates[0]) return list;

        fun(list, candidates, target, new ArrayList(), 0);
        return list;
    }

    private void fun(List<List<Integer>> list, int[] candidates, int remain, List<Integer> res, int start) {
        if (remain == 0) list.add(res);
        else if(remain > 0){ //可能有大于和小于0两种情况, 要分开
            for (int i = start; i < candidates.length; i++) {
                if (candidates[i] <= remain) {
                    List<Integer> tmp = new ArrayList(res);
                    tmp.add(candidates[i]);
                    fun(list, candidates, remain - candidates[i], tmp, i);
                } else break;
            }
        }
    }

    public static void main(String[] args) {
        CombinationSum test = new CombinationSum();
        int[] candidates = {2};
        int target = 7;
        System.out.println(test.combinationSum(candidates, target));
        System.out.println(test.combinationSum2(candidates, target));
    }
}
