package zhang.algorithm.leetcode.question324_Wiggle_Sort_II;

import zhang.algorithm.modelUtil.Array.ArrayTool;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 16/11/15
 * Time: 下午9:05 - 10:44
 * To change this template use File | Settings | File Templates.
 * <p>
 * https://leetcode.com/problems/wiggle-sort-ii/
 * Review Time: 2017-03-26 11:30:55
 * 这道题的总体思想是:
 * -- 把数组分成两部分(小的, 大的)
 * -- 因为小的、大的中间部分可能相等衔接, 所以小组中的大数放在前, 大组中的小数放在后
 * -- 一种解决方案就是: 排序, 中间分隔, 前后分别倒序, 然后交叉
 * -- 但是其实除了要求前后两部分大小分隔开来, 中间衔接相等处分开外, 没有排序要求
 */
public class WiggleSortII {
    //----------------------------------------------------------------------------
    //正常简单思维的暴力解法
    //----------------------------------------------------------------------------

    /**
     * 第一次想到的方法, 虽然时间复杂度和空间复杂度都没有达到标准,但是我尝试这看这个思路对不对
     * [Wrong], when input is {4, 5, 5, 6}
     *
     * @param nums
     */
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int[] copy = new int[len];

        for (int i = 0; i < len / 2; i++) copy[i * 2] = nums[i];
        int start = len / 2;
        if (len % 2 != 0) {
            copy[len - 1] = nums[len / 2];
            start++;
        }
        for (int i = 0; i < len / 2; i++) copy[i * 2 + 1] = nums[start + i];

