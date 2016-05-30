package zhang.algorithm.leetcode.question81_Search_in_Rotated_Sorted_Array_II;

/**
 * Created by zhang_zack on 16/5/30.
 */
public class SearchRotatedSortedArrayII {
    /**
     * 这道题直接使用question33的方法并不能AC成功,为什么呢?<br/>
     * 针对举出的栗子:13111,通过left\mid\right,完全看不出来到底该属于左循环还是右循环<br/>
     * 这里对上一个算法做了改进,当左右相同的时候,那么我们就一直向前移动left下标,直到left和mid对应的值不同为止<br/>
     * <br/>
     * <strong>测试结果:</strong><br/>
     * 271 / 271 test cases passed.<br/>
     * Status: Accepted<br/>
     * Runtime: 1 ms,击败了23.7%<br/>
     *
     * @param nums
     * @param target
     * @return
     */
    public boolean search(int[] nums, int target) {
         int left = 0;
         int right = nums.length-1;
         while(left != right){
             int mid = (left+right)/2;
             if(nums[mid] == target){
                 return true;
             }
             while(left<mid && nums[left]==nums[mid]){
                 left++;
             }

             if(target>=nums[left] && target<nums[mid]){
                 right = mid-1;
             }else if((target<nums[mid] || target>=nums[left]) && nums[left]>nums[mid]){
                 right = mid-1;
             }else{
                 left = mid+1;
             }
         }
         return nums[left]==target ? true : false;
    }

    /**
     * 对以上程序可以做如下改进<br/>
     * @param nums
     * @param target
     * @return
     */
    public boolean search2(int[] nums, int target) {
        if(nums==null || nums.length==0){
            return false;
        }
        int left = 0;
        int right = nums.length-1;
        while(left <= right){
            int mid = (left+right)/2;
            if(nums[mid] == target){
                return true;
            }

            if(left<mid && nums[left]==nums[mid]){
                left++;
            }else{
                if(target>=nums[left] && target<nums[mid]){
                    right = mid-1;
                }else if((target<nums[mid] || target>=nums[left]) && nums[left]>nums[mid]){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }

        }
        return nums[left]==target ? true : false;
    }

    public static void main(String[] args) {
        SearchRotatedSortedArrayII test = new SearchRotatedSortedArrayII();
        int[] nums = {1,3,1,1,1};
        int target = 3;
        System.out.println(test.search(nums, target));
        System.out.println(test.search2(nums, target));
    }
}
