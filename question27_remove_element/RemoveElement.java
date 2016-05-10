package zhang.algorithm.leetcode.question27_remove_element;

import java.util.Arrays;

public class RemoveElement {
	/**
	 * 雷同于question26，移除重复元素返回非重复个数len，并重置nums前len位为数组中非重复数 <br/>
	 * 击败70.92%
	 * @param nums
	 * @param val
	 * @return
	 */
	public int removeElement(int[] nums, int val) {
		int len = 0;
		for(int i=0; i<nums.length; i++){
			if(nums[i] != val){
				nums[len++] = nums[i];
			}
		}
		
        return len;
    }
	
	public static void main(String[] args){
		RemoveElement test = new RemoveElement();
		int[] nums = {};
		int val = 3;
		System.out.println(test.removeElement(nums, val));
		System.out.println(Arrays.toString(nums));
	}
}
