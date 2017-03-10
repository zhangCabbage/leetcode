package zhang.algorithm.leetcode.question46_Permutations;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    /**
     * 25 / 25 test cases passed.<br/>
     * Status: Accepted<br/>
     * Runtime: 3 ms<br/>
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if (nums.length < 1) {
            return lists;
        }
        listAllPermute(lists, nums, 0);
        return lists;
    }

    private void listAllPermute(List<List<Integer>> lists, int[] nums, int start) {
        if (start == nums.length) {
            List<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i < nums.length; i++) {
                list.add(nums[i]);
            }
            lists.add(list);
        } else {
            for (int i = start; i < nums.length; i++) {
                if (isSwap(nums, start, i)) {
                    swap(nums, start, i);
                    listAllPermute(lists, nums, start + 1);
                    swap(nums, i, start);
                }
            }
        }
    }

    private boolean isSwap(int[] nums, int start, int cur) {
        for (int i = start; i < cur; i++) {
            if (nums[i] == nums[cur]) {
                return false;
            }
        }
        return true;
    }

    private void swap(int[] nums, int start, int i) {
        int temp = nums[start];
        nums[start] = nums[i];
        nums[i] = temp;
    }

    //----------------------------------------------------------------------------------------
    //Review Time: 2017-03-04 11:42:02
    //----------------------------------------------------------------------------------------

    /**
     * 这是最普通的方式, 太耗时 !!
     * <p>
     * 25 / 25 test cases passed.
     * Status: Accepted
     * Runtime: 10 ms, bit 14.66%
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if (nums.length < 1) return lists;

        List<Integer> remain = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            remain.add(nums[i]);
        }
        fun(lists, new ArrayList<>(), remain);
        return lists;
    }

    private void fun(List<List<Integer>> lists, List<Integer> res, List<Integer> remain) {
        if (remain.size() == 0) lists.add(res);
        else {
            for (int i = 0; i < remain.size(); i++) {
                List<Integer> tmp = new ArrayList<>(res);
                List<Integer> tmpR = new ArrayList<>(remain);
                tmp.add(remain.get(i));
                tmpR.remove(i);
                fun(lists, tmp, tmpR);
            }
        }
    }


    public static void main(String[] args) {
        Permutations test = new Permutations();
        int[] nums = {2, 2, 3};
        System.out.println(test.permute(nums));
    }
}
