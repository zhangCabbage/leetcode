package zhang.algorithm.leetcode.question34_Search_Range;

import java.util.Arrays;

public class SearchRange {
	/**
	 * 给定一个有序整数数组和一个目标值，以O(log n)的复杂度找到目标值在数组中的起始和结束下标，查找不成功返回[-1, -1] <br/>
	 * <br/>
	 * AC--->0ms <br/>
	 * @param nums
	 * @param target
	 * @return
	 */
    public int[] searchRange(int[] nums, int target) {
    	int[] result = new int[2];
    	result[0] = binarySearch(nums, target, 0);
    	result[1] = binarySearch(nums, target, 1);
    	return result;
    }
    /**
     * 使用变形的二分查找
     * @param nums
     * @param target
     * @param flag 标记字段，flag=0时求最小值，flag=1时求最大值
     * @return
     */
    public int binarySearch(int[] nums, int target, int flag){
    	int start = 0;
    	int end = nums.length-1;
    	
    	if(flag==0 && nums[start]==target){
    		return start;
    	}
    	if(flag==1 && nums[end]==target){
    		return end;
    	}
    	
    	while(start < end){
    		//这两步骤尤其注意，当flag为0找最小下标时，此mid自动向左边偏；而当flag为1时需要找最大下标，为了使mid向右边偏就得自增1
    		int mid = (start+end)/2;
    		if(flag == 1){
    			mid++;
    		}
    		if(nums[mid] < target){
    			start = mid+1;
    		}else if(nums[mid] > target){
    			end = mid-1;
    		}else{
    			//如果相等的话
    			if(flag == 0){
    				end = mid;
    			}else if(flag == 1){
    				start = mid;
    			}
    		}
    	}
    	if(start<nums.length && nums[start] == target){
    		return start;
    	}
    	return -1;
    }
	
	public static void main(String[] args){
		SearchRange test = new SearchRange();
		int[] nums = {7, 7};
		int target =8;
//		System.out.println(Arrays.binarySearch(nums, target));
		System.out.println( Arrays.toString( test.searchRange(nums, target) ) );
	}
}
