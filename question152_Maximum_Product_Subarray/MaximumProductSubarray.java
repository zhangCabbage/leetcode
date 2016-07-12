package zhang.algorithm.leetcode.question152_Maximum_Product_Subarray;

/**
 * Created by IntelliJ IDEA.
 * User: zhang_MacPro
 * Date: 16/7/12
 * Time: 下午7:44
 * To change this template use File | Settings | File Templates.
 */
public class MaximumProductSubarray {
    /**
     * use dynamic programming, but my code is not beautiful!!
     * <p>
     * <strong>result of test:</strong><br/>
     * 183 / 183 test cases passed
     * Status: Accepted
     * Runtime: 4 ms, bit 46.06%
     *
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length < 1) return 0;

        int startMin = nums[0];
        int startMax = startMin;
        int max = startMax;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                startMax = Math.max(nums[i], startMax * nums[i]);
                startMin = Math.min(nums[i], startMin * nums[i]);
            } else {
                int temp = startMax;
                startMax = Math.max(nums[i], startMin * nums[i]);
                startMin = Math.min(nums[i], temp * nums[i]);
            }

            //other coding
//            int temp = startMax;
//            startMax = Math.max(Math.max(nums[i], startMax * nums[i]), startMin * nums[i]);
//            startMin = Math.min(Math.min(nums[i], startMin * nums[i]), temp * nums[i]);

            max = Math.max(max, startMax);
        }

        return max;
    }

    /**
     *
     * <strong>result of test:</strong><br/>
     * 183 / 183 test cases passed
     * Status: Accepted
     * Runtime: 2 ms, bit 92.34%
     *
     * @param nums
     * @return
     */
    public int maxProduct2(int[] nums) {
        int len = nums.length;
        if(len == 1) return nums[0];
        int res = 0;
        int maxP = 0, maxN = Integer.MIN_VALUE, minN = 0;
        int tmp = 1, curMax = 0;
        for(int i = 0; i < len; i++){
            if(nums[i] == 0){
                int cur = minN/maxN;
                curMax = maxP>cur? maxP:cur;
                if(curMax > res) res = curMax;
                tmp = 1;
                maxP = 0;
                maxN = Integer.MIN_VALUE;
                minN = 0;
                continue;
            }
            tmp *= nums[i];
            if(tmp > maxP){
                maxP = tmp;
            }
            if(tmp<0 && maxN == Integer.MIN_VALUE){
                maxN = tmp;
            }
            else if(tmp < minN){
                minN = tmp;
            }
        }
        int cur = minN/maxN;
        curMax = maxP>cur? maxP:cur;
        if(curMax > res)res = curMax;
        return res;
    }

    public static void main(String[] args) {
        MaximumProductSubarray test = new MaximumProductSubarray();
        int[] nums = {-2, 0, 0, 3, -4, -1, 2};
        System.out.println(test.maxProduct(nums));
    }
}
