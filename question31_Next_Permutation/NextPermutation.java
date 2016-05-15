package zhang.algorithm.leetcode.question31_Next_Permutation;

import java.util.Arrays;

public class NextPermutation {
	/**
	 * 根据当前数组查找下一个排列情况 <br/>
	 * AC--->2ms <br/>
	 * 这道题我在modelUtil中的Permutation排列类中写过类似的一个小模块，拿来做微小的改动即可！
	 * @param nums
	 */
	public void nextPermutation(int[] nums) {
		if(nums.length<2){return;}
        int cur = nums.length;
		while(cur > 1){
			cur--;
        	if(nums[cur-1] < nums[cur]){
        		int next = nums.length-1;
        		while(nums[next] <= nums[cur-1]){
        			next--;
        		}
        		swap(nums, cur-1, next);
        		reverse(nums, cur, nums.length-1);
        		return;
        	}
        }
		if(cur == 1){
			//全部倒置
			reverse(nums, 0, nums.length-1);
		}
    }
	
	public void swap(int[] nums, int start, int end){
		int temp = nums[start];
		nums[start] = nums[end];
		nums[end] = temp;
	}
	
	public void reverse(int[] nums, int start, int end){
		int len = end-start+1;
		for(int i=0; i<len/2; i++){
			swap(nums, start+i, end-i);
		}
	}
	
	public static void main(String[] args){
		NextPermutation test = new NextPermutation();
		int[] nums = {10,9,8,7,6,5,4,3,2,1};
		test.nextPermutation(nums);
		System.out.println(Arrays.toString(nums));
	}
}
