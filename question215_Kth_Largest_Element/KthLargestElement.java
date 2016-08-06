package zhang.algorithm.leetcode.question215_Kth_Largest_Element;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: zhang_MacPro
 * Date: 16/8/1
 * Time: 上午11:11
 * To change this template use File | Settings | File Templates.
 */
public class KthLargestElement {

    /**
     * use sort the time complexity is O(n*logn)
     * <p>
     * <strong>result of test:</strong>
     * 31 / 31 test cases passed
     * Status: Accepted
     * Runtime: 4 ms, bit 77.98%
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    /**
     * use the fast find method, the time complexity is O(n)
     * But it looks like more slow than the way that first sort
     * and then find the kth largest element
     * <p>
     * <strong>result of test:</strong>
     * 31 / 31 test cases passed
     * Status: Accepted
     * Runtime: 55 ms, bit 26.22%
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest2(int[] nums, int k) {
        //使用快速查找的方法
        //unsorted array
        return quickFind(nums, 0, nums.length - 1, k);
    }

    private int quickFind(int[] nums, int start, int end, int k) {
        int provitKey = nums[(int) Math.random() * (end - start) + start];
        int left = start;
        int right = end;

        while (left < right) {
            while (nums[right] > provitKey) right--;
            nums[left] = nums[right];
            while (left < right && nums[left] <= provitKey) left++;
            nums[right] = nums[left];
        }
        if (end - left + 1 == k) return provitKey;
        else if (end - left + 1 < k) return quickFind(nums, start, left - 1, k - (end - left + 1));
        else return quickFind(nums, left + 1, end, k);
    }

    /**
     * this method is also use fast find to find the kth largest number.
     * But it is more faster than yours
     * <p>
     * <strong>result of test:</strong>
     * 31 / 31 test cases passed
     * Status: Accepted
     * Runtime: 1 ms, bit 99.44%
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest3(int[] nums, int k) {
        int n = nums.length;
        int target = n - k;
        quicksort(nums, 0, n - 1, target);
        return nums[n - k];
    }

    private void quicksort(int[] nums, int start, int end, int target) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        int pivot = choosePivot(nums[mid], nums[start], nums[end]);
        //int pivot = nums[mid];
        int i = start;
        int j = end;
        while (i <= j) {
            while (nums[i] < pivot) {
                i++;
            }
            while (nums[j] > pivot) {
                j--;
            }
            if (i <= j) {
                if (nums[i] != nums[j]) {
                    swap(nums, i, j);
                }
                i++;
                j--;
            }
        }
        if (target <= i - 1) {
            quicksort(nums, start, i - 1, target);
        } else {
            quicksort(nums, i, end, target);
        }
    }

    private int choosePivot(int a, int b, int c) {
        if (a > b) {
            if (c > a) {
                return a;
            } else if (c > b) {
                return c;
            } else {
                return b;
            }
        } else {
            if (c > b) {
                return b;
            } else if (c > a) {
                return c;
            } else {
                return a;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
