package zhang.algorithm.leetcode.question88_Merge_Sorted_Array;

import zhang.algorithm.modelUtil.ZhangUtil;

/**
 * Created by zhang_zack on 16/6/1.
 */
public class MergeSortedArray {
    /**
     * 貌似这么简单的代码我竟然纯手写眼调试,我竟然花了不少时间才完成,
     * 逻辑大体知道,但是就是码代码的时候细节仍不能很好的表达<br/>
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i=m; i>0; i--){
            nums1[n+i-1] = nums1[i-1];
        }

        int index = 0;
        int i = 0;
        int j = 0;
        while(i<m && j<n){
            if(nums1[n+i] < nums2[j]){
                nums1[index++] = nums1[n+(i++)];
            }else{
                nums1[index++] = nums2[j++];
            }
        }
        while(j<n){
            nums1[index++] = nums2[j++];
        }
    }

    /**
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int index = m+n;
        m--;
        n--;
        while(--index>=0){
            if((m>=0&&n>=0) && nums1[m]>nums2[n]){
                nums1[index] = nums1[m--];
            }else if(n>=0){
                nums1[index] = nums2[n--];
            }
        }
    }

    public static void main(String[] args) {
        MergeSortedArray test = new MergeSortedArray();
        int[] nums1 = {1, 3, 5, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 4, 6};
        int n = 3;
        test.merge2(nums1, m, nums2, n);
        ZhangUtil.printArray(nums1);
    }
}
