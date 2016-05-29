package zhang.algorithm.leetcode.question26_remove_duplicates_element;

import java.util.Arrays;

public class RemoveDuplicatesElement {
	/**
	 * 返回数组不同的长度len并更改nums数组前len为此数组中不同的数 <br/>
	 * 1ms,只击败了54%的人
	 * @param nums
	 * @return
	 */
	public int removeDuplicates(int[] nums) {
		if(nums.length<2)return nums.length;
		int prElement = nums[0];
		int len = 1;
		int curIndex = 1;
		for(int i=0; i<nums.length; i++){
			if(nums[i]!=prElement){
				len++;
				prElement = nums[i];
				if(curIndex!=i){
					nums[curIndex] = nums[i];
				}
				curIndex++;
			}
		}
        return len;
    }
	
	/**
	 * 更简洁的编程，不需要记录变量！
	 * @param nums
	 * @return
	 */
	public int removeDuplicates2(int[] nums) {
		if(nums.length<2)return nums.length;
		int len = 1;
		for(int i=1; i<nums.length; i++){
			if(nums[i]!=nums[i-1]){
				nums[len++] = nums[i];
			}
		}
        return len;
    }
	
	public static void main(String[] args){
		RemoveDuplicatesElement test = new RemoveDuplicatesElement();
		int[] nums = {1, 1, 2};
		System.out.println(test.removeDuplicates(nums));
		System.out.println(Arrays.toString(nums));
	}
}
