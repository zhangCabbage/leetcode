package zhang.algorithm.leetcode.question35_Search_Insert_Position;

public class SearchInsertPosition {
	/**
	 * 给定一个有序数组和一个目标数字，如果目标值在数组中返回其下标，如果不在那么返回它应该插入数组的位置下标<br/>
	 * 采用二分查找的方法，能很快找出结果，AC毫无压力！<br/>
	 * @param nums
	 * @param target
	 * @return
	 */
    public int searchInsert(int[] nums, int target) {
    	int start = 0;
    	int end = nums.length-1;
    	while(start<=end){
    		int mid = (start+end)/2;
    		if(nums[mid] < target){
    			start = mid+1;
    		}else if(nums[mid] > target){
    			end = mid-1;
    		}else{
    			return mid;
    		}
    	}
        return end+1;
    }
    
    public static void main(String[] args){
    	SearchInsertPosition test = new SearchInsertPosition();
    	int[] nums = {};
    	int target = 4;
    	System.out.println( test.searchInsert(nums, target) );
    }
}
