package zhang.algorithm.leetcode.question349_Intersection_Two_Arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA.
 * User: zhang_MacPro
 * Date: 16/8/24
 * Time: 下午10:36
 * To change this template use File | Settings | File Templates.
 */
public class IntersectionArrays {
    /**
     * <strong>result of test:</strong>
     * 60 / 60 test cases passed
     * Status: Accepted
     * Runtime: 7 ms, bit 35.29%
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> map = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        for (int n : nums1) {
            map.add(n);
        }
        for (int n : nums2) {
            if (map.contains(n)) {
                set.add(n);
            }
        }
        int[] res = new int[set.size()];
        int i = 0;
        for (int n : set) {
            res[i++] = n;
        }

        return res;
    }

    /**
     * use the jdk8 new API function
     * <strong>result of test:</strong>
     * 60 / 60 test cases passed
     * Status: Accepted
     * Runtime: 122 ms, bit 0.91%
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection2(int[] nums1, int[] nums2) {
        Set<Integer> set = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        return Arrays.stream(nums2).distinct().filter(x -> set.contains(x)).toArray();
    }

    public static void main(String[] args) {
        IntersectionArrays test = new IntersectionArrays();
    }
}
