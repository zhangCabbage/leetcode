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
    //------------------------------------------------------------------------
    //------------------------------------------------------------------------

    /**
     * 方法一: 使用系统自带快速排序
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

    //------------------------------------------------------------------------
    //------------------------------------------------------------------------

    /**
     * use the fast find method, the time complexity is O(n)
     * But it looks like more slow than the way that first sort
     * and then find the kth largest element
     * <p>
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest2(int[] nums, int k) {
        //使用快速查找的方法
        //unsorted array
        return quickFind3(nums, 0, nums.length - 1, k);
    }

    /**
     * 方法二: 每次使用第一个元素作为povit进行快速查找, 【思想在, 效果不好, 不推荐】
     * Because of the key choose, when change the provitKey to the mid it is 2ms
     * <p>
     * <strong>result of test:</strong>
     * 31 / 31 test cases passed
     * Status: Accepted
     * Runtime: 55 ms, bit 26.22%
     *
     * @param nums
     * @param start
     * @param end
     * @param k
     * @return
     */
    private int quickFind(int[] nums, int start, int end, int k) {
        int provitKey = nums[start];
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
     * 方法三: 每次使用start、mid、end的中值作为povit, 【推荐】
     * <strong>result of test:</strong>
     * 31 / 31 test cases passed
     * Status: Accepted
     * Runtime: 2 ms, bit 95.12%
     *
     * @param nums
     * @param start
     * @param end
     * @param k
     * @return
     */
    private int quickFind2(int[] nums, int start, int end, int k) {
        int mid = start + ((end - start) >> 1);
        choosePovit(nums, start, mid, end);
        int povit = nums[start];

        int left = start;
        int right = end;
        while (left < right) {
            while (nums[right] > povit) right--;
            nums[left] = nums[right];
            while (left < right && nums[left] <= povit) left++;
            nums[right] = nums[left];
        }

        if (end - left + 1 == k) return povit;
        else if (end - left + 1 < k) return quickFind2(nums, start, left - 1, k - (end - left + 1));
        else return quickFind2(nums, left + 1, end, k);
    }

    /**
     * ×××××××××××
     * 【Wrong】
     * ×××××××××××
     *
     * @param nums
     * @param start
     * @param end
     * @param k
     * @return
     */
    private int quickFind3(int[] nums, int start, int end, int k) {
        int mid = start + ((end - start) >> 1);
        int povit = choosePivot(nums[start], nums[mid], nums[end]);

        int l = start;
        int r = end;
        while (l < r) {
            while (nums[l] < povit) l++;
            while (nums[r] > povit) r--;
            if (l < r) {
                if (nums[l] != nums[r]) {
                    swap(nums, l, r);
                }
                l++;
                r--;
            }
        }

        if (end - l + 1 == k) return povit;
        else if (end - l + 1 < k) return quickFind3(nums, start, l - 1, k - (end - l + 1));
        else return quickFind3(nums, l + 1, end, k);
    }

    //------------------------------------------------------------------------
    //------------------------------------------------------------------------

    /**
     * 方法四: 自己写快速排序的方法
     * this method use fast sort improvement by this special problem
     * it is a very fast way.
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
    public int findKthLargest4(int[] nums, int k) {
        int n = nums.length;
        int target = n - k;
        quicksort(nums, 0, n - 1, target);
        return nums[n - k];
    }

    //------------------------------------------------------------------------
    //------------------------------------------------------------------------

    /**
     * 方法五: 使用中间的数作为povit
     * 2ms
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest5(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k);
    }

    private int quickSelect(int[] array, int left, int right, int k) {
        int i = left, j = right;

        // 每次选中间的
        int mid = (left + right) / 2;
        int tmp = array[mid];
        array[mid] = array[left];
        array[left] = tmp;

        int base = array[i];

        // 类似快排的挖坑填数过程
        while (i < j) {
            while (i < j && array[j] < base) {
                j--;
            }
            if (i < j)
                array[i++] = array[j];

            while (i < j && array[i] >= base) {
                i++;
            }
            if (i < j)
                array[j--] = array[i];

        }
        array[i] = base;

        if (k <= i) {
            return quickSelect(array, left, i - 1, k);
        } else {
            if (k >= i + 2) {
                return quickSelect(array, i + 1, right, k);
            } else {
                return array[i];
            }
        }
    }

    /**
     * @param nums
     * @param start
     * @param end
     * @param target
     */
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

    /**
     * choose the mid one of a、b、c, In order to avoid the fast sort degradation
     *
     * @param a
     * @param b
     * @param c
     * @return
     */
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

    /**
     * choose the mid of i, b, c
     *
     * @param l
     * @param m
     * @param r
     * @return
     */
    private void choosePovit(int[] nums, int l, int m, int r) {
        if (nums[l] > nums[m]) {
            if (nums[m] > nums[r]) {
                swap(nums, m, l);
            } else if (nums[r] > nums[l]) {
                //
            } else {
                swap(nums, r, l);
            }
        } else {
            if (nums[l] > nums[r]) {
                //
            } else if (nums[r] > nums[m]) {
                swap(nums, m, l);
            } else {
                swap(nums, r, l);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


    public static void main(String[] args) {
        KthLargestElement test = new KthLargestElement();
        int[] nums = {7, 6, 5, 4, 3, 2, 1};
        int k = 2;
    }
}
