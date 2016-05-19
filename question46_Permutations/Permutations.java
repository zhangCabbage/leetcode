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
    	if(nums.length < 1){
    		return lists;
    	}
    	listAllPermute(lists, nums, 0);
        return lists;
    }
    
    private void listAllPermute(List<List<Integer>> lists, int[] nums, int start) {
		if(start == nums.length){
			List<Integer> list = new ArrayList<Integer>();
			for(int i=0; i<nums.length; i++){
				list.add(nums[i]);
			}
			lists.add(list);
		}else{
			for(int i=start; i<nums.length; i++){
				if(isSwap(nums, start, i)){
					swap(nums, start, i);
					listAllPermute(lists, nums, start+1);
					swap(nums, i, start);
				}
			}
		}
		
	}

	private boolean isSwap(int[] nums, int start, int cur) {
		for(int i=start; i<cur; i++){
			if(nums[i] == nums[cur]){
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
	

	public static void main(String[] args){
    	Permutations test = new Permutations();
    	int[] nums = {2, 2, 3};
    	System.out.println(test.permute(nums));
    }
}
