package zhang.algorithm.leetcode.question1_twosum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 这是在假设一定有解的情况下
 * @author DELL
 *
 */
public class TwoSum {
	/**
	 * 最笨的首先想到的方法：遍历一遍所有的数，对每个数遍历其后所有的数，复杂度为O(n^2)
	 * @param nums
	 * @param target
	 * @return
	 */
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
	
	/**
	 * 借助hashMap来实现，只需遍历一遍，用hashMap存下之前所有的数，每次遍历新的一个数，使用target-当前数
	 * 看结果是否在map中存放着
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] twoSum2(int[] nums, int target){
		int[] result = new int[2];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0; i<nums.length; i++){
			int res = target-nums[i];
			if(map.containsKey( res )){
				result[0] = map.get(res);
				result[1] = i;
				break;
			}
			map.put(nums[i], i);
		}
		return result;
	}
	
	/**
	 * 不借助hashMap<br/>
	 * 首先使用快速排序把数组有序化，时间复杂度为O(n*lgn)
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] twoSum3(int[] nums, int target){
		int[] result = new int[2];
		int[] nums_sorted = new int[nums.length];
		System.arraycopy(nums, 0, nums_sorted, 0, nums.length);
		Arrays.sort(nums_sorted);
		
		int start=0;
		int end=nums_sorted.length;
		while(start<end){
			while(nums_sorted[start]+nums_sorted[--end]>target);
			if(nums_sorted[start]+nums_sorted[end]==target)
				break;
			while(nums_sorted[++start]+nums_sorted[end]<target);
			if(nums_sorted[start]+nums_sorted[end]==target)
				break;
		}
		
		//之后循环遍历最初的数组找到下标indices
		int index = 0;
		int a = nums_sorted[start];
		int b = nums_sorted[end];
		for(int i=0; i<nums.length; i++){
			if(nums[i]==a || nums[i]==b){
				result[index++] = i;
			}
		}
		
		return result;
	}
	
	public static void main(String args[]){
		TwoSum test = new TwoSum();
		int[] nums = {0,4,3,0};
		int target = 0;
		System.out.println(Arrays.toString( test.twoSum(nums, target) ));
		System.out.println(Arrays.toString( test.twoSum2(nums, target) ));
		System.out.println(Arrays.toString( test.twoSum3(nums, target) ));
	}
}
