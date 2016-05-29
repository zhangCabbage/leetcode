package zhang.algorithm.leetcode.question33_Search_in_Rotated_Sorted_Array;

/**
 * Created by zhang_zack on 16/5/29.
 */
public class SearchinRotatedSortedArray {
    /**
     * 总的来说,这道题应该不难的,但是我自己组织代码的能力太差了.代码写的一塌糊涂!<br/>
     * 代码逻辑源于解题逻辑,因为我的解题逻辑比较混乱,所以导致代码逻辑很乱,感觉一个小的逻辑就要写很大一串冗余代码.<br/>
     * <strong>测试结果:</strong><br/>
     * <br/>
     * 194 / 194 test cases passed.<br/>
     * Status: Accepted<br/>
     * Runtime: 1 ms,只击败了6.54%<br/>
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        return recusiveSearch(nums, 0, nums.length-1, target);
    }

    private int recusiveSearch(int[] nums, int start, int end, int target){
        if(start > end){
            return -1;
        }
        if(start == end){
            return nums[start]==target?start:-1;
        }
        int mid = (start+end)/2;
        if(nums[mid] == target){
            return mid;
        }
        boolean isLeftOrder = false;
        if(nums[start] < nums[mid]){
            isLeftOrder = true;
        }
        if(isLeftOrder){
            if(target>=nums[start] && target<=nums[mid-1]){
                //二分查找
                return binarySearch(nums, start, mid-1, target);
            }else{
                return recusiveSearch(nums, mid+1, end, target);
            }
        }else{
            if(target>=nums[mid+1] && target<=nums[end]){
                //二分查找
                return binarySearch(nums, mid+1, end, target);
            }else{
                return recusiveSearch(nums, start, mid-1, target);
            }
        }
    }

    private int binarySearch(int[] nums, int start, int end, int target){
        while(start <= end){
            int mid = (start+end)/2;
            if(target > nums[mid]){
                start = mid+1;
            }else if(target < nums[mid]){
                end = mid-1;
            }else{
                return mid;
            }
        }
        return -1;
    }

    /**
     * 参考别人思路,同样使用二分法查找binarySearch,不过思路更加清晰,代码更加简洁.<br/>
     * <br/>
     * 当我们列举所有情况如下:<br/>
     * 012[3]456<br/>
     * 123[4]560<br/>
     * 234[5]601<br/>
     * 345[6]012<br/>
     *----------<br/>
     * 456[0]123<br/>
     * 560[1]234<br/>
     * 601[2]345<br/>
     * 我们可以发现考察本题在数组左侧循环的条件有两个:<br/>
     * 1) 正常情况下:left<=target<=right<br/>
     * 2) 非正常情况下又有两种情况:<br/>
     *       (1)左侧大于mid的<br/>
     *       (2)左侧小于或等于mid的<br/>
     * 剩下的则为右侧循环条件<br/>
     * <br/>
     * 虽然测试结果跟我的是一样的,但是思路更加清晰易懂<br/>
     * 
     * @param nums
     * @param target
     * @return
     */
    public int search2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left != right){
            int mid = left + ((right - left) >> 1) ;
            if(nums[mid] >= target && target >= nums[left]){
                right = mid;
            }else if((target <= nums[mid] || target >= nums[left]) && nums[mid] < nums[left]){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return nums[left] == target ? left : -1;
    }

    public static void main(String[] args) {
        SearchinRotatedSortedArray test = new SearchinRotatedSortedArray();
        int[] nums = {1, 3, 5};
        int target = 5;
        System.out.println(test.search(nums, target));
        System.out.println(test.search2(nums, target));
    }
}
