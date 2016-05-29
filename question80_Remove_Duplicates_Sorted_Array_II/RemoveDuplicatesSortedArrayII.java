package zhang.algorithm.leetcode.question80_Remove_Duplicates_Sorted_Array_II;

import zhang.algorithm.modelUtil.ZhangUtil;

/**
 * Created by zhang_zack on 16/5/29.
 */
public class RemoveDuplicatesSortedArrayII {
    /**
     * 仿佛自己进入一个怪圈,不断的被自己的糟糕想法所阻断,这道题竟然墨迹了我两个多小时!!<br/>
     * 而且悲哀的是还没整出来
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int index = 1;//表示最后的总个数
        int duplicates = 1;

        for(int i=1; i<nums.length; i++){
            //处理重复的数组
            while(i<nums.length && nums[i]==nums[i-1]){
                if(duplicates < 2){
                    index++;
                }
                i++;
                duplicates++;
            }

            if(i >= nums.length){
                if (index-1 != i - 1) {
                    nums[index-1] = nums[i - 1];
                }
            }else{
                duplicates = 1;
                if(index != i){
                    nums[index] = nums[i];
                }
                index++;
            }

        }
        return index;
    }

    /**
     * 借鉴别人思路:优美代码,代码极简化,但是时间复杂度为O(n),就这方面来讲没有什么改进!!<br/>
     * 我这个榆木脑袋,这种方式构建代码简直是太好了!!多么简介就完成了最多重复为2的逻辑<br/>
     *
     * <br/>
     * <strong>测试结果:</strong><br/>
     * 164 / 164 test cases passed.<br/>
     * Status: Accepted<br/>
     * Runtime: 2 ms,只打败了9.23%<br/>
     *
     * @param nums
     * @return
     */
    public int removeDuplicates2(int[] nums) {
        int index = 0;
        for(int n: nums){
            //注意这里为什么使用index来减2,其实也可以使用下标i来减2
            //如下所示:
            if(index<2 || n>nums[index-2]){
                nums[index++] = n;
            }
        }

//        用index还是i都没有关系,因为超过两个index位置就会被i对应位置覆盖
//        for(int i=0; i<nums.length; i++){
//            if(i<2 || nums[i]>nums[i-2]){
//                nums[index++] = nums[i];
//            }
//        }
        return index;
    }

    /**
     * 借鉴别人思路:考虑到题目给定nums为有序数组,并针对题意至少重复两个或者可配置的个数的话,可以减少遍历次数<br/>
     * <br/>
     * 这个方法有点难以理解,但是代码逻辑也是很值得学习的!每次跳两格,相当于时间复杂度仅为O(n/2)<br/>
     *
     * <br/>
     * <strong>测试结果:</strong><br/>
     * 164 / 164 test cases passed.<br/>
     * Status: Accepted<br/>
     * Runtime: 1 ms,击败56.12%<br/>
     *
     * @param nums
     * @return
     */
    public int removeDuplicates3(int[] nums) {
        int index = 0;
        int count = 0;
        while(index < nums.length-2-count){
            if(nums[index] == nums[index+2+count]){
                count++;
            }else{
                nums[index+2] = nums[index+2+count];
                index++;
            }
        }
        return nums.length-count;
    }

    public static void main(String[] args) {
        RemoveDuplicatesSortedArrayII test = new RemoveDuplicatesSortedArrayII();
        int[] nums = {1, 2};
        System.out.println(test.removeDuplicates(nums));
        ZhangUtil.printArray(nums);
    }
}
