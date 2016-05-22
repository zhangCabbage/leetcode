package zhang.algorithm.leetcode.question53_Maximum_Subarray;

public class MaximumSubarray {
	/**
	 * 最大子字符串的问题，这里有几个扩展可以思考一下：如何打印返回出最大子字符串？<br/>
	 * <br/>
	 * 201 / 201 test cases passed<br/>
	 * Status: Accepted<br/>
	 * Runtime: 2 ms 击败13.99%<br/>
	 * 
	 * @param nums
	 * @return
	 */
    public int maxSubArray(int[] nums) {
        //本题使用动态规划的方法
        int maxSum = nums[0];
        int curSum = nums[0];
        for(int i=1; i<nums.length; i++){
            curSum += nums[i];
            curSum = (curSum>nums[i])?curSum:nums[i];
            maxSum = (curSum>maxSum)?curSum:maxSum;
        }
        return maxSum;
    }
	
	public static void main(String[] args){
		MaximumSubarray test = new MaximumSubarray();
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(test.maxSubArray(nums));
	}
}
