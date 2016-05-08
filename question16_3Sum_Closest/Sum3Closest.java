package zhang.algorithm.leetcode.question16_3Sum_Closest;

import java.util.Arrays;

public class Sum3Closest {
	/**
	 * 结合上一题3Sum的经验，稍微变形一下既可通过<br/>
	 * 10ms
	 * @param nums
	 * @param target
	 * @return
	 */
	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int distance = Integer.MAX_VALUE;//表示3个数之和与目标值之间的差距
		int closestSum = 0;
		for(int i=0; i<nums.length; i++){
			if(i!=0 && nums[i]==nums[i-1]){
				continue;
			}
			int targetTwoSum = target-nums[i];
			int start = i+1;
			int end = nums.length-1;
			while(start<end){
				int currTwoSum = nums[start]+nums[end];
				if(targetTwoSum == currTwoSum){
					return target;
				}
				if(currTwoSum < targetTwoSum){
					start++;
				}else if(currTwoSum > targetTwoSum){
					end--;
				}
				if(Math.abs(targetTwoSum-currTwoSum)<distance){
					distance = Math.abs(targetTwoSum-currTwoSum);
					closestSum = currTwoSum + nums[i];
				}
			}
		}
		return closestSum;
    }
	
	public static void main(String[] args){
		Sum3Closest test = new Sum3Closest();
		int[] nums = {0,0,0};
		System.out.println(test.threeSumClosest(nums, 1));
	}
}
