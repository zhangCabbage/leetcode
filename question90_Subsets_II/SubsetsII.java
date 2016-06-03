package zhang.algorithm.leetcode.question90_Subsets_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhang_zack on 16/6/3.
 */
public class SubsetsII {
    /**
     * 只不过增加了与前面是否相同的判断,但是我觉得我思维的太慢,没能立马自然联想,并且觉得这个方法也有点烂
     * 传参感觉传的也不是很合理,仍需要看下别人的改进一下自己僵硬的思路.<br/>
     * <br/>
     * <strong>测试结果:</strong><br/>
     * 19 / 19 test cases passed<br/>
     * Status: Accepted<br/>
     * Runtime: 3 ms,击败了35.20%<br/>
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(nums);
        recusiveSearch(lists, list, nums, 0);
        return lists;
    }

    private void recusiveSearch(List<List<Integer>> lists, List<Integer> list, int[] nums, int start) {
        lists.add(list);
        for(int i=start; i<nums.length; i++){
            while(i!=start && nums[i]==nums[i-1]){
                i++;
                if(i == nums.length){
                    return;
                }
            }
            List<Integer> nextList = new ArrayList<Integer>(list);
            nextList.add(nums[i]);
            recusiveSearch(lists, nextList, nums, i+1);
        }
    }


    public static void main(String[] args) {
        SubsetsII test = new SubsetsII();
        int[] nums = {1, 2, 2};
        System.out.println(test.subsetsWithDup(nums));
    }
}
