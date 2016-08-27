package zhang.algorithm.leetcode.question384_Shuffle_Array;


import zhang.algorithm.modelUtil.Array.ArrayTool;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 16/8/27
 * Time: 下午9:13
 * To change this template use File | Settings | File Templates.
 */
public class ShuffleArray {

    private int[][] alls = null;
    private int facNum = 0;

    public ShuffleArray(int[] nums) {
        facNum = factorial(nums.length);
        this.alls = new int[facNum][nums.length];

        for(int i=0; i<facNum; i++){
            int[] shuffleNums = new int[nums.length];
            System.arraycopy(nums, 0, shuffleNums, 0, nums.length);
            alls[i] = shuffleNums;

            shuffle(nums);
        }
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return this.alls[0];
    }

    /**
     * Returns a random shuffling of the array.
     * this is ok, but to many shuffle handle is Time Limit Exceeded
     */
    public int[] shuffle() {
        int random = (int) (Math.random() * facNum); //0 - facNum-1

        return this.alls[random];
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
