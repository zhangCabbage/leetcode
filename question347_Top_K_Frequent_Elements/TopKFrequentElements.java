package zhang.algorithm.leetcode.question347_Top_K_Frequent_Elements;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 16/10/18
 * Time: 下午10:41
 * To change this template use File | Settings | File Templates.
 */
public class TopKFrequentElements {
    /**
     * wrong answer, 没有读懂题意!!
     *
     * @param nums
     * @param k
     * @return
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        Arrays.sort(nums);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) res.add(nums[i]);
            if (res.size() == k) return res;
        }
        res.add(nums[nums.length - 1]);
        return res;
    }

    /**
     * 需要使用map和排序,排序算法需要为n*log(n) -> 快排fastsort、堆heap、
     *
     * @param nums
     * @param k
     * @return
     */
    public List<Integer> topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer res = map.get(num);
            map.put(num, res == null ? 1 : res + 1);
        }
        int[] keys = new int[map.size()];
        int[] values = new int[map.size()];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            keys[i] = entry.getKey();
            values[i++] = entry.getValue();
        }
        //按照Value来排序

        return null;
    }

    public static void main(String[] args) {
        TopKFrequentElements test = new TopKFrequentElements();
        int[] nums = {4, 1, -1, 2, -1, 2, 3};
        int k = 2;
        System.out.println(test.topKFrequent(nums, k));
    }
}