        System.arraycopy(copy, 0, nums, 0, len);
    }

    /**
     * 其实这个思路接近一个正确结果, 但是最后我放弃了调试解决, 下面是延续这一思路的正确结果
     * https://discuss.leetcode.com/topic/66299/my-java-solution-it-is-fast-and-easy-to-understand/2
     * 确实要分成大小两部分数(small, big), 由于可能会出现 small中个biggest = big中的smallest
     * 所以最后不能简单的相互插入, 这里做一个小技巧: small和big反转
     * small: 1, 2, 3, 3  ->  3, 3, 2, 1
     * big: 3, 3, 4, 5  ->  5, 4 ,3, 3
     * <p>
     * 时间复杂度O(N*logN), 空间复杂度O(N)
     * 44 / 44 test cases passed.
     * Status: Accepted
     * Runtime: 7 ms, bit 62.65%
     *
     * @param nums
     */
    public void wiggleSort3(int[] nums) {
        Arrays.sort(nums);
        int[] copy = new int[nums.length];

        int len = (int) Math.round((double) nums.length / 2);

        //descant order small
        int index = 0;
        for (int i = len - 1; i >= 0; i--) {
            copy[index] = nums[i];
            index += 2;
        }

        //descant order big
        index = 1;
        for (int i = nums.length - 1; i >= len; i--) {
            copy[index] = nums[i];
            index += 2;
        }

        System.arraycopy(copy, 0, nums, 0, nums.length);
    }

    //----------------------------------------------------------------------------
    //O(n)解法的尝试
    //----------------------------------------------------------------------------

    /**
     * 经过考虑后, 给出如下答案, 但是貌似仍然不对。
     * Wrong, 会无限循环
     *
     * @param nums
     */
    public void wiggleSort2(int[] nums) {
        int i = 1;
        while (i < nums.length) {
            if (nums[i] == nums[i - 1]) {
                boolean flag = false;
                int j = i + 1;
                while (true) {
                    if (j == nums.length) {
                        j = 0;
                        flag = true;
                    }
                    if ((i % 2 == 0 && nums[j] < nums[i - 1]) || (i % 2 != 0 && nums[j] > nums[i - 1]))
                        break;
                    j++;
                }
                exchange(nums, i, j);
                if (flag) i = j + 1;
                continue;
            }

            if (i % 2 == 0) {
                if (nums[i] > nums[i - 1]) exchange(nums, i - 1, i);
            } else {
                if (nums[i] < nums[i - 1]) exchange(nums, i - 1, i);
            }
            i++;
        }
    }

    private void exchange(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


    /**
     * 参考StefanPochmann大神之作
     * https://discuss.leetcode.com/topic/32929/o-n-o-1-after-median-virtual-indexing
     * 其实, 主要就是上一个方法的延伸: 上一个方法先排序, 分成两个部分, 分别倒序(倒序的缘由, 见之前所说)
     * 这里其实对于big和small两部分不重复的数字, 我们根本不需要进行排序。
     * <p>
     * 为了达到这一效果我们使用findKthLargest方法来分割nums数组
     * 之后按照[three-way partitioning]的方式, 来移动前后两部分数组。
     * 这一过程跟方法3中的效果是一样的, 进行坐标映射, 之后根据前后值进行exchange
     * big:
     * A(0) -> nums[1]
     * A(1) -> nums[3]
     * A(2) -> nums[5]
     * A(3) -> nums[7]
     * small:
     * A(4) -> nums[0]
     * A(5) -> nums[2]
     * A(6) -> nums[4]
     * A(7) -> nums[6]
     * 越小的放后面 A(6)、A(7)
     * 越大的放前面 A(0)、A(1)
     * 正好跟方法3的思想吻合
     * <p>
     * 44 / 44 test cases passed.
     * Status: Accepted
     * Runtime: 53 ms, bit 40.42%
     *
     * @param nums
     */
    public void wiggleSort4(int[] nums) {
        int n = nums.length;
        int mid = findKthLargest(nums, (n + 1) / 2);
        int left = 0, right = n - 1; // left -> odd, right -> even

        int i = 0;
        while (i <= right) {  //attention please! Here we should use i < right
            int cur = nums[newIndex(i, n)];
            if (cur > mid) {
                exchange(nums, newIndex(left++, n), newIndex(i++, n));
            } else if (cur < mid) {
                exchange(nums, newIndex(right--, n), newIndex(i, n));
            } else {
                i++;
            }
        }
    }

    /**
     * 0, 1, 2 ==> 1, 3, 5
     * 3, 4, 5 ==> 0, 2, 4
     * <p>
     * odd % odd = even, so let n | 1 become a odd
     * [❤❤❤❤]
     * i -> [0, n-1], 故 2*x+1 -> [1, 2*n-1]
     * 所以 2*x+1 % n 顶多为 2*x+1 - n
     * 2*x+1 为奇数, 奇数 - 偶数 永远为奇数, 所以这里我们需要把n转变为奇数
     *
     * @param i
     * @param n
     * @return
     */
    private int newIndex(int i, int n) {
        return (1 + i * 2) % (n | 1);
    }

    /**
     * 让 nums 数组: 左大、右小
     *
     * @param nums
     * @param k
     * @return
     */
    private int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, 0, nums.length - 1, k);
    }

    private int findKthLargest(int[] nums, int start, int end, int k) {
        int l = start;
        int r = end;
        int mid = l + (r - l >> 1);
        choicePovit(nums, l, mid, r);
        int povit = nums[l];

        while (l < r) {
            while (l < r && nums[r] <= povit) r--;
            nums[l] = nums[r];
            while (l < r && nums[l] >= povit) l++;
            nums[r] = nums[l];
        }
        nums[l] = povit;

        if (l - start + 1 == k) return povit;
        else if (l - start + 1 < k) return findKthLargest(nums, l + 1, end, k - (l - start + 1));
        else return findKthLargest(nums, start, l - 1, k);
    }

    /**
     * 选择中间的一个值
     *
     * @param nums
     * @param l
     * @param m
     * @param r
     */
    private void choicePovit(int[] nums, int l, int m, int r) {
        if (nums[l] > nums[m]) {
            if (nums[m] > nums[r]) {
                exchange(nums, m, l);
            } else if (nums[r] > nums[l]) {
                //
            } else {
                exchange(nums, r, l);
            }
        } else {
            if (nums[l] > nums[r]) {
                //
            } else if (nums[r] > nums[m]) {
                exchange(nums, m, l);
            } else {
                exchange(nums, r, l);
            }
        }
    }

    //----------------------------------------------------------------------------
    //----------------------------------------------------------------------------

    public static void main(String[] args) {
        WiggleSortII test = new WiggleSortII();
        int[] nums1 = {1, 5, 1, 1, 6, 4};
        test.wiggleSort3(nums1);
        ArrayTool.printArray(nums1);

        int[] nums2 = {1, 3, 2, 2, 3, 1};
        test.wiggleSort4(nums2);
        ArrayTool.printArray(nums2);
    }
}
