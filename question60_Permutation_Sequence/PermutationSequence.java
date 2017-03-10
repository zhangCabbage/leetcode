package zhang.algorithm.leetcode.question60_Permutation_Sequence;

import zhang.algorithm.modelUtil.ZhangUtil;

public class PermutationSequence {
    /**
     * <strong>题目描述：</strong>给定一个n值，进行有序1-n之间的顺序排列。并返回第k个排列对应的String值 <br/>
     * <br/>
     * 因为排列问题之前详细研究过，所以这道题基本跟我研究过的解决方案没多大区别，微小更改就能适用在本题！！<br/>
     * 而且本题不用考虑特例情况，基本没有比如n为2，k为5这种情况！！
     * <br/>
     * 我忘了考虑了，总共有n！这么多种排列情况，那么如果我们顺序来的话，算最后一个排列的时间复杂度就是O(n!)，简直不得了啊！<br/>
     * Status: Time Limit Exceeded<br/>
     *
     * @param n
     * @param k
     * @return
     */
    public String getPermutation(int n, int k) {
        int[] permute = new int[n];
        for (int i = 1; i <= n; i++) {
            permute[i - 1] = i;
        }

        //按一定的规律得到下一个排列的方法，如此方法要得到第k个排列需要循环k-1次
        //因为第一个排列就为以上赋值的permute本身！所以只需要循环k-1次
        for (int i = k - 1; i > 0; i--) {
            getNextPermute(permute, n);
        }

        //把int数组转换成String对象数据
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sb.append(permute[i]);
        }
        return sb.toString();
    }

    private void getNextPermute(int[] permute, int n) {
        for (int i = n - 2; i >= 0; i--) {
            if (permute[i] < permute[i + 1]) {
                int j = n - 1;
                while (permute[i] > permute[j]) {
                    j--;
                }
                //交换两者
                swap(permute, i, j);
                //把i之后的数进行排序，其实也就是进行倒置就可以了
                reverse(permute, i + 1, n - 1);
                return;
            }
        }
        reverse(permute, 0, n - 1);
        return;
    }

    private void reverse(int[] permute, int start, int end) {
        int len = (end - start + 1) / 2;
        for (int i = 0; i < len; i++) {
            int temp = permute[start + i];
            permute[start + i] = permute[end - i];
            permute[end - i] = temp;
        }

    }

    private void swap(int[] permute, int i, int j) {
        int temp = permute[i];
        permute[i] = permute[j];
        permute[j] = temp;
    }

    //--------------------------------------------------------------------------------------------
    //Second Method
    //--------------------------------------------------------------------------------------------

    /**
     * 针对只求某一个排列的情况，这里我进行了更改，通过运算直接拿到当前的数字，快很多<br/>
     *
     * @param n
     * @param k
     * @return
     */
    public String getPermutation2(int n, int k) {
        int[] permute = new int[n];
        for (int i = 1; i <= n; i++) {
            permute[i - 1] = i;
        }

        int[] values = new int[n];//对应存储n！
        for (int i = 1; i < n; i++) {
            int totalResult = 1;
            for (int j = 1; j <= i; j++) {
                totalResult *= j;
            }
            values[i] = totalResult;
        }

        StringBuffer sb = new StringBuffer();
        //对k进行操作
        k--;
        for (int i = 1; i < n; i++) {
            int index;
            index = k / values[n - i];

            for (int j = 0; j < n; j++) {
                if (permute[j] != -1) {
                    index--;
                    if (index < 0) {
                        sb.append(permute[j]);
                        permute[j] = -1;
                        break;
                    }
                }
            }

            k = k % values[n - i];
        }

        for (int i = 0; i < n; i++) {
            if (permute[i] != -1) {
                sb.append(permute[i]);
            }
        }
        return sb.toString();
    }

    //--------------------------------------------------------------------------------------------
    //Review Time: 2017-03-04 20:45:11
    //Three Method, the same as second method. 更加简洁 !!
    //--------------------------------------------------------------------------------------------

    /**
     * 200 / 200 test cases passed.
     * Status: Accepted
     * Runtime: 15 ms, bit 89.30%
     *
     * @param n
     * @param k
     * @return
     */
    public String getPermutation3(int n, int k) {
        int[] permFlag = new int[n];

        int[] values = new int[n];
        for (int i = 1; i < n; i++) {
            if (i == 1) values[i] = 1;
            else values[i] = values[i - 1] * i;
        }

        StringBuilder sb = new StringBuilder();
        k--;
        for (int i = 1; i < n; i++) {
            int index = k / values[n - i]; //就算index = 0, 仍然可以选择一个
            for (int j = 0; j < n; j++) {
                if (permFlag[j] != -1) {
                    if (index == 0) {
                        sb.append(j + 1);
                        permFlag[j] = -1;
                        break;
                    }
                    index--;
                }
            }
            k %= values[n - i];
        }

        for (int i = 0; i < n; i++)
            if (permFlag[i] != -1)
                sb.append(i + 1);

        return sb.toString();
    }


    public static void main(String[] args) {
        PermutationSequence test = new PermutationSequence();
        int n = 9;
        int k = 87677;

        long start1 = System.currentTimeMillis();
        System.out.println(test.getPermutation(n, k));
        long end1 = System.currentTimeMillis();
        System.out.println("方法一总耗时----> " + (end1 - start1) + "ms");

        long start2 = System.currentTimeMillis();
        System.out.println(test.getPermutation2(n, k));
        long end2 = System.currentTimeMillis();
        System.out.println("方法二总耗时----> " + (end2 - start2) + "ms");

        ZhangUtil.setStartTime();
        System.out.println(test.getPermutation3(n, k));
        System.out.println("方法三总耗时----> " + ZhangUtil.getIntervalTime() + "ms");
    }
}
