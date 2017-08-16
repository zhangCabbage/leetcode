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
     * wrong answer, 第一次没有读懂题意!!
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
     * 第二次尝试
     * 需要使用map和排序,排序算法需要为n*log(n) -> 快排fastsort、堆heap、归并排序
     * <p>
     * 20 / 20 test cases passed
     * Status: Accepted
     * Runtime: 27 ms, bit 84.16%
     *
     * @param nums
     * @param k
     * @return
     */
    public List<Integer> topKFrequent2(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        if (k == 0) return res;

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer count = map.get(num);
            map.put(num, count == null ? 1 : count + 1);
        }
        int[] keys = new int[map.size()];
        int[] values = new int[map.size()];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            keys[i] = entry.getKey();
            values[i++] = entry.getValue();
        }
        //按照Value来排序
        fastSort(values, keys, 0, values.length - 1);

        for (i = 0; i < k; i++) {
            res.add(keys[i]);
        }
        return res;
    }

    public void fastSort(int[] values, int[] keys, int left, int right) {
        int l = left, r = right;
        int provit = values[l];
        int tmp = keys[l];
        while (l < r) {
            while (values[r] <= provit && r > l) r--;
            values[l] = values[r];
            keys[l] = keys[r];
            while (values[l] >= provit && l < r) l++;
            values[r] = values[l];
            keys[r] = keys[l];
        }
        values[l] = provit;
        keys[l] = tmp;
        if (left < l) fastSort(values, keys, left, l - 1);
        if (right > l) fastSort(values, keys, l + 1, right);
    }

    /**
     * 不使用快速排序，使用map后，采用桶排序的方式， nice
     * @param nums
     * @param k
     * @return
     */
    public List<Integer> topKFrequent3(int[] nums, int k){
        List<Integer>[] bucket = new List[nums.length + 1];

        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            frequencyMap.put(nums[i], frequencyMap.getOrDefault(nums[i], 0) + 1);
        }

        for(int key: frequencyMap.keySet()){
            int frequency = frequencyMap.get(key);
            if(bucket[frequency] == null)
                bucket[frequency] = new ArrayList<>();
            bucket[frequency].add(key);
        }

        List<Integer> res = new ArrayList<>(k);
        for (int i = bucket.length - 1; i >= 0 && res.size() < k; i--) {
            if(bucket[i] != null)
                res.addAll(bucket[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        TopKFrequentElements test = new TopKFrequentElements();
        int[] nums = {1, 1, 1, 2, 2, 3, 3};
        int k = 2;
        System.out.println(test.topKFrequent2(nums, k));
        System.out.println(test.topKFrequent3(nums, k));
    }
}
