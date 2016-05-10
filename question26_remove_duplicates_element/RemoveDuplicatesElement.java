package zhang.algorithm.leetcode.question26_remove_duplicates_element;

import java.util.Arrays;

public class RemoveDuplicatesElement {
	/**
	 * 返回数组不同的长度len并更改nums数组前len为此数组中不同的数 <br/>
	 * 1ms只击败了54%的人
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
	
	public static void main(String[] args){
		RemoveDuplicatesElement test = new RemoveDuplicatesElement();
		int[] nums = {1, 2, 3};
		System.out.println(test.removeDuplicates(nums));
		System.out.println(Arrays.toString(nums));
	}
}
