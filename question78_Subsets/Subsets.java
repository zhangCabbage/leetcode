package zhang.algorithm.leetcode.question78_Subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhang_zack on 16/5/28.
 * 进行全组合
 */
public class Subsets {
    /**
     * 做过类似的题目<br/>
     * <br/>
     * <strong>测试结果:</strong><br/>
     * 10 / 10 test cases passed.<br/>
     * Status: Accepted<br/>
     * Runtime: 3 ms,只击败了15%<br/>
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);

        for(int i=0; i<(int)Math.pow(2, nums.length); i++){
            List<Integer> list = new ArrayList<Integer>();
            for(int j=0; j<nums.length; j++){
                if((i&(1<<j)) > 0){
                    list.add(nums[j]);
                }
            }
            result.add(list);
        }

        return result;
    }

}
