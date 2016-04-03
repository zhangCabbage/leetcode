package zhang.algorithm.leetcode.question1_twosum;

import java.util.Arrays;

public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        stop:for(int i=0; i<nums.length; i++){
        	int j=i;
            while(++j<nums.length){
                if(nums[i]+nums[j]==target){
                    result[0] = i;
                    result[1] = j;
                    break stop;
                }
            }
        }
        return result;
    }
	
	public static void main(String args[]){
		TwoSum test = new TwoSum();
		int[] nums = {0,4,3,0};
		int target = 0;
		System.out.println(Arrays.toString( test.twoSum(nums, target) ));
	}
}
