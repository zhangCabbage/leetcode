package zhang.algorithm.leetcode.question40_Combination_Sum_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
	/**
	 * Question39的延伸扩展题型：递归回溯的变形<br/>
	 * 这里我尝试使用int类型的index数组，发现编码逻辑竟然挺复杂的，所以最后我弃疗了，选择了跟原39题类似的方式来实现<br/>
	 * 这里略有改进AC-->4ms<br/>
	 * 
	 * @param candidates
	 * @param target
	 * @return
	 */
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		if(candidates.length<1 || candidates[0]>target){
			return lists;
		}
		List<Integer> list = new ArrayList<Integer>();
		listAllCombination(lists, candidates, target, list, 0);
        return lists;
    }
	private void listAllCombination(List<List<Integer>> lists, int[] candidates, int target, List<Integer> list,
			int index) {
		if(target == 0){
			lists.add(list);
		}else if(target>0){
			for(int k=index; k<candidates.length; k++){
				if(k!=index && candidates[k]==candidates[k-1]){
					continue;
				}
				if(candidates[k] > target){
					break;
				}
				List<Integer> temp = new ArrayList<Integer>(list);
				temp.add(candidates[k]);
				listAllCombination(lists, candidates, target-candidates[k], temp, k+1);
			}
		}
	}

	public static void main(String[] args){
		CombinationSumII test = new CombinationSumII();
		int[] candidates = {1,1};
		int target = 1;
		System.out.println(test.combinationSum2(candidates, target));
	}
}
