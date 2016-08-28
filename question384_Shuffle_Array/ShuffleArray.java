package zhang.algorithm.leetcode.question384_Shuffle_Array;


import zhang.algorithm.modelUtil.Array.ArrayTool;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 16/8/27
 * Time: 下午9:13
 * To change this template use File | Settings | File Templates.
 * 1) first time
 * this problem I try to use generate a random num then find the permutation of this array
 * but it is Time Limit Exceeded
 * 2) second time
 * then I want to generate all permutation and storage those result in a two dimen array
 * but it is Memory Limit Exceeded in the case [1,2,3,4,5,6,7,8,9,10,11,12]
 */
public class ShuffleArray {

//    private int[][] alls = null;
//    private int facNum = 0;
//
//    public ShuffleArray(int[] nums) {
//        facNum = factorial(nums.length);
//        this.alls = new int[facNum][nums.length];
//
//        for(int i=0; i<facNum; i++){
//            int[] shuffleNums = new int[nums.length];
//            System.arraycopy(nums, 0, shuffleNums, 0, nums.length);
//            alls[i] = shuffleNums;
//
//            shuffle(nums);
//        }
//    }
//
//    /**
//     * Resets the array to its original configuration and return it.
//     */
//    public int[] reset() {
//        return this.alls[0];
//    }
//
//    /**
//     * Returns a random shuffling of the array.
//     * this is ok, but to many shuffle handle is Time Limit Exceeded
//     */
//    public int[] shuffle() {
//        int random = (int) (Math.random() * facNum); //0 - facNum-1
//
//        return this.alls[random];
//    }

    //---------------------------------------------------------------
    //other method
    //---------------------------------------------------------------
    private int[] oriNums;

    public ShuffleArray(int[] nums) {
        this.oriNums = nums;
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return this.oriNums;
    }

    /**
     * Returns a random shuffling of the array.
     * <p>
     * <strong>result of test:</strong>
     * 10 / 10 test cases passed
     * Status: Accepted
     * Runtime: 319 ms
     */
    public int[] shuffle() {
        Random random = new Random();
        List<Integer> list = new ArrayList<>();
        for (int num : oriNums) {
            list.add(num);
        }

        int[] shuffleNums = new int[oriNums.length];
        int size = list.size();

        for (int i = 0; i < size; i++) {
            int index = random.nextInt(list.size());
            shuffleNums[i] = list.get(index);
            list.remove(index);
        }

        return shuffleNums;
    }

    /**
     * the new method to get the random array
     * recursive the size of array times to swap the random index and num from size-1 to 0
     * <p>
     * <strong>result of test:</strong>
     * 10 / 10 test cases passed
     * Status: Accepted
     * Runtime: 301 ms
     *
     * [mathematical entity](http://www.dionysia.org/html/entities/symbols.html)
     *
     * @return
     */
    public int[] shuffle2() {
        Random random = new Random();
        int size = oriNums.length;
        int[] shuffleNums = new int[size];
        System.arraycopy(this.oriNums, 0, shuffleNums, 0, size);

        while (size > 0) {
            int index = random.nextInt(size);
            swap(shuffleNums, index, --size);
        }

        return shuffleNums;
    }


    public int factorial(int n) {
        //IntMath.factorial(n)
        int res = 1;
        for (int i = 1; i <= n; i++) {
            res *= i;
        }

        return res;
    }

    public void shuffle(int[] nums) {
        int swapIndex = nums.length - 1;

        while (swapIndex > 0) {
            if (nums[swapIndex] > nums[swapIndex - 1]) {
                int cur = nums.length - 1;
                while (nums[cur] < nums[swapIndex - 1]) {
                    cur--;
                }
                swap(nums, swapIndex - 1, cur);
                reverse(nums, swapIndex, nums.length - 1);
                return;
            }
            swapIndex--;
        }
        reverse(nums, 0, nums.length - 1);
    }

    public void reverse(int[] array, int start, int end) {
        int i = start, j = end;
        while (i < j) {
            swap(array, i++, j--);
        }
    }

    /**
     * 交换数组中两个数
     */
    public void swap(int[] nums, int m, int n) {
        int temp = nums[m];
        nums[m] = nums[n];
        nums[n] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        ShuffleArray test = new ShuffleArray(nums);
        int count = 50;
        while (count-- > 0) {
            ArrayTool.printArray(test.shuffle());
        }

    }
}
