package zhang.algorithm.leetcode.question15_3Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Sum3Zero {
	/**
	 * 给一个integer类型的数组，求其中和为0的三元组<br/>
	 * 借鉴question1中的解题思路，其中使用map和set等来进行检查重复性<br/>
	 * 但是Time Limit Exceeded 
	 * @param nums
	 * @return
	 */
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		Map<Set<Integer>, Integer> map = new HashMap<Set<Integer>, Integer>();
		
		if(nums.length<3) return lists;
		for(int i=0; i<nums.length; i++){
			Set<Integer> set = new HashSet<Integer>();
			int j=i+1;
			while(j<nums.length){
				int res = -nums[i]-nums[j];
				if(set.contains(res)){
					List<Integer> list = new ArrayList<Integer>();
					list.add(nums[i]);
					list.add(nums[j]);
					list.add(res);
					if(map.containsKey(new HashSet<Integer>(list))){
						
					}else{
						map.put(new HashSet<Integer>(list), 1);
						lists.add(list);
					};
					
				}else{
					set.add(nums[j]);
				}
				j++;
			}
		}
		
        return lists;
    }
	
	public List<List<Integer>> threeSum2(int[] nums) {
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		if(nums.length<3) return lists;
		Arrays.sort(nums);
		System.out.println(Arrays.toString(nums));
		
		for(int i=0; i<nums.length; i++){
			if(i!=0 && nums[i]==nums[i-1]){
				//避免重复
				continue;
			}
			
			int start = i+1;
			int end = nums.length-1;
			
			while(start<end){
				if(nums[start]+nums[end]==-nums[i]){
					List<Integer> list = new ArrayList<Integer>();
					list.add(nums[start]);
					list.add(nums[end]);
					list.add(nums[i]);
					lists.add(list);
					start++;
					end--;
				}else if(nums[start]+nums[end]>-nums[i]){
					end--;
				}else if(nums[start]+nums[end]<-nums[i]){
					start++;
				}
			}
		}
		
        return lists;
    }
	
	public static void main(String[] args){
		Sum3Zero test = new Sum3Zero();
		int[] nums = {-1,0,1,2,-1,-4};
		System.out.println(test.threeSum2(nums));
	}
}
