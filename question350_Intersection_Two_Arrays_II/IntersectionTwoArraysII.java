package zhang.algorithm.leetcode.question350_Intersection_Two_Arrays_II;

import zhang.algorithm.modelUtil.Array.ArrayTool;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 16/9/23
 * Time: 下午8:42
 * To change this template use File | Settings | File Templates.
 * <p>
 * 这道题主要是后续问题的解决方案更有思考意义!
 */
public class IntersectionTwoArraysII {
    /**
     * this method is very normal or even bad.
     * Hash Map to solve it.
     * <p>
     * 61 / 61 test cases passed
     * Status: Accepted
     * Runtime: 6 ms ,bit 59.84%
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> temp = new ArrayList();
        for (int num : nums1) {
            Integer value = map.get(num);
            map.put(num, value == null ? 1 : value + 1);
        }
        for (int num : nums2) {
            Integer value = map.get(num);
            if (value != null) {
                temp.add(num);
                if (value - 1 > 0) {
                    map.put(num, value - 1);
                } else {
                    map.remove(num);
                }
            }
        }

        int[] res = new int[temp.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = temp.get(i);
        }
        return res;
    }

    /**
     * first sort then find
     * <p>
     * 61 / 61 test cases passed
     * Status: Accepted
     * Runtime: 3 ms, bit 95.33%
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int start1 = 0;
        int start2 = 0;
        int index = 0;
        while (start1 < nums1.length && start2 < nums2.length) {
            if (nums1[start1] > nums2[start2]) {
                start2++;
            } else if (nums1[start1] < nums2[start2]) {
                start1++;
            } else {
                if (start1 > index) exchange(nums1, start1, index);
                start1++;
                start2++;
                index++;
            }
        }

        int[] res = new int[index];
        System.arraycopy(nums1, 0, res, 0, index);

        return res;
    }

    private void exchange(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }

    public static void main(String[] args) {
        IntersectionTwoArraysII test = new IntersectionTwoArraysII();
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {1, 1};
        ArrayTool.printArray(test.intersect(nums1, nums2));
        ArrayTool.printArray(test.intersect2(nums1, nums2));
    }
}
